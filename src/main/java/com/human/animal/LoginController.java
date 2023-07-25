package com.human.animal;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.VO.MemberVO;
import com.human.service.MemberService;



@Controller
public class LoginController {
	@Inject
	MemberService membersrv;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Locale locale, Model model, 
		    HttpSession session,MemberVO vo,RedirectAttributes rttr,
			@RequestParam("userid") String userid,
			@RequestParam("pass") String pass) throws Exception  {
		
		//인증절차
		//1. db 조회 select * from member where id=? and pwd=? <생략>
			
		//2. 회원이라고 가정하고 세션만 먼저 공부해보자
				MemberVO login = membersrv.login(vo);
				
				if(login == null) {
					//session.setAttribute("nowUser", null);
					rttr.addFlashAttribute("msg",false);
				} else {
					session.setAttribute("nowUser", userid);
					session.setAttribute("grade", "vvip");
				}
			// 내가 원하는 정보를 설정합니다.
			// 눈에 보이지는 않치만 쿠키와 세션 id는 이미 만들어진 상태
				
		        return "redirect:/";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, 
		    HttpSession session) {
		
		session.invalidate();
		return "home";  //세션을 무력화
	}


}
