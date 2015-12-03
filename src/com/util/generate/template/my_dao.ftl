package ${packageName}.dao${subModuleName};

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import ${packageName}.domain${subModuleName}.${ClassName};

/**
 * ${functionName}DAO接口
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Repository
public class ${ClassName}Dao extends BaseDao<${ClassName}> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void delete${ClassName}sBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update ${ClassName} set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
}
