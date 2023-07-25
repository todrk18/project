package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.ReplyVO;
import com.human.dao.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO replydao;

	@Override
	public List<ReplyVO> list(int viewno) throws Exception {
		
		return replydao.list(viewno);
	}

	@Override
	public void write(ReplyVO vo) throws Exception {
		
		replydao.write(vo);
	}

	@Override
	public void modify(ReplyVO vo) throws Exception {
		
		replydao.modify(vo);
	}

	@Override
	public void delete(ReplyVO vo) throws Exception {
		
		replydao.delete(vo);
	}
	
	

}
