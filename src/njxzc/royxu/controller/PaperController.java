package njxzc.royxu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.domain.Paper;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchPaper;
import njxzc.royxu.service.AttachmentServiceImpl;
import njxzc.royxu.service.PaperServiceImpl;

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
import com.util.StringUtil;

/**
 * 文献Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class PaperController {
	private static final Logger LOG = LoggerFactory.getLogger(PaperController.class);
	
	@Autowired
	private PaperServiceImpl paperService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	
//	增加paper
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/savepaper",method=RequestMethod.POST)
	public ModelAndView savePaper(Paper paper,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			paper.setUser_no(session.getAttribute("user_no").toString());
			paperService.savePaper(paper);
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
					String new_name = "paper_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(paper.getPaper_id());
					attachment.setTable_of_attachment("roy_paper");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询papers	
	@RequestMapping(value="/listpapers",method = RequestMethod.POST)
	public ModelAndView listPapers(DataGridModel dmg,SearchPaper searchPaper, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = paperService.getSysParams(page, rows,searchPaper);
			mav.addObject("current_page", page);
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
	
	@RequestMapping(value="/listpagedpapers")
	public ModelAndView listPagedPapers(int offset,int limit,
			SearchPaper searchPaper,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchPaper.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = paperService.getPagedPapers(offset, limit,searchPaper);
				mav.addObject("total", pageData.getTotalCount());
				mav.addObject("rows", pageData.getData());
				mav.addObject("success",true);
			}else{
				@SuppressWarnings("rawtypes")
				List list = new ArrayList();
				mav.addObject("total", 0);
				mav.addObject("rows", list);
				mav.addObject("msg", "获取user_no失败，无法查询到您的数据");
				mav.addObject("success",false);
			}
			
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部papers	
	@RequestMapping(value="/listallpapers",method = RequestMethod.POST)
	public ModelAndView listAllPapers(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Paper> papers = paperService.loadAllPapers();
			mav.addObject("total", papers.size());
			mav.addObject("rows", papers);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	按条件查询
	@RequestMapping(value="/findpapers",method = RequestMethod.POST)
	public ModelAndView findPapers(SearchPaper searchPaper,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Paper> papers = paperService.findPapers(searchPaper);
			mav.addObject("total", papers.size());
			mav.addObject("rows", papers);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
//	删除所有的paper，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletepapers")
	public ModelAndView deletePapers(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Paper> papers = new ArrayList<Paper>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					//删除本地文件
					attachmentService.deleteAttachmentsByRelatedIdAndTname(id, "roy_paper");
					Paper paper = new Paper();
					paper.setPaper_id(id);
					papers.add(paper);
				}
			}
			paperService.deletePapers(papers);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个paper	
	@RequestMapping(value="/deletepaper",method = RequestMethod.POST)
	public ModelAndView deletePaper(Paper paper, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			paperService.deletePaper(paper);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新paper	
	@RequestMapping(value="/updatepaper",method = RequestMethod.POST)
	public ModelAndView updatePaper(Paper paper,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			paperService.updatePaper(paper);
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
					String new_name = "paper_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(paper.getPaper_id());
					attachment.setTable_of_attachment("roy_paper");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
