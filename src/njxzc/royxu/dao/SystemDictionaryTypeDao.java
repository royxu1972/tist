package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.SystemDictionaryType;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

/**
 * 数据字典类型管理DAO接口
 * @author Author
 * @version 2015-07-19
 */
@Repository
public class SystemDictionaryTypeDao extends BaseDao<SystemDictionaryType> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteSystemDictionaryTypesBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update SystemDictionaryType set del_flag where = '1'";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	public void deleteDictTypeAndDict(SystemDictionaryType systemDictionaryType) throws SQLException{
//		删除消息
		String sql = "update SystemDictionaryType set del_flag = '1' where increment_id = "+systemDictionaryType.getIncrement_id();
		List<String> sqls = new ArrayList<String>();
		sqls.add(sql);
//		删除消息对应的文件
		sql = "update SystemDictionary set del_flag = '1' where father_id = "+systemDictionaryType.getIncrement_id();
		sqls.add(sql);
		updateSqls(sqls);
	}
	
}
