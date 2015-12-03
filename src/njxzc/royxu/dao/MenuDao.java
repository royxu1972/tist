package njxzc.royxu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Menu;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

@Repository
public class MenuDao extends BaseDao<Menu>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Menu> getMenuByMenuIds(String menu_ids){
		List<Menu> menus = (List<Menu>) find("from Menu m where m.menu_id in ("+menu_ids+")");
		return menus;
	}
	
	public void saveMenu(Menu menu) throws SQLException{
		int total = getMenuCountByFatherId(menu.getFather_id());
		if(menu.getFather_id()==0){//设置menu_id
			menu.setMenu_id(total+1);
		}else{//设置menu_id
			System.err.println(menu.getFather_id()*100+total+1);
			menu.setMenu_id(menu.getFather_id()*100+total+1);
		}
		
		if(StringUtil.isEmpty(menu.getSort())){
			String sort = (menu.getFather_id()+1)*10+"."+(total+1);
			System.err.println("菜单排序="+sort);
			menu.setSort(sort);
		}else{
			String sort = (menu.getFather_id()+1)*10+"."+(Integer.parseInt(menu.getSort()));
			System.err.println("菜单排序="+sort);
			menu.setSort(sort);
		}
		menu.setDel_flag("0");
		System.err.println(menu.toString());
		save(menu);
	}
	
	public void updateMenu(Menu menu) throws SQLException{
		if(StringUtil.isEmpty(menu.getSort())){
			int total = getMenuCountByFatherId(menu.getFather_id());
			String sort = (menu.getFather_id()+1)*10+"."+(total+1);
			System.err.println("菜单排序="+sort);
			menu.setSort(sort);
		}else{
			String sort = (menu.getFather_id()+1)*10+"."+(Integer.parseInt(menu.getSort()));
			System.err.println("菜单排序="+sort);
			menu.setSort(sort);
		}
		System.err.println(menu.toString());
		update(menu);
	}
	
	public int getMenuCountByFatherId(Integer father_id) throws SQLException{
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String sql = "select count(*) as total from sys_menu m where m.del_flag=0 and m.father_id="+father_id;
		int total = 0;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.err.println("father menu has " + rs.getInt("total")+" children");
			total = rs.getInt("total");
		}
		return total;
	}
	
	public List<Menu> findMenuByFatherIdRoleId(int role_id,Integer father_id) throws SQLException{
		String sql = "select * from sys_menu m where m.del_flag=0 and m.menu_id in "
				+ "(select rm.menu_id from sys_role_menu rm "
				+ "where rm.menu_father_id='"+father_id+"' and rm.role_id='"+role_id+"')";
		List<Menu> menus = getObjectsBySql(sql);
		return menus;
	}
	
	public List<Menu> findMenuByFatherIdRoleId(String role_ids,Integer father_id) throws SQLException{
		String sql = "select * from sys_menu m where m.del_flag=0 and m.menu_id in "
				+ "(select rm.menu_id from sys_role_menu rm "
				+ "where rm.menu_father_id='"+father_id+"' and rm.role_id in ("+role_ids+"))";
		List<Menu> menus = getObjectsBySql(sql);
		return menus;
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> findMenusByUserId(int user_id) throws SQLException{
		List<Menu> menus = new ArrayList<Menu>();
		String sql = "select ur.role_ids from sys_user_role ur where ur.user_id="+user_id+" ";
		String role_ids = getRoleIds(sql);
		if(role_ids != null){
			String hql = "from Menu m where m.del_flag=0 and m.menu_id in "
					+ "(select rm.menu_id from RoleMenu rm where rm.role_id in ("+role_ids+")) "
					+ " order by m.sort";
			menus = (List<Menu>) hibernateTemplate.find(hql);
		}
		return menus;
	}
	
	public String getRoleIds(String sql) throws SQLException{
		System.err.println(sql);
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String role_ids = null;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.err.println("role_ids =  " + rs.getString("role_ids"));
			role_ids = rs.getString("role_ids");
		}
		return role_ids;
	}
}
