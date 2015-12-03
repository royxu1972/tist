package njxzc.royxu.dao;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import njxzc.royxu.domain.ProjectGroup;

/**
 * 项目组DAO接口
 * @author LiangHong
 * @version 2015-10-24
 */
@Repository
public class ProjectGroupDao extends BaseDao<ProjectGroup> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteProjectGroupsBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update ProjectGroup set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
}
