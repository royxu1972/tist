package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.SystemDictionaryDao;
import njxzc.royxu.dao.SystemDictionaryTypeDao;
import njxzc.royxu.domain.SystemDictionary;
import njxzc.royxu.domain.SystemDictionaryType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

/**
 * 数据字典管理Service
 * @author Author
 * @version 2015-07-19
 */
@Service
@Transactional
public class SystemDictionaryServiceImpl {

	@Autowired
	private SystemDictionaryDao systemDictionaryDao;
	@Autowired
	private SystemDictionaryTypeDao systemDictionaryTypeDao;
	
	public void saveSystemDictionary(SystemDictionary systemDictionary){
		systemDictionaryDao.save(systemDictionary);
	}
	
	public List<SystemDictionary> loadAllSystemDictionarys(){
		return systemDictionaryDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		String hql = "from SystemDictionary sd where sd.del_flag='0' and sd.father_id=? ";
		hql += " order by sd.sort";
		Page page = systemDictionaryDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public List getSysParamsByFatherId(Integer father_id) {
		String hql = "from SystemDictionary sd where sd.del_flag='0' and sd.father_id=? ";
		hql += " order by sd.sort";
		List list = systemDictionaryDao.find(hql, father_id);
		return list;
	}
	
	public List getSysParamsByFatherName(String father_name) {
		int id = -1;
		String sql = "from SystemDictionaryType where dict_name='" + father_name + "'";
		List lis = systemDictionaryTypeDao.find(sql);
		if(lis.size() > 0){
			SystemDictionaryType obj = (SystemDictionaryType)lis.get(0);
			id = obj.getIncrement_id();
		}
		String hql = "from SystemDictionary sd where sd.del_flag='0' and sd.father_id=" + id;
		hql += " order by sd.sort";
		List list = systemDictionaryDao.find(hql);
		return list;
	}
	
	public void deleteSystemDictionarys(List<SystemDictionary> systemDictionarys){
		systemDictionaryDao.deleteAll(systemDictionarys);
	}
	
	public void updateSystemDictionary(SystemDictionary systemDictionary){
		systemDictionaryDao.update(systemDictionary);
	}
	
	public void deleteSystemDictionary(SystemDictionary systemDictionary){
		systemDictionaryDao.delete(systemDictionary);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteSystemDictionarysBySqls(String[] ids) throws SQLException{
		systemDictionaryDao.deleteSystemDictionarysBySqls(ids);
	}

	
}
