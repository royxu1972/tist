package njxzc.royxu.service;

import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.dao.*;
import njxzc.royxu.domain.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CityServiceImpl {
	@Resource
	private CityDao cityDao;

	public List<HatCity> findAllCityInfosByData_ddID(String provinceid) {
		return cityDao.findAllHatCityInfosByID(provinceid);
	}
	
	/**
	 * 最后修改人：梁轰
	 * 修改原因：增加根据city_id查找市的名字
	 * 最后修改时间:2014年4月6日16:22:17
	 */
	public List<HatCity> getCity(String city_id){
		return cityDao.getCity(city_id);
	}
	
	/**
	 *  @Enclosing_Method  : getAllCities
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年10月10日 下午11:05:23 
	 *  @version           : v1.00
	 *  @Description       :  获取所有的城市
	 *  
	 *  @return
	 **/
	public List<HatCity> getAllCities(){
		return cityDao.loadAll();
	}
}
