package njxzc.royxu.service;

import java.util.List;

import njxzc.royxu.dao.SystemLogDao;
import njxzc.royxu.domain.SystemLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

@Service
@Transactional
public class SystemLogServiceImpl {
	@Autowired
	private SystemLogDao systemLogDao;
	
	public void saveSystemLog(SystemLog systemLog){
		systemLogDao.save(systemLog);
	}
	
	public List<SystemLog> loadAllSystemLogs(){
		return systemLogDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = systemLogDao.pagedQuery("from SystemLog s", pageNo,pageSize, conditions);
		return page;
	}
	
	public void delteSystemLogs(List<SystemLog> systemLogs){
		systemLogDao.deleteAll(systemLogs);
	}
	
	public void updateSystemLog(SystemLog systemLog){
		systemLogDao.update(systemLog);
	}
}
