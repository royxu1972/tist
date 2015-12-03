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

@Controller("provinceController")
public class ProvinceController {
	private static final Logger LOG = LoggerFactory.getLogger(ProvinceController.class);
	
	@Autowired
	private ProvinceServiceImpl provinceService;
	
	@RequestMapping(value="/provinceinfo", method=RequestMethod.POST)
	public ModelAndView getProvinceInfos() {
		ModelAndView mav = new ModelAndView();
		try {
			List<HatProvince> dataList = provinceService.findAllProvince();
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
	 *  @Enclosing_Method  : getProvinceInfos
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2014年5月9日 下午11:53:48 
	 *  @version           : v1.00
	 *  @Description       :  前台通过传如省的id，返货HatProvince的对象，可以获得省的id和省的名字
	 *  
	 *  @param province_id 前台传入的省的id，即市的父id，县的父id的父id，县通过getTown方法获得市id。
	 *  				           再根据getCity的方法获得省id，最后使用此方法获得省的名称和id
	 *  @return hatProvince的对象，包含省的id和省的名字
	 **/
	@RequestMapping(value="/loadprovince", method=RequestMethod.POST)
	public ModelAndView getProvinceInfos(String province_id) {
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			mav.addObject("success", true);
			mav.addObject("rows",provinceService.getProvince(province_id)); 
		} catch (Exception e) {
            LOG.error(e.getMessage(), e);
            mav.addObject("msg", e.getMessage());
            mav.addObject("success", false);
        }
		return mav;
	}
}
