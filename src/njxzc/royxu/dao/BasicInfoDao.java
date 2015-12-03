package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.BasicInfo;
import njxzc.royxu.searchmodel.SearchBasicInfo;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 基本信息DAO接口
 * @author LiangHong
 * @version 2015-10-02
 */
@Repository
public class BasicInfoDao extends BaseDao<BasicInfo> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteBasicInfosBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update BasicInfo set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	//修改邮箱验证状态
	public void updateEmailValidated(String user_no,String validate_result) throws SQLException{
		String hql = "update BasicInfo set email_validated='"+validate_result+"' where increment_id='"+user_no+"'";
		updateSql(hql);
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<BasicInfo> findBasicInfos(SearchBasicInfo searchBasicInfo){
		String hql = "from BasicInfo where 1=1 ";
		if(!StringUtil.isEmpty(searchBasicInfo.getS_increment_id())){
			hql += " and increment_id = '"+searchBasicInfo.getS_increment_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_name())){
			hql += " and name = '"+searchBasicInfo.getS_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_gender())){
			hql += " and gender = '"+searchBasicInfo.getS_gender()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_birthday())){
			hql += " and birthday = '"+searchBasicInfo.getS_birthday()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_academic())){
			hql += " and academic = '"+searchBasicInfo.getS_academic()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_pro_title())){
			hql += " and pro_title = '"+searchBasicInfo.getS_pro_title()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_email())){
			hql += " and email = '"+searchBasicInfo.getS_email()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_address())){
			hql += " and address = '"+searchBasicInfo.getS_address()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_zh_introduction())){
			hql += " and zh_introduction = '"+searchBasicInfo.getS_zh_introduction()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_en_introduction())){
			hql += " and en_introduction = '"+searchBasicInfo.getS_en_introduction()+"' ";
		}
		if(!StringUtil.isEmpty(searchBasicInfo.getS_detail_introduction())){
			hql += " and detail_introduction = '"+searchBasicInfo.getS_detail_introduction()+"' ";
		}
		
		hql += " order by member_sort ";
		
		List<BasicInfo> basicinfos = (List<BasicInfo>) find(hql);
		return basicinfos;
	}
	
}
