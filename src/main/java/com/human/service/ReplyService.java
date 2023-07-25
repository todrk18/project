package com.human.service;

import java.util.List;

import com.human.VO.ReplyVO;

public interface ReplyService {
	
	// 댓글 조회
	public List<ReplyVO> list(int viewno) throws Exception;
	
	// 댓글 작성
	public void write(ReplyVO vo) throws Exception;

	// 댓글 수정
	public void modify(ReplyVO vo) throws Exception;

	// 댓글 삭제
	public void delete(ReplyVO vo) throws Exception;

}
