package njxzc.royxu.controller;

import java.util.List;

import njxzc.royxu.domain.*;
import njxzc.royxu.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("areaController")
public class AreaController {
	private static final Logger LOG = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaServiceImpl areaService;
	
	@RequestMapping(value="/areainfo", method=RequestMethod.POST)
	public ModelAndView getCityInfos(String cityid) {
		LOG.debug("getarea:{}",cityid);
		ModelAndView mav = new ModelAndView();
		try {
			List<HatArea> dataList = areaService.findAllAreaInfosByCityID(cityid);
			mav.addObject("rows",dataList);
		    mav.addObject("success", true);
		    mav.setViewName("jsonView");//输出jSon数据格式
		} catch (Exception e) {
            LOG.error(e.getMessage(), e);
            mav.addObject("msg", e.getMessage());
            mav.addObject("success", false);
        }
		return mav;
	}
	
	/**
	 *  @Enclosing_Method  : getAllAreas
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年10月10日 下午11:04:11 
	 *  @version           : v1.00
	 *  @Description       :  获取所有的地区
	 *  
	 *  @return
	 **/
	@RequestMapping(value="/loadallareas", method=RequestMethod.POST)
	public ModelAndView getAllAreas() {
//		LOG.debug("getarea:{}",cityid);
		ModelAndView mav = new ModelAndView();
		try {
			List<HatArea> dataList = areaService.getAllHatAreas();
			mav.addObject("rows",dataList);
		    mav.addObject("success", true);
		    mav.setViewName("jsonView");//输出jSon数据格式
		} catch (Exception e) {
            LOG.error(e.getMessage(), e);
            mav.addObject("msg", e.getMessage());
            mav.addObject("success", false);
        }
		return mav;
	}

	/**
	 *  @Enclosing_Method  : getTown
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年5月9日 下午11:45:35 
	 *  @version           : v1.00
	 *  @Description       :  前台传入站点id的前六位或者用户id的前六位获得该站点或者站点管理员负责的站点所在县，返回县的id，名字，id和父id
	 *  
	 *  @param town_id 前台ajax调用的时候将站点id的前6位数字
	 *  @return 该站点所在的县和县的id，以数据都封装在HatArea对象中
	 **/
	@RequestMapping(value="/loadtown", method=RequestMethod.POST)
	public ModelAndView getTown(String town_id){
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			mav.addObject("success",true);
			mav.addObject("rows",areaService.getHatArea(town_id));
		} catch (Exception e) {
            LOG.error(e.getMessage(), e);
            mav.addObject("msg", e.getMessage());
            mav.addObject("success", false);
        }
		return mav;
	}
}
