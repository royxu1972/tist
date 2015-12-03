package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Award;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchAward;
import njxzc.royxu.service.AwardServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;

/**
 * 个人荣誉Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class AwardController {
	private static final Logger LOG = LoggerFactory.getLogger(AwardController.class);
	
	@Autowired
	private AwardServiceImpl awardService;
	
//	增加award
	@RequestMapping(value="/saveaward",method=RequestMethod.POST)
	public ModelAndView saveAward(Award award, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			award.setUser_no(session.getAttribute("user_no").toString());
			awardService.saveAward(award);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询awards	
	@RequestMapping(value="/listawards",method = RequestMethod.POST)
	public ModelAndView listAwards(DataGridModel dmg,SearchAward searchAward, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = awardService.getSysParams(page, rows,searchAward);
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
	
	@RequestMapping(value="/listpagedawards")
	public ModelAndView listPagedAwards(int offset,int limit,
			SearchAward searchAward,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchAward.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = awardService.getPagedAwards(offset, limit,searchAward);
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
	
//	查询全部awards	
	@RequestMapping(value="/listallawards",method = RequestMethod.POST)
	public ModelAndView listAllAwards(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Award> awards = awardService.loadAllAwards();
			mav.addObject("total", awards.size());
			mav.addObject("rows", awards);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	
//	按条件查询
	@RequestMapping(value="/findawards",method = RequestMethod.POST)
	public ModelAndView findAwards(SearchAward searchAward,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Award> awards = awardService.findAwards(searchAward);
			mav.addObject("total", awards.size());
			mav.addObject("rows", awards);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的award，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deleteawards", method=RequestMethod.DELETE)
	public ModelAndView deleteAwards(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Award> awards = new ArrayList<Award>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					Award award = new Award();
					award.setAward_id(Integer.parseInt(id));
					awards.add(award);
				}
			}
			awardService.deleteAwards(awards);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个award	
	@RequestMapping(value="/deleteaward",method = RequestMethod.POST)
	public ModelAndView deleteAward(Award award, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			awardService.deleteAward(award);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新award	
	@RequestMapping(value="/updateaward",method = RequestMethod.POST)
	public ModelAndView updateAward(Award award, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			awardService.updateAward(award);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
