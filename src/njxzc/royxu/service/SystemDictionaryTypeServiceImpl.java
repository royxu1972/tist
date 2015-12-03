package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.SystemDictionaryTypeDao;
import njxzc.royxu.domain.SystemDictionaryType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

/**
 * 数据字典类型管理Service
 * @author Author
 * @version 2015-07-19
 */
@Service
@Transactional
public class SystemDictionaryTypeServiceImpl {

	@Autowired
	private SystemDictionaryTypeDao systemDictionaryTypeDao;
	
	public void saveSystemDictionaryType(SystemDictionaryType systemDictionaryType){
		systemDictionaryTypeDao.save(systemDictionaryType);
	}
	
	public List<SystemDictionaryType> loadAllSystemDictionaryTypes(){
		return systemDictionaryTypeDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = systemDictionaryTypeDao.pagedQuery("from SystemDictionaryType sdt where sdt.del_flag='0'", pageNo,pageSize, conditions);
		return page;
	}
	
	public void deleteSystemDictionaryTypes(List<SystemDictionaryType> systemDictionaryTypes){
		systemDictionaryTypeDao.deleteAll(systemDictionaryTypes);
	}
	
	public void updateSystemDictionaryType(SystemDictionaryType systemDictionaryType){
		systemDictionaryTypeDao.update(systemDictionaryType);
	}
	
	public void deleteSystemDictionaryType(SystemDictionaryType systemDictionaryType){
		systemDictionaryTypeDao.delete(systemDictionaryType);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteSystemDictionaryTypesBySqls(String[] ids) throws SQLException{
		systemDictionaryTypeDao.deleteSystemDictionaryTypesBySqls(ids);
	}
	
	public void deleteDictTypeAndDict(SystemDictionaryType systemDictionaryType) throws SQLException{
		systemDictionaryTypeDao.deleteDictTypeAndDict(systemDictionaryType);
	}
	
}
