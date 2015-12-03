package ${packageName}.service${subModuleName};

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import ${packageName}.domain${subModuleName}.${ClassName};
import ${packageName}.dao${subModuleName}.${ClassName}Dao;

/**
 * ${functionName}Service
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Service
@Transactional
public class ${ClassName}ServiceImpl {

	@Autowired
	private ${ClassName}Dao ${className}Dao;
	
	public void save${ClassName}(${ClassName} ${className}){
		${className}Dao.save(${className});
	}
	
	public List<${ClassName}> loadAll${ClassName}s(){
		return ${className}Dao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = ${className}Dao.pagedQuery("from ${ClassName}", pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPaged${ClassName}s(int offset, int pageSize, Object... conditions) {
		Page page = ${className}Dao.pagedQuery2("from ${ClassName}", offset,pageSize, conditions);
		return page;
	}
	
	public void delete${ClassName}s(List<${ClassName}> ${className}s){
		${className}Dao.deleteAll(${className}s);
	}
	
	public void update${ClassName}(${ClassName} ${className}){
		${className}Dao.update(${className});
	}
	
	public void delete${ClassName}(${ClassName} ${className}){
		${className}Dao.delete(${className});
	}
	
//	根据del_flag批量修改（等于删除）
	public void delete${ClassName}sBySqls(String[] ids) throws SQLException{
		${className}Dao.delete${ClassName}sBySqls(ids);
	}
	
}
