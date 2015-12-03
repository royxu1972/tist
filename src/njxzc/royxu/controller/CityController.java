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

@Controller("cityController")
public class CityController {
	private static final Logger LOG = LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	private CityServiceImpl cityService;
	
	@RequestMapping(value="/cityinfo", method=RequestMethod.POST)
	public ModelAndView getCityInfos(String provinceid) {
		LOG.debug("getcity:{}",provinceid);
		ModelAndView mav = new ModelAndView();
		try {
			List<HatCity> dataList = cityService.findAllCityInfosByData_ddID(provinceid);
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
	 *  @Enclosing_Method  : getAllCities
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年10月10日 下午11:04:53 
	 *  @version           : v1.00
	 *  @Description       :  获取所有的城市
	 *  
	 *  @return
	 **/
	@RequestMapping(value="/loadallcities", method=RequestMethod.POST)
	public ModelAndView getAllCities() {
//		LOG.debug("getcity:{}",provinceid);
		ModelAndView mav = new ModelAndView();
		try {
			List<HatCity> dataList = cityService.getAllCities();
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
	 *  @Enclosing_Method  : getCity
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年5月9日 下午11:50:40 
	 *  @version           : v1.00
	 *  @Description       : 前台调用此方法可以根据传入的市的id获得该市的id，名字和父id（该市所属省的id）
	 *  
	 *  @param city_id 前台的市id，先调用AreaController中的getTown方法获得该县的父id为参数，及此处的参数city_id
	 *  @return HatCity对象，包含该县所在的市的所有信息：id、名字、父id
	 **/
	@RequestMapping(value="/loadcity", method=RequestMethod.POST)
	public ModelAndView getCity(String city_id) {
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			mav.addObject("success",true);
			mav.addObject("rows",cityService.getCity(city_id));
		} catch (Exception e) {
            LOG.error(e.getMessage(), e);
            mav.addObject("msg", e.getMessage());
            mav.addObject("success", false);
        }
		return mav;
	}
}
