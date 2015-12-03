package njxzc.royxu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.*;

/**
 * 
 * @author 梁轰
 * 修改原因：增加根据City的父id获得省的名字
 * 修改时间：2014年4月6日16:45:21
 */
@Repository
public class ProvinceDao extends BaseDao<HatProvince>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 
	 * @param province_id根据前台传过来的city的父id找到所在的省份
	 * @return city父id对应的HatProvince（省份）
	 */
	public List<HatProvince> getProvince(String province_id){
		List<?> list = hibernateTemplate.find(
				"from HatProvince p where  p.provinceID=?", province_id);
		List<HatProvince> provinces=new ArrayList<HatProvince>();
		for(Object temp:list){
			provinces.add((HatProvince)temp);
		}
		return provinces;
	}
}
