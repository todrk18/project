package com.human.dao;

import java.util.List;

import com.human.VO.FindBoardVO;
import com.human.VO.PageVO;





public interface FindBoardDAO {
	

	public List<FindBoardVO> listAll(PageVO pagevo) throws Exception;
	public void insertOne(FindBoardVO fvo) throws Exception; 
	public FindBoardVO selectOne(int num_no) throws Exception;
	public void cntupdate(int num) throws Exception;
	public int totalCnt(String fword) throws Exception;
	public int getSq() throws Exception; // 시퀀스 가져오는 메서드 정의
	public void delFindboard(int delno) throws Exception;
	public void modFindboard(FindBoardVO fvo) throws Exception;

}
