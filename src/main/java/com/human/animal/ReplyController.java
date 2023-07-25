package com.human.animal;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.VO.ReplyVO;
import com.human.service.ReplyService;

@Controller
public class ReplyController {
	
	@Inject 
	private ReplyService replysrv;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	

	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public String reply(Locale locale, Model model) {
		
		return "reply";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(ReplyVO vo ,Locale locale, Model model) throws Exception {
		
		replysrv.write(vo);
		
		return "redirect:/comunityboard_detail?viewno=" + vo.getNum();
	}
	
}
