package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.PageVO;
import com.human.VO.ProtectBoardVO;
import com.human.dao.ProtectBoardDAO;

@Service
public class ProtectBoardServiceImpl implements ProtectBoardService{
	
	@Inject
	private ProtectBoardDAO protectboarddao;

	@Override
	public List<ProtectBoardVO> listAll(PageVO pageVO) throws Exception {
		
		return protectboarddao.listAll(pageVO);
	}

	@Override
	public void insertOne(ProtectBoardVO pvo) throws Exception {
		
		protectboarddao.insertOne(pvo);
	}

	@Override
	public ProtectBoardVO view_protectboard(int viewno) throws Exception {
		
		protectboarddao.cntupdate(viewno);
		
		return protectboarddao.selectOne(viewno);
	}

	@Override
	public int totalCnt(String pword) throws Exception {
		
		return protectboarddao.totalCnt(pword);
	}

	@Override
	public void del_protectboard(int delno) throws Exception {
		
		protectboarddao.delProtectboard(delno);
		
	}

	@Override
	public ProtectBoardVO mod_protectboard(int modno) throws Exception {
		
		return protectboarddao.selectOne(modno);
	}

	@Override
	public void mod_protectboard(ProtectBoardVO pvo) throws Exception {
		
		 protectboarddao.modProtectboard(pvo);
		
	}

}
