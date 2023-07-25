package com.human.service;

import java.util.List;

import com.human.VO.PageVO;
import com.human.VO.SponsorBoardVO;

public interface SponsorBoardService {
	
	public List<SponsorBoardVO> listAll(PageVO pageVO) throws Exception;
	public void insertOne(SponsorBoardVO svo) throws Exception;
	public SponsorBoardVO view_sponsorboard(int viewno) throws Exception;
	public int totalCnt(String sword) throws Exception;
	public void del_sponsorboard(int delno) throws Exception;
	public SponsorBoardVO mod_sponsorboard(int modno) throws Exception;
	public void mod_sponsorboard(SponsorBoardVO svo) throws Exception;



}
