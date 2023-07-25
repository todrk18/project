package com.human.dao;

import java.util.List;

import com.human.VO.PageVO;
import com.human.VO.SponsorBoardVO;

public interface SponsorBoardDAO {
	
	public List<SponsorBoardVO> listAll(PageVO pagevo) throws Exception;
	public void insertOne(SponsorBoardVO svo) throws Exception; 
	public SponsorBoardVO selectOne(int num_no) throws Exception;
	public void cntupdate(int num) throws Exception;
	public int totalCnt(String sword) throws Exception;
	public int getSq() throws Exception; // 시퀀스 가져오는 메서드 정의
	public void delSponsorboard(int delno) throws Exception;
	public void modSponsorboard(SponsorBoardVO svo) throws Exception;


}
