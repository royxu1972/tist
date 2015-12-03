package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;

import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.domain.GroupMember;
import njxzc.royxu.service.GroupMemberServiceImpl;

/**
 * 项目组成员Controller
 * @author LiangHong
 * @version 2015-10-24
 */
@Controller
public class GroupMemberController {
	private static final Logger LOG = LoggerFactory.getLogger(GroupMemberController.class);
	
	@Autowired
	private GroupMemberServiceImpl groupMemberService;
	
//	增加groupMember
	@RequestMapping(value="/savegroupmember",method=RequestMethod.POST)
	public ModelAndView saveGroupMember(GroupMember groupMember, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			groupMemberService.saveGroupMember(groupMember);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询groupMembers	
	@RequestMapping(value="/listgroupmembers",method = RequestMethod.POST)
	public ModelAndView listGroupMembers(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = groupMemberService.getSysParams(page, rows);
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
	
	@RequestMapping(value="/listpagedgroupmembers")
	public ModelAndView listPagedGroupMembers(int offset,int limit,String order){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = groupMemberService.getPagedGroupMembers(offset, limit);
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
	
//	查询全部groupMembers	
	@RequestMapping(value="/findgroupmembers",method = RequestMethod.POST)
	public ModelAndView findGroupMembers(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<GroupMember> groupMembers = groupMemberService.findGroupMembers();
			mav.addObject("total", groupMembers.size());
			mav.addObject("rows", groupMembers);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部groupMembers	
	@RequestMapping(value="/listallgroupmembers",method = RequestMethod.POST)
	public ModelAndView listAllGroupMembers(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<GroupMember> groupMembers = groupMemberService.loadAllGroupMembers();
			mav.addObject("total", groupMembers.size());
			mav.addObject("rows", groupMembers);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的groupMember，其中ids为主键的数组，需自定义，如需此方法解开注释修改
//	@RequestMapping(value="/deletegroupmembers", method=RequestMethod.DELETE)
//	public ModelAndView deleteGroupMembers(String[] ids, HttpSession session){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
//			List<GroupMember> groupMembers = new ArrayList<GroupMember>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					GroupMember groupMember = new GroupMember();
//					groupMember.setGroupMember_id(Integer.parseInt(id));
//					groupMembers.add(groupMember);
//				}
//			}
//			groupMemberService.deleteGroupMembers(groupMembers);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			LOG.error(e.getMessage(), e);
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
	
//	删除一个groupMember	
	@RequestMapping(value="/deletegroupmember",method = RequestMethod.POST)
	public ModelAndView deleteGroupMember(GroupMember groupMember, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			groupMemberService.deleteGroupMember(groupMember);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新groupMember	
	@RequestMapping(value="/updategroupmember",method = RequestMethod.POST)
	public ModelAndView updateGroupMember(GroupMember groupMember, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			groupMemberService.updateGroupMember(groupMember);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
