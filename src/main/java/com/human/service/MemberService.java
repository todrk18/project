package com.human.service;

import com.human.VO.MemberVO;

public interface MemberService {

	public void register(MemberVO vo) throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public MemberVO idCheck(String userid) throws Exception;
	
	public void modify(MemberVO vo) throws Exception;
	
	public void withdrawal(MemberVO vo) throws Exception;
}
