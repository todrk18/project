package com.human.service;

import java.util.List;

import com.human.VO.FindBoardVO;
import com.human.VO.PageVO;






public interface FindBoardService {
	
	public List<FindBoardVO> listAll(PageVO pageVO) throws Exception;
	public void insertOne(FindBoardVO fvo) throws Exception;
	public FindBoardVO view_findboard(int viewno) throws Exception;
	public int totalCnt(String fword) throws Exception;
	public void del_findboard(int delno) throws Exception;
	public FindBoardVO mod_findboard(int modno) throws Exception;
	public void mod_findboard(FindBoardVO fvo) throws Exception;


}
