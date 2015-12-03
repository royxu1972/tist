package njxzc.royxu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.EmailRandom;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchEmailRandom;
import njxzc.royxu.service.BasicInfoServiceImpl;
import njxzc.royxu.service.EmailRandomServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;
import com.util.MailUtil;
import com.util.RandomUtil;

/**
 * 邮箱验证码Controller
 * @author LiangHong
 * @version 2015-11-02
 */
@Controller
public class EmailRandomController {
	private static final Logger LOG = LoggerFactory.getLogger(EmailRandomController.class);
	
	@Autowired
	private EmailRandomServiceImpl emailRandomService;
	@Autowired
	private BasicInfoServiceImpl basicInfoService;
	
//	增加emailRandom
	@RequestMapping(value="/saveemailrandom",method=RequestMethod.POST)
	public ModelAndView saveEmailRandom(EmailRandom emailRandom, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			String random_code = RandomUtil.generateString(10);
			String send_time = DateUtil.format2(new Date());
			emailRandom.setRandom_code(random_code);
			emailRandom.setSend_time(send_time);
			emailRandom.setIs_validated("未验证");
			emailRandomService.saveEmailRandom(emailRandom);
			MailUtil.sendValidateCodeTo("448027296@qq.com", random_code);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	增加emailRandom
	@RequestMapping(value="/validateemail",method=RequestMethod.POST)
	public ModelAndView validateEmail(EmailRandom emailRandom, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			String validate_time = DateUtil.format2(new Date());
			emailRandom = emailRandomService.validateEmail(emailRandom.getEmail(), emailRandom.getUser_no(), emailRandom.getRandom_code());
			if(emailRandom != null){
				emailRandom.setValidate_time(validate_time);
				emailRandom.setIs_validated("验证通过");
				emailRandomService.updateEmailRandom(emailRandom);
				basicInfoService.updateEmailValidated(emailRandom.getUser_no(), "已验证");
				mav.addObject("is_validated",true);
				mav.addObject("success",true);
			}else{
				mav.addObject("success", false);
				mav.addObject("msg", "验证码不正确");
			}
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询emailRandoms	
	@RequestMapping(value="/listemailrandoms",method = RequestMethod.POST)
	public ModelAndView listEmailRandoms(DataGridModel dmg,SearchEmailRandom searchEmailRandom, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = emailRandomService.getSysParams(page, rows, searchEmailRandom);
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
	
//	查询全部emailRandoms	
	@RequestMapping(value="/listallemailrandoms",method = RequestMethod.POST)
	public ModelAndView listAllEmailRandoms(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<EmailRandom> emailRandoms = emailRandomService.loadAllEmailRandoms();
			mav.addObject("total", emailRandoms.size());
			mav.addObject("rows", emailRandoms);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	按条件查询
	@RequestMapping(value="/findemailrandoms",method = RequestMethod.POST)
	public ModelAndView findEmailRandoms(SearchEmailRandom searchEmailRandom,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<EmailRandom> emailRandoms = emailRandomService.findEmailRandoms(searchEmailRandom);
			mav.addObject("total", emailRandoms.size());
			mav.addObject("rows", emailRandoms);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的emailRandom，其中ids为主键的数组，需自定义，如需此方法解开注释修改
//	@RequestMapping(value="/deleteemailrandoms", method=RequestMethod.DELETE)
//	public ModelAndView deleteEmailRandoms(String[] ids, HttpSession session){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
//			List<EmailRandom> emailRandoms = new ArrayList<EmailRandom>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					EmailRandom emailRandom = new EmailRandom();
//					emailRandom.setEmailRandom_id(Integer.parseInt(id));
//					emailRandoms.add(emailRandom);
//				}
//			}
//			emailRandomService.deleteEmailRandoms(emailRandoms);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			LOG.error(e.getMessage(), e);
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
	
//	删除一个emailRandom	
	@RequestMapping(value="/deleteemailrandom",method = RequestMethod.POST)
	public ModelAndView deleteEmailRandom(EmailRandom emailRandom, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			emailRandomService.deleteEmailRandom(emailRandom);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新emailRandom	
	@RequestMapping(value="/updateemailrandom",method = RequestMethod.POST)
	public ModelAndView updateEmailRandom(EmailRandom emailRandom, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			emailRandomService.updateEmailRandom(emailRandom);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}
