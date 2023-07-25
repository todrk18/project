package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.FindBoardVO;
import com.human.VO.PageVO;
import com.human.dao.FindBoardDAO;


@Service
public class FindBoardServiceImpl implements FindBoardService{
	
	@Inject
	private FindBoardDAO findboarddao;
	

	@Override
	public List<FindBoardVO> listAll(PageVO pageVO) throws Exception {
		
		return  findboarddao.listAll(pageVO);
	}

	@Override
	public void insertOne(FindBoardVO fvo) throws Exception {
		
		findboarddao.insertOne(fvo);
		
	}

	@Override
	public FindBoardVO view_findboard(int viewno) throws Exception {
		  
		findboarddao.cntupdate(viewno);
	      
		return findboarddao.selectOne(viewno);
	}

	@Override
	public int totalCnt(String fword) throws Exception {
		
		return  findboarddao.totalCnt(fword);
	}

	@Override
	public void del_findboard(int delno) throws Exception {
	
		findboarddao.delFindboard(delno);

		
	}

	@Override
	public FindBoardVO mod_findboard(int modno) throws Exception {
		
		return findboarddao.selectOne(modno);
	}

	@Override
	public void mod_findboard(FindBoardVO fvo) throws Exception {
		
		 findboarddao.modFindboard(fvo);
		
		
	}

}
