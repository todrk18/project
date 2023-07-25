package com.human.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.MemberVO;
import com.human.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject MemberDAO memberdao;

	@Override
	public void register(MemberVO vo) throws Exception {
		
		memberdao.register(vo);
		
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return memberdao.login(vo);
	}

	@Override
	public MemberVO idCheck(String userid) throws Exception {
		
		return memberdao.idCheck(userid);
	}

	@Override
	public void modify(MemberVO vo) throws Exception {
		
		memberdao.modify(vo);
		
	}

	@Override
	public void withdrawal(MemberVO vo) throws Exception {
		
		memberdao.withdrawal(vo);
		
	}

	

}
