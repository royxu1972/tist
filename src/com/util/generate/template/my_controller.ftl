package ${packageName}.controller${subModuleName};

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import ${packageName}.searchmodel.DataGridModel;

import ${packageName}.domain${subModuleName}.${ClassName};
import ${packageName}.service${subModuleName}.${ClassName}ServiceImpl;

/**
 * ${functionName}Controller
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Controller
public class ${ClassName}Controller {
	
	@Autowired
	private ${ClassName}ServiceImpl ${className}Service;
	
//	增加${className}
	@RequestMapping(value="/save${classname}",method=RequestMethod.POST)
	public ModelAndView save${ClassName}(${ClassName} ${className}, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			${className}Service.save${ClassName}(${className});
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询${className}s	
	@RequestMapping(value="/list${classname}s",method = RequestMethod.POST)
	public ModelAndView list${ClassName}s(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = ${className}Service.getSysParams(page, rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpaged${classname}s")
	public ModelAndView listPaged${ClassName}s(int offset,int limit,String order){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = ${className}Service.getPaged${ClassName}s(offset, limit);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部${className}s	
	@RequestMapping(value="/listall${classname}s",method = RequestMethod.POST)
	public ModelAndView listAll${ClassName}s(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<${ClassName}> ${className}s = ${className}Service.loadAll${ClassName}s();
			mav.addObject("total", ${className}s.size());
			mav.addObject("rows", ${className}s);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的${className}，其中ids为主键的数组，需自定义，如需此方法解开注释修改
//	@RequestMapping(value="/delete${classname}s", method=RequestMethod.DELETE)
//	public ModelAndView delete${ClassName}s(String[] ids, HttpSession session){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
//			List<${ClassName}> ${className}s = new ArrayList<${ClassName}>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					${ClassName} ${className} = new ${ClassName}();
//					${className}.set${ClassName}_id(Integer.parseInt(id));
//					${className}s.add(${className});
//				}
//			}
//			${className}Service.delete${ClassName}s(${className}s);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
	
//	删除一个${className}	
	@RequestMapping(value="/delete${classname}",method = RequestMethod.POST)
	public ModelAndView delete${ClassName}(${ClassName} ${className}, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			${className}Service.delete${ClassName}(${className});
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新${className}	
	@RequestMapping(value="/update${classname}",method = RequestMethod.POST)
	public ModelAndView update${ClassName}(${ClassName} ${className}, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			${className}Service.update${ClassName}(${className});
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
