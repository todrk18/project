package com.human.dao;

import java.util.List;

import com.human.VO.ApplicationBoardVO;
import com.human.VO.PageVO;

public interface ApplicationBoardDAO {
	

	public List<ApplicationBoardVO> listAll(PageVO pagevo) throws Exception;
	public void insertOne(ApplicationBoardVO avo) throws Exception; 
	public ApplicationBoardVO selectOne(int num_no) throws Exception;
	public void cntupdate(int num) throws Exception;
	public int totalCnt(String aword) throws Exception;
	public int getSq() throws Exception; // 시퀀스 가져오는 메서드 정의
	public void delApplicationboard(int delno) throws Exception;
	public void modApplicationboard(ApplicationBoardVO avo) throws Exception;


}
