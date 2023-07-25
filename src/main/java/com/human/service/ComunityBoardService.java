package com.human.service;

import java.util.List;

import com.human.VO.ComunityBoardVO;
import com.human.VO.PageVO;

public interface ComunityBoardService {
	
	public List<ComunityBoardVO> listAll(PageVO pageVO) throws Exception;
	public void insertOne(ComunityBoardVO cvo) throws Exception;
	public ComunityBoardVO view_comunityboard(int viewno) throws Exception;
	public int totalCnt(String cword) throws Exception;
	public void del_comunityboard(int delno) throws Exception;
	public ComunityBoardVO mod_comunityboard(int modno) throws Exception;
	public void mod_comunityboard(ComunityBoardVO cvo) throws Exception;



}
