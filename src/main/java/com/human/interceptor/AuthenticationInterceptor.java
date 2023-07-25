package com.human.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("pre handle");
		// 인터셉터로 로그인 한 사람인지 인증체크
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("nowUser");
		
		//if(obj == null) {  // 로그인이 안된경우
		//	response.sendRedirect(request.getContextPath()+"/");
		//	return false;
		//}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("post handle");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	

}
