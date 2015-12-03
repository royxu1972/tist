package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.BasicInfoDao;
import njxzc.royxu.domain.BasicInfo;
import njxzc.royxu.searchmodel.SearchBasicInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 基本信息Service
 * @author LiangHong
 * @version 2015-10-02
 */
@Service
@Transactional
public class BasicInfoServiceImpl {

	@Autowired
	private BasicInfoDao basicInfoDao;
	
	public void saveBasicInfo(BasicInfo basicInfo){
		basicInfoDao.save(basicInfo);
	}
	
	public List<BasicInfo> loadAllBasicInfos(){
		return basicInfoDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchBasicInfo searchBasicInfo, Object... conditions) {
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
		
		Page page = basicInfoDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedBasicInfos(int offset, int pageSize,SearchBasicInfo searchBasicInfo, Object... conditions) {
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
		
		Page page = basicInfoDao.pagedQuery(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteBasicInfos(List<BasicInfo> basicInfos){
		basicInfoDao.deleteAll(basicInfos);
	}
	
	public void updateBasicInfo(BasicInfo basicInfo){
		basicInfoDao.update(basicInfo);
	}
	
	public void deleteBasicInfo(BasicInfo basicInfo){
		basicInfoDao.delete(basicInfo);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteBasicInfosBySqls(String[] ids) throws SQLException{
		basicInfoDao.deleteBasicInfosBySqls(ids);
	}
	
//	按条件查询
	public List<BasicInfo> findBasicInfos(SearchBasicInfo searchBasicInfo){
		return basicInfoDao.findBasicInfos(searchBasicInfo);
	}
	
	//修改邮箱验证状态
	public void updateEmailValidated(String user_no,String validate_result) throws SQLException{
		basicInfoDao.updateEmailValidated(user_no, validate_result);
	}
	
}
