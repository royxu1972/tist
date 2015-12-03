package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Notice;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.service.NoticeServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;


/**
 * 消息发布Controller
 * @author Author
 * @version 2015-07-17
 */
@Controller
public class NoticeController {
	private static final Logger LOG = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeServiceImpl noticeService;
	
//	增加notice
	@RequestMapping(value="/savenotice")
	public ModelAndView saveNotice(Notice notice, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			notice.setNotice_time(DateUtil.format2(new Date()));
			noticeService.saveNotice(notice);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	

//	easyui分页查询notices	
	@RequestMapping(value="/listnotices",method = RequestMethod.POST)
	public ModelAndView listNotices(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = noticeService.getSysParams(page, rows);
			int totalpage = noticeService.counttotal(rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("totalpage", totalpage);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部notices	
	@RequestMapping(value="/listallnotices",method = RequestMethod.POST)
	public ModelAndView listAllNotices(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Notice> notices = noticeService.loadAllNotices();
			mav.addObject("total", notices.size());
			mav.addObject("rows", notices);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagednotices")
	public ModelAndView listPagedNotices(int offset,int limit,String order){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = noticeService.getPagedHomeworks(offset, limit);
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

	@RequestMapping(value="/listnoticebyid",method = RequestMethod.POST)
	public ModelAndView listnoticebyid(String notice_id, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Notice> notices = noticeService.searchById(notice_id);
			mav.addObject("total", notices.size());
			mav.addObject("rows", notices);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除所有的notice，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletenotices", method=RequestMethod.POST)
	public ModelAndView deleteNotices(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Notice> notices = new ArrayList<Notice>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					Notice notice = new Notice();
					notice.setNotice_id(id);
					notices.add(notice);
				}
			}
			noticeService.deleteNotices(notices);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个notice	
	@RequestMapping(value="/deletenotice")
	public ModelAndView deleteNotice(Notice notice, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			noticeService.deleteNoticeAndFile(notice);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新notice	
	@RequestMapping(value="/updatenotice")
	public ModelAndView updateNotice(Notice notice, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			notice.setNotice_time(DateUtil.format2(new Date()));
			noticeService.updateNotice(notice);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
