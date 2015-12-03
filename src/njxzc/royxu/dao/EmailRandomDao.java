package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.EmailRandom;
import njxzc.royxu.searchmodel.SearchEmailRandom;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 邮箱验证码DAO接口
 * @author LiangHong
 * @version 2015-11-02
 */
@Repository
public class EmailRandomDao extends BaseDao<EmailRandom> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteEmailRandomsBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update EmailRandom set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<EmailRandom> findEmailRandoms(SearchEmailRandom searchEmailRandom){
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
		
		List<EmailRandom> emailrandoms = (List<EmailRandom>) find(hql);
		return emailrandoms;
	}
	
//	验证邮箱收到的验证码是否正确
	@SuppressWarnings("unchecked")
	public EmailRandom validateEmail(String email, String user_no, String random_code){
		String hql = "from EmailRandom where email = '" + email + "' "//邮箱
				+ "and user_no = '" + user_no + "' "//用户编号
				+ "and random_code = '"+random_code+"' "//验证码
				+ "and send_time = ("//最新验证码记录
				+ "select MAX(r.send_time) from EmailRandom r "
				+ "where r.user_no = '" + user_no + "' "
				+ "and r.email = '"+ email +"' "
				+ ")";
		System.err.println(hql);
		List<EmailRandom> emailrandoms = (List<EmailRandom>) find(hql);
		if(emailrandoms.size()>0){
			return emailrandoms.get(0);
		}else{
			return null;
		}
	}
	
}
