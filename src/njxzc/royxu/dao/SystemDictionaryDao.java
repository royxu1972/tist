package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.SystemDictionary;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

/**
 * 数据字典管理DAO接口
 * @author Author
 * @version 2015-07-19
 */
@Repository
public class SystemDictionaryDao extends BaseDao<SystemDictionary> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteSystemDictionarysBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update SystemDictionary set del_flag='1' where increment_id="+Integer.parseInt(id);
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
}
