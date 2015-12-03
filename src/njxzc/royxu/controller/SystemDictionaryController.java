package njxzc.royxu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.SystemDictionary;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.service.SystemDictionaryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;

/**
 * 数据字典管理Controller
 * @author Author
 * @version 2015-07-19
 */
@Controller
public class SystemDictionaryController {
	
	@Autowired
	private SystemDictionaryServiceImpl systemDictionaryService;
	
//	增加systemDictionary
	@RequestMapping(value="/savesystemdictionary",method=RequestMethod.POST)
	public ModelAndView saveSystemDictionary(SystemDictionary systemDictionary, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			systemDictionary.setCreate_time(DateUtil.format2(new Date()));
			systemDictionary.setCreate_by(session.getAttribute("user_name").toString());
			systemDictionary.setUpdate_time(DateUtil.format2(new Date()));
			systemDictionary.setUpdate_by(session.getAttribute("user_name").toString());
			systemDictionaryService.saveSystemDictionary(systemDictionary);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询systemDictionarys	
	@RequestMapping(value="/listsystemdictionarysbyfatherid",method = RequestMethod.POST)
	public ModelAndView listSystemDictionarys(DataGridModel dmg,Integer father_id, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = systemDictionaryService.getSysParams(page, rows,father_id);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	easyui查询systemDictionarys	
	@RequestMapping(value="/listdictbyfatherid",method = RequestMethod.POST)
	public ModelAndView listDictByFatherId(Integer father_id, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List list = systemDictionaryService.getSysParamsByFatherId(father_id);
			mav.addObject("rows", list);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listdictbyfathername",method = RequestMethod.POST)
	public ModelAndView listDictByFatherName(String father_name, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List list = systemDictionaryService.getSysParamsByFatherName(father_name);
			mav.addObject("rows", list);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部systemDictionarys	
	@RequestMapping(value="/listallsystemdictionarys",method = RequestMethod.POST)
	public ModelAndView listAllSystemDictionarys(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<SystemDictionary> systemDictionarys = systemDictionaryService.loadAllSystemDictionarys();
			mav.addObject("total", systemDictionarys.size());
			mav.addObject("rows", systemDictionarys);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的systemDictionary，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletesystemdictionarys", method=RequestMethod.POST)
	public ModelAndView deleteSystemDictionarys(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
//			List<SystemDictionary> systemDictionarys = new ArrayList<SystemDictionary>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					SystemDictionary systemDictionary = new SystemDictionary();
//					systemDictionary.setIncrement_id(Integer.parseInt(id));
//					systemDictionarys.add(systemDictionary);
//				}
//			}
			systemDictionaryService.deleteSystemDictionarysBySqls(ids);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个systemDictionary	
	@RequestMapping(value="/deletesystemdictionary",method = RequestMethod.POST)
	public ModelAndView deleteSystemDictionary(SystemDictionary systemDictionary, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			systemDictionaryService.deleteSystemDictionary(systemDictionary);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新systemDictionary	
	@RequestMapping(value="/updatesystemdictionary",method = RequestMethod.POST)
	public ModelAndView updateSystemDictionary(SystemDictionary systemDictionary, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			systemDictionary.setUpdate_time(DateUtil.format2(new Date()));
			systemDictionary.setUpdate_by(session.getAttribute("user_name").toString());
			systemDictionaryService.updateSystemDictionary(systemDictionary);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
