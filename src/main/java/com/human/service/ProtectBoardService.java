package com.human.service;

import java.util.List;

import com.human.VO.PageVO;
import com.human.VO.ProtectBoardVO;

public interface ProtectBoardService {
	

	public List<ProtectBoardVO> listAll(PageVO pageVO) throws Exception;
	public void insertOne(ProtectBoardVO pvo) throws Exception;
	public ProtectBoardVO view_protectboard(int viewno) throws Exception;
	public int totalCnt(String pword) throws Exception;
	public void del_protectboard(int delno) throws Exception;
	public ProtectBoardVO mod_protectboard(int modno) throws Exception;
	public void mod_protectboard(ProtectBoardVO pvo) throws Exception;


}
