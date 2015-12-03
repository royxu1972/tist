/**
 * 
 */
package njxzc.royxu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.*;

@Repository
public class CityDao extends BaseDao<HatCity>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//根据数据字典的父项ID查询所有子项内容
	public List<HatCity> findAllHatCityInfosByID(String provinceid){
		List<?> list = hibernateTemplate.find(
				"from HatCity c where  c.father=?", provinceid);
		List<HatCity> cities=new ArrayList<HatCity>();
		for(Object temp:list){
			cities.add((HatCity)temp);
		}
		return cities;
		
	}

	//根据查找的区的父id查询市
	/**
	 * @author 梁轰
	 * @param city_id 根据区的father（父id）查询市
	 * @return 根据cityid查询市的名字HatCity
	 */
	public List<HatCity> getCity(String city_id){
		List<?> list = hibernateTemplate.find(
				"from HatCity c where  c.cityID=?", city_id);
		List<HatCity> cities=new ArrayList<HatCity>();
		for(Object temp:list){
			cities.add((HatCity)temp);
		}
		return cities;
		
	}
}
