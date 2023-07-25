package com.human.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.VO.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject SqlSession sql;
	
	//회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		
		sql.insert("memberMapper.register", vo);
		
	}
	
	//로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
	
		return sql.selectOne("memberMapper.login", vo);
	}
	
	//아이디 중복체크
	@Override
	public MemberVO idCheck(String userid) throws Exception {
		
		return sql.selectOne("memberMapper.idCheck", userid);
	}
	
	//회원정보 수정
	@Override
	public void modify(MemberVO vo) throws Exception {
		
		sql.update("memberMapper.modify", vo);
		
	}

	@Override
	public void withdrawal(MemberVO vo) throws Exception {
		
		sql.delete("memberMapper.withdrawal", vo);
		
	}
	
	

}
