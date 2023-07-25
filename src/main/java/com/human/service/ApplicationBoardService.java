package com.human.service;

import java.util.List;

import com.human.VO.ApplicationBoardVO;
import com.human.VO.PageVO;

public interface ApplicationBoardService {

	public List<ApplicationBoardVO> listAll(PageVO pageVO) throws Exception;
	public void insertOne(ApplicationBoardVO avo) throws Exception;
	public ApplicationBoardVO view_applicationboard(int viewno) throws Exception;
	public int totalCnt(String aword) throws Exception;
	public void del_applicationboard(int delno) throws Exception;
	public ApplicationBoardVO mod_applicationboard(int modno) throws Exception;
	public void mod_applicationboard(ApplicationBoardVO avo) throws Exception;

}
