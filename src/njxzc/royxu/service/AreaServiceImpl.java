package njxzc.royxu.service;

import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.dao.*;
import njxzc.royxu.domain.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AreaServiceImpl {
	@Resource
	private AreaDao areaDao;

	public List<HatArea> findAllAreaInfosByCityID(String cityid) {
		return areaDao.findAllHatAreaInfosByID(cityid);
	}
	/**
	 * 
	 * @param town_id
	 * @return
	 * 最后修改人：梁轰
	 * 修改原因：增加根据站点id前六位获得区
	 * 修改时间：2014年4月6日16:18:43
	 */
	public List<HatArea> getHatArea(String town_id){
		return areaDao.getHatArea(town_id);
	}
	
	/**
	 *  @Enclosing_Method  : getAllHatAreas
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年10月10日 下午11:05:38 
	 *  @version           : v1.00
	 *  @Description       :  获取所有的地区
	 *  
	 *  @return
	 **/
	public List<HatArea> getAllHatAreas(){
		return areaDao.loadAll();
	}

}
