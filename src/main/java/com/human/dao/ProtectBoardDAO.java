package com.human.dao;

import java.util.List;

import com.human.VO.PageVO;
import com.human.VO.ProtectBoardVO;

public interface ProtectBoardDAO {
	
	public List<ProtectBoardVO> listAll(PageVO pagevo) throws Exception;
	public void insertOne(ProtectBoardVO pvo) throws Exception; 
	public ProtectBoardVO selectOne(int num_no) throws Exception;
	public void cntupdate(int num) throws Exception;
	public int totalCnt(String pword) throws Exception;
	public int getSq() throws Exception; // 시퀀스 가져오는 메서드 정의
	public void delProtectboard(int delno) throws Exception;
	public void modProtectboard(ProtectBoardVO pvo) throws Exception;


}
