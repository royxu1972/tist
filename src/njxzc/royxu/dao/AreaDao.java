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
public class AreaDao extends BaseDao<HatArea>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//根据数据字典的父项ID查询所有子项内容
	public List<HatArea> findAllHatAreaInfosByID(String cityid){
		List<?> list = hibernateTemplate.find(
				"from HatArea a where  a.father=?", cityid);
		List<HatArea> areas=new ArrayList<HatArea>();
		for(Object temp:list){
			areas.add((HatArea)temp);
		}
		return areas;
		
	}
	
	//根据站点id的前六位找到区
	/**
	 * @author 梁轰
	 * @param town_id 前台传来的站点id的前六位
	 * @return 此站点id对应的区HatArea
	 */
	public List<HatArea> getHatArea(String town_id){
		List<?> list = hibernateTemplate.find(
				"from HatArea c where  c.areaID=?", town_id);
		List<HatArea> towns = new ArrayList<HatArea>();
		for(Object temp:list){
			towns.add((HatArea)temp);
		}
		return towns;
	}
}
