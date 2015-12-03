package njxzc.royxu.dao;

import javax.annotation.Resource;

import njxzc.royxu.domain.SystemLog;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

@Repository
public class SystemLogDao extends BaseDao<SystemLog>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
}
