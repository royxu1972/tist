package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.EmailRandomDao;
import njxzc.royxu.domain.EmailRandom;
import njxzc.royxu.searchmodel.SearchEmailRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 邮箱验证码Service
 * @author LiangHong
 * @version 2015-11-02
 */
@Service
@Transactional
public class EmailRandomServiceImpl {

	@Autowired
	private EmailRandomDao emailRandomDao;
	
	public void saveEmailRandom(EmailRandom emailRandom){
		emailRandomDao.save(emailRandom);
	}
	
	public List<EmailRandom> loadAllEmailRandoms(){
		return emailRandomDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchEmailRandom searchEmailRandom, Object... conditions) {
		String hql = "from EmailRandom where 1=1 ";
		if(!StringUtil.isEmpty(searchEmailRandom.getS_email())){
			hql += " and email = '"+searchEmailRandom.getS_email()+"' ";
		}
		if(!StringUtil.isEmpty(searchEmailRandom.getS_random_code())){
			hql += " and random_code = '"+searchEmailRandom.getS_random_code()+"' ";
		}
		if(!StringUtil.isEmpty(searchEmailRandom.getS_send_time())){
			hql += " and send_time = '"+searchEmailRandom.getS_send_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchEmailRandom.getS_validate_time())){
			hql += " and validate_time = '"+searchEmailRandom.getS_validate_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchEmailRandom.getS_is_validated())){
			hql += " and is_validated = '"+searchEmailRandom.getS_is_validated()+"' ";
		}
		if(!StringUtil.isEmpty(searchEmailRandom.getS_user_no())){
			hql += " and user_no = '"+searchEmailRandom.getS_user_no()+"' ";
		}
		
		Page page = emailRandomDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public void deleteEmailRandoms(List<EmailRandom> emailRandoms){
		emailRandomDao.deleteAll(emailRandoms);
	}
	
	public void updateEmailRandom(EmailRandom emailRandom){
		emailRandomDao.update(emailRandom);
	}
	
	public void deleteEmailRandom(EmailRandom emailRandom){
		emailRandomDao.delete(emailRandom);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteEmailRandomsBySqls(String[] ids) throws SQLException{
		emailRandomDao.deleteEmailRandomsBySqls(ids);
	}
	
//	按条件查询
	public List<EmailRandom> findEmailRandoms(SearchEmailRandom searchEmailRandom){
		return emailRandomDao.findEmailRandoms(searchEmailRandom);
	}

//	验证邮箱收到的验证码是否正确
	public EmailRandom validateEmail(String email, String user_no, String random_code){
		return emailRandomDao.validateEmail(email, user_no, random_code);
	}
	
}
