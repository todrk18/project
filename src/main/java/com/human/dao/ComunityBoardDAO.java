package com.human.dao;

import java.util.List;

import com.human.VO.ComunityBoardVO;
import com.human.VO.PageVO;

public interface ComunityBoardDAO {
	
	public List<ComunityBoardVO> listAll(PageVO pagevo) throws Exception;
	public void insertOne(ComunityBoardVO cvo) throws Exception; 
	public ComunityBoardVO selectOne(int num_no) throws Exception;
	public void cntupdate(int num) throws Exception;
	public int totalCnt(String cword) throws Exception;
	public int getSq() throws Exception; // 시퀀스 가져오는 메서드 정의
	public void delComunityboard(int delno) throws Exception;
	public void modComunityboard(ComunityBoardVO cvo) throws Exception;


}
