package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.VO.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject SqlSession sql;
	
	private static String namespace = "com.human.dao.ReplyDAO";
	
	@Override
	public List<ReplyVO> list(int viewno) throws Exception {
		
		return sql.selectList(namespace + ".replyList", viewno);
	}

	@Override
	public void write(ReplyVO vo) throws Exception {
		
		sql.insert(namespace + ".replyWrite", vo);
	}

	@Override
	public void modify(ReplyVO vo) throws Exception {
		
		sql.update(namespace + ".replyModify", vo);
	}

	@Override
	public void delete(ReplyVO vo) throws Exception {
		
		sql.delete(namespace + ".replyDelete", vo);
	}


}
