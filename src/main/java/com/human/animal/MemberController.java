package com.human.animal;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.VO.MemberVO;
import com.human.service.MemberService;



@Controller

public class MemberController {
	@Inject
	MemberService membersrv;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	// 회원 확인
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(HttpServletRequest req) throws Exception {
;
	 
	 String userid = req.getParameter("userid");
	 MemberVO idCheck =  membersrv.idCheck(userid);
	 
	 int result = 0;
	 
	 if(idCheck != null) {
	  result = 1;
	 } 
	 
	 return result;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) throws Exception {
	
		
		
		return "register";
	}	
	
	@RequestMapping(value = "/register_save", method = RequestMethod.POST)
	public String register_save(Locale locale, Model model, @ModelAttribute("member") MemberVO vo) throws Exception {
	
		membersrv.register(vo);
		
		return "home";
	}	
	

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Locale locale, Model model) {
		
		return "modify";
	}
	

	@RequestMapping(value = "/modify_save", method = RequestMethod.POST)
	public String modify_save(Locale locale, Model model,HttpSession session,MemberVO vo) throws Exception {
		
		membersrv.modify(vo);
		session.invalidate();
		   
		return "redirect:/";
	}
	
	@RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
	public String withdrawal(Locale locale, Model model) {
		
		return "withdrawal";
	}
	
	@RequestMapping(value = "/withdrawal_save", method = RequestMethod.POST)
	public String withdrawal_save(Locale locale, Model model,HttpSession session,MemberVO vo,RedirectAttributes rttr
			
			) throws Exception  {
	
								
		
		MemberVO member = (MemberVO)session.getAttribute("nowUser");
		
		
		 String oldPass = member.getPass();
		 String newPass = vo.getPass();
		     
		
		if(!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg",false);
			return "redirect:/withdrawal";
		}
		
		membersrv.withdrawal(vo);
		session.invalidate();
		
		
		return "redirect:/";
	}
	
	
}
