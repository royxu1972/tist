package njxzc.royxu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.SystemDictionaryType;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.service.SystemDictionaryTypeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;

/**
 * 数据字典类型管理Controller
 * @author Author
 * @version 2015-07-19
 */
@Controller
public class SystemDictionaryTypeController {
	
	@Autowired
	private SystemDictionaryTypeServiceImpl systemDictionaryTypeService;
	
//	增加systemDictionaryType
	@RequestMapping(value="/savesystemdictionarytype",method=RequestMethod.POST)
	public ModelAndView saveSystemDictionaryType(SystemDictionaryType systemDictionaryType, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			systemDictionaryType.setCreate_time(DateUtil.format2(new Date()));
			systemDictionaryType.setCreate_by(session.getAttribute("user_name").toString());
			systemDictionaryType.setUpdate_time(DateUtil.format2(new Date()));
			systemDictionaryType.setUpdate_by(session.getAttribute("user_name").toString());
			systemDictionaryTypeService.saveSystemDictionaryType(systemDictionaryType);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询systemDictionaryTypes	
	@RequestMapping(value="/listsystemdictionarytypes",method = RequestMethod.POST)
	public ModelAndView listSystemDictionaryTypes(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = systemDictionaryTypeService.getSysParams(page, rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部systemDictionaryTypes	
	@RequestMapping(value="/listallsystemdictionarytypes",method = RequestMethod.POST)
	public ModelAndView listAllSystemDictionaryTypes(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<SystemDictionaryType> systemDictionaryTypes = systemDictionaryTypeService.loadAllSystemDictionaryTypes();
			mav.addObject("total", systemDictionaryTypes.size());
			mav.addObject("rows", systemDictionaryTypes);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的systemDictionaryType，其中ids为主键的数组，需自定义，如需此方法解开注释修改
//	@RequestMapping(value="/deletesystemdictionarytypes", method=RequestMethod.POST)
//	public ModelAndView deleteSystemDictionaryTypes(String[] ids, HttpSession session){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
//			List<SystemDictionaryType> systemDictionaryTypes = new ArrayList<SystemDictionaryType>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					SystemDictionaryType systemDictionaryType = new SystemDictionaryType();
//					systemDictionaryType.setSystemDictionaryType_id(Integer.parseInt(id));
//					systemDictionaryTypes.add(systemDictionaryType);
//				}
//			}
//			systemDictionaryTypeService.deleteSystemDictionaryTypes(systemDictionaryTypes);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
	
//	删除一个systemDictionaryType	
	@RequestMapping(value="/deletesystemdictionarytype",method = RequestMethod.POST)
	public ModelAndView deleteSystemDictionaryType(SystemDictionaryType systemDictionaryType, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			systemDictionaryTypeService.deleteDictTypeAndDict(systemDictionaryType);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新systemDictionaryType	
	@RequestMapping(value="/updatesystemdictionarytype",method = RequestMethod.POST)
	public ModelAndView updateSystemDictionaryType(SystemDictionaryType systemDictionaryType, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			systemDictionaryType.setUpdate_time(DateUtil.format2(new Date()));
			systemDictionaryType.setUpdate_by(session.getAttribute("user_name").toString());
			systemDictionaryTypeService.updateSystemDictionaryType(systemDictionaryType);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
