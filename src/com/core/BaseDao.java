package com.core;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

public class BaseDao<T> {
	private static final Logger LOG = LoggerFactory.getLogger(BaseDao.class);
	private Class<T> entityClass;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	// 通过反射获取子类确定的泛型类
	public BaseDao() { 
	  Type genType = getClass().getGenericSuperclass(); 
	  Type[] params = ((ParameterizedType) genType).getActualTypeArguments(); 
	  entityClass = (Class<T>) params[0];
	}
	
	//根据ID加载PO实例 
	public T load(Serializable id) {
		return (T)hibernateTemplate.load(entityClass, id);
	}
	//根据ID获取PO实例 
	public T get(Serializable id) {
		return (T)hibernateTemplate.load(entityClass, id);
	}
	
	//获取PO的所有对象
	public List<T> loadAll() { 
		hibernateTemplate.setCacheQueries(true);
		return hibernateTemplate.loadAll(entityClass);
	}
	// 保存PO
	public void save(T entity) throws DataAccessException {
		hibernateTemplate.save(entity);
	}
	
	// 保存PO
	public void saveorupdate(T entity) throws DataAccessException {
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	// 删除PO
	public void delete(T entity) throws DataAccessException {
		hibernateTemplate.delete(entity);
	}

    // 删除PO
	public void deleteAll(List<?> entitys) throws DataAccessException {
		hibernateTemplate.deleteAll(entitys);
	}
	
	//更改PO 
	public void update(T entity) throws DataAccessException {
	  hibernateTemplate.update(entity); 
	}
	
	//执行HQL查询 
	public List<?> find(String hql) { 
	  return this.hibernateTemplate.find(hql); 
	} 
	//执行带参的HQL查询 
	public List<?> find(String hql, Object... params) { 
	  return this.hibernateTemplate.find(hql,params);
	}
	 //对延迟加载的实体PO执行初始化 
	public void initialize(Object entity) { 
	  this.hibernateTemplate.initialize(entity); 
	}
	
	
	//创建Query对象 
	public Query createQuery(String hql, Object... values) {
	  Assert.hasText(hql);
	  Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
	  for (int i = 0; i < values.length; i++) { 
	    query.setParameter(i, values[i]); 
	  } 
	  return query;
	} 
	
	/** 
	* HQL分页查询,可以指定具体的模式, 
	* 采用getCount方式,须在此层完成hsql的转换与查询。 
	* 注意参数Object...args的应用,可以在查询的设置查询条件用的(JDK5.0语法) 
	*/  
	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... args) {  
		Assert.hasText(hql); 
		Query query = null;
		Page page = null;
		try{
			query = this.createQuery(hql);
			for (int i = 0; i < args.length; i++) {  
				query.setParameter(i, args[i]);  
			}
			String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));  
			List countlist = hibernateTemplate.find(countQueryString, args);  
			int totalCount = Integer.parseInt(String.valueOf(countlist.get(0)));  
			int startIndex = Page.getStartOfPage(pageNo, pageSize);  
			List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list(); 
			page = new Page(startIndex, totalCount, pageSize, list);
		}catch (Exception e){
			e.printStackTrace();
		}
		return page;  
	} 
	
	/**
	 * 
	 *  @Enclosing_Method  : pagedQuery2
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2015年9月29日 下午7:11:18 
	 *  @version           : v1.00
	 *  @Description       :  bootstrap table分页查询
	 *  
	 *  @param hql
	 *  @param offset
	 *  @param pageSize
	 *  @param args
	 *  @return
	 *
	 */
	public Page pagedQuery2(String hql, int offset, int pageSize, Object... args) {  
		Assert.hasText(hql); 
		Query query = null;
		Page page = null;
		try{
			query = this.createQuery(hql);
			for (int i = 0; i < args.length; i++) {  
				query.setParameter(i, args[i]);  
			}
			String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));  
			List countlist = hibernateTemplate.find(countQueryString, args);  
			int totalCount = Integer.parseInt(String.valueOf(countlist.get(0)));  
			List list = query.setFirstResult(offset).setMaxResults(pageSize).list(); 
			page = new Page(offset, totalCount, pageSize, list);
		}catch (Exception e){
			e.printStackTrace();
		}
		return page;  
	}
	
	//去除hql的select 子句
	private static String removeSelect(String hql) {
	  Assert.hasText(hql); 
	  int beginPos = hql.toLowerCase().indexOf("from"); 
	  Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'"); 
	  return hql.substring(beginPos); 
	} 
	 
	//去除hql的orderby 子句 
	private static String removeOrders(String hql) { 
	  Assert.hasText(hql); 
	  Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
	  Matcher m = p.matcher(hql); 
	  StringBuffer sb = new StringBuffer(); 
	  while (m.find()) { 
	    m.appendReplacement(sb, ""); 
	  } 
	  m.appendTail(sb); 
	  return sb.toString(); 
	}
	
	/**
	 * 获取到 Hibernate 当前会话中的 Connection
	 * @return
	 */
	public Connection getConnection() {
		try {
			Session curSeesion = null;
			Connection con = null;
			curSeesion = hibernateTemplate.getSessionFactory()
					.getCurrentSession();
			con = curSeesion.connection();
			return con;
		} catch (Exception es) {
			System.out.println(es.getMessage());
			return null;
		}
	}

	/**
	 * 直接操作 JDBC 的接口
	 * 
	 * @param pureSql
	 * @return
	 * @throws SQLException
	 */
	public List<T> getObjectsBySql(String pureSql) throws SQLException {
		Connection con = this.getConnection();
		PreparedStatement ps = con.prepareStatement(pureSql.toString());
		ResultSet rs = ps.executeQuery();
		try {
			if (rs != null) {
				return this.convertList(rs);
			} else {
				return null;
			}

		} catch (Exception es) {
			System.out.println(es.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * ResultSet转换为List
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<T> convertList(ResultSet rs) throws SQLException {
		List list = new ArrayList();
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount(); // Map rowData;
		while (rs.next()) { // rowData = new HashMap(columnCount);
			Map rowData = new HashMap();
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(rowData);
		}
		return list;
	}
	
	/**
	 *  @Enclosing_Method  : updateSqls
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2015年6月3日 下午7:12:49 
	 *  @version           : v1.00
	 *  @Description       :  增加update的批量操作。sqls为传入的List<String> sql语句
	 *  
	 *  @param sqls
	 *  @throws SQLException
	 **/
	public void updateSqls(List<String> sqls) throws SQLException {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for(String sql : sqls){
			session.createQuery(sql).executeUpdate();
		}
		tx.commit();
		session.clear();
		session.flush();
		session.close();
	}
	
	public void updateSql(String sql) throws SQLException {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery(sql).executeUpdate();
		tx.commit();
		session.clear();
		session.flush();
		session.close();
	}
	
	//批量插入，局限：50，000 条记录左右会失败并抛出内存溢出异常（OutOfMemoryException）
	public void saveAll(List<?> entities){
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for(int i=0;i<entities.size();i++){
			session.save(entities.get(i));
		}
		tx.commit();
		session.clear();
		session.flush();
		session.close();
	}
	
	/**
	 * JDBC执行sql语句
	 * @param sql字符串语句，注意from后跟的是数据库中的表名
	 * @return 返回List对象
	 * @throws SQLException
	 */
	public List<T> getListByJDBC(String sql) throws SQLException {
		Connection con = this.getConnection();
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		try {
			if (rs != null) {
				return this.convertList2(rs);
			} else {
				return null;
			}

		} catch (Exception es) {
			System.err.println(es.getMessage());
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 将数据库返回的结果集转为List数据结构
	 * @param rs 存储查询结果的结果集ResultSet
	 * @return
	 * @throws SQLException
	 */
	private List<T> convertList2(ResultSet rs) throws SQLException {
		List list = new ArrayList();
		ResultSetMetaData md = rs.getMetaData();   //得到结果集的结构信息，比如字段数、字段名等
		int columnCount = md.getColumnCount(); // 列数
		String[] columnNames = new String[columnCount + 1];
		String[] columnTypes = new String[columnCount + 1];
		for(int i = 1; i <= columnCount; i++){ //获取每一列的列名和对应的数据存储类型
			columnNames[i] = md.getColumnName(i).substring(0,1).toUpperCase() + md.getColumnName(i).substring(1);
			columnTypes[i] = md.getColumnClassName(i);
		}
		
		while (rs.next()) { 
			try {
				T obj = entityClass.newInstance();
				for(int i = 1; i <= columnCount; i++){
					Method method = entityClass.getDeclaredMethod("set" + columnNames[i], getBasicType(columnTypes[i]));
					method.invoke(obj, rs.getObject(columnNames[i]));
				}
				list.add(obj);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	/**
	 * 将数据库中的类型名，转为对应的class对象
	 * @param typeName 类型名，如java.lang.Integer
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Class getBasicType(String typeName) throws ClassNotFoundException{
		String[] typeNames = {"java.lang.Byte", "java.lang.Short", "java.lang.Integer", 
				          "java.lang.Long", "java.lang.Float", "java.lang.Double",
				          "java.lang.Char", "java.lang.Boolean"};
		Class[] typeValues = {Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Character.TYPE, Boolean.TYPE};
		
		for(int i = 0; i < typeNames.length; i++){
			if(typeNames[i].equals(typeName)){
				return typeValues[i];
			}
		}
		return Class.forName(typeName);
	}
}
