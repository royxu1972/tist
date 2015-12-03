package njxzc.royxu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.domain.BasicInfo;
import njxzc.royxu.domain.User;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchBasicInfo;
import njxzc.royxu.service.AttachmentServiceImpl;
import njxzc.royxu.service.BasicInfoServiceImpl;
import njxzc.royxu.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;
import com.util.StringUtil;

/**
 * 基本信息Controller
 * @author LiangHong
 * @version 2015-10-02
 */
@Controller
public class BasicInfoController {
	private static final Logger LOG = LoggerFactory.getLogger(BasicInfoController.class);
	
	@Autowired
	private BasicInfoServiceImpl basicInfoService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	@Autowired
	private UserServiceImpl userService;
	
//	增加basicInfo
	@RequestMapping(value="/savebasicinfo2",method=RequestMethod.POST)
	public ModelAndView saveBasicInfo2(BasicInfo basicInfo, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			basicInfoService.saveBasicInfo(basicInfo);
			//增加人员时默认添加账号
			User user = new User();
			user.setUser_name(basicInfo.getName());
			user.setUser_no(basicInfo.getIncrement_id());
			user.setUser_password("123456");
			user.setCreate_by(""+session.getAttribute("user_name"));
			String create_time = DateUtil.format2(new Date());
			user.setCreate_time(create_time);
			userService.saveUser(user);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	增加basicInfo
	@RequestMapping(value="/savebasicinfo",method=RequestMethod.POST)
	public ModelAndView saveBasicInfo(BasicInfo basicInfo,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			String realPath = request.getSession().getServletContext().getRealPath("/attachment");
			realPath = realPath.replace("\\", "/");
			File file = new File(realPath);
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				System.out.println("//不存在");
				file.mkdir();
			} else {
				System.out.println("//目录存在");
			}
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile mfile = multipartRequest.getFile(key);
				if (!mfile.isEmpty()) {
					String originalFilename = mfile.getOriginalFilename();
					String new_name = "info_"+StringUtil.generateFileName();
					// 获得文件的后缀名
					String file_end_name = originalFilename.substring(originalFilename.indexOf("."),originalFilename.length());
					// 新文件名后加上后缀名
					new_name += file_end_name;
					String file_size = "" + mfile.getSize();
					String file_type = mfile.getContentType();
					mfile.transferTo(new File(realPath, new_name));
					Attachment attachment = new Attachment();
					attachment.setDel_flag("0");
					attachment.setFile_path(realPath + "/" + new_name);
					attachment.setFile_type(file_type);
					attachment.setFile_size(file_size);
					attachment.setNew_name(new_name);
					attachment.setOriginal_name(originalFilename);
					attachment.setRelated_id(""+basicInfo.getIncrement_id());
					attachment.setTable_of_attachment("roy_basic_info");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			basicInfoService.saveBasicInfo(basicInfo);
			//增加人员时默认添加账号
			User user = new User();
			user.setUser_name(basicInfo.getName());
			user.setUser_no(basicInfo.getIncrement_id());
			user.setUser_password("123456");
			user.setCreate_by(""+session.getAttribute("user_name"));
			String create_time = DateUtil.format2(new Date());
			user.setCreate_time(create_time);
			userService.saveUser(user);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询basicInfos	
	@RequestMapping(value="/listbasicinfos",method = RequestMethod.POST)
	public ModelAndView listBasicInfos(DataGridModel dmg,SearchBasicInfo searchBasicInfo, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = basicInfoService.getSysParams(page, rows,searchBasicInfo);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedbasicinfos")
	public ModelAndView listPagedBasicInfos(int offset,int limit,SearchBasicInfo searchBasicInfo,String order){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = basicInfoService.getPagedBasicInfos(offset, limit,searchBasicInfo);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部basicInfos	
	@RequestMapping(value="/listallbasicinfos",method = RequestMethod.POST)
	public ModelAndView listAllBasicInfos(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<BasicInfo> basicInfos = basicInfoService.loadAllBasicInfos();
			mav.addObject("total", basicInfos.size());
			mav.addObject("rows", basicInfos);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部basicInfos	
	@RequestMapping(value="/findbasicinfos",method = RequestMethod.POST)
	public ModelAndView findBasicInfos(SearchBasicInfo searchBasicInfo,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<BasicInfo> basicInfos = basicInfoService.findBasicInfos(searchBasicInfo);
			mav.addObject("total", basicInfos.size());
			mav.addObject("rows", basicInfos);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查看首页个人信息
	@RequestMapping(value="/findbasicinfobysession",method = RequestMethod.POST)
	public ModelAndView findBasicInfoBySession(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				SearchBasicInfo searchBasicInfo = new SearchBasicInfo();
				searchBasicInfo.setS_increment_id(session.getAttribute("user_no").toString());
				List<BasicInfo> basicInfos = basicInfoService.findBasicInfos(searchBasicInfo);
				mav.addObject("total", basicInfos.size());
				mav.addObject("rows", basicInfos);
				mav.addObject("success",true);
			}else{
				List<BasicInfo> basicInfos = new ArrayList<BasicInfo>();
				mav.addObject("total", 0);
				mav.addObject("rows", basicInfos);
				mav.addObject("msg","无法查到您的相关信息，请联系管理员");
				mav.addObject("success",false);
			}
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的basicInfo，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletebasicinfos", method=RequestMethod.DELETE)
	public ModelAndView deleteBasicInfos(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<BasicInfo> basicInfos = new ArrayList<BasicInfo>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					BasicInfo basicInfo = new BasicInfo();
					basicInfo.setIncrement_id(id);
					basicInfos.add(basicInfo);
				}
			}
			basicInfoService.deleteBasicInfos(basicInfos);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个basicInfo	
	@RequestMapping(value="/deletebasicinfo",method = RequestMethod.POST)
	public ModelAndView deleteBasicInfo(BasicInfo basicInfo, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			basicInfoService.deleteBasicInfo(basicInfo);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新basicInfo	
	@RequestMapping(value="/updatebasicinfo2",method = RequestMethod.POST)
	public ModelAndView updateBasicInfo(BasicInfo basicInfo,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			basicInfoService.updateBasicInfo(basicInfo);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新basicInfo	
	@RequestMapping(value="/updatebasicinfo",method = RequestMethod.POST)
	public ModelAndView updateBasicInfo(BasicInfo basicInfo,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			String realPath = request.getSession().getServletContext().getRealPath("/attachment");
			realPath = realPath.replace("\\", "/");
			File file = new File(realPath);
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				System.out.println("//不存在");
				file.mkdir();
			} else {
				System.out.println("//目录存在");
			}
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile mfile = multipartRequest.getFile(key);
				if (!mfile.isEmpty()) {
					attachmentService.deleteAttachmentsByRelatedIdAndTname(basicInfo.getIncrement_id(), "roy_basic_info");
					String originalFilename = mfile.getOriginalFilename();
					String new_name = "info_"+StringUtil.generateFileName();
					// 获得文件的后缀名
					String file_end_name = originalFilename.substring(originalFilename.indexOf("."),originalFilename.length());
					// 新文件名后加上后缀名
					new_name += file_end_name;
					String file_size = "" + mfile.getSize();
					String file_type = mfile.getContentType();
					mfile.transferTo(new File(realPath, new_name));
					Attachment attachment = new Attachment();
					attachment.setDel_flag("0");
					attachment.setFile_path(realPath + "/" + new_name);
					attachment.setFile_type(file_type);
					attachment.setFile_size(file_size);
					attachment.setNew_name(new_name);
					attachment.setOriginal_name(originalFilename);
					attachment.setRelated_id(""+basicInfo.getIncrement_id());
					attachment.setTable_of_attachment("roy_basic_info");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			basicInfoService.updateBasicInfo(basicInfo);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
