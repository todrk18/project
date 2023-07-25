package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.ApplicationBoardVO;
import com.human.VO.PageVO;
import com.human.dao.ApplicationBoardDAO;



@Service
public class ApplicationBoardServiceImpl implements ApplicationBoardService  {
	

	@Inject
	private  ApplicationBoardDAO applicationboarddao;

	@Override
	public List<ApplicationBoardVO> listAll(PageVO pageVO) throws Exception {
		
		return applicationboarddao.listAll(pageVO);
	}

	@Override
	public void insertOne(ApplicationBoardVO avo) throws Exception {
		
		applicationboarddao.insertOne(avo);
	}

	@Override
	public ApplicationBoardVO view_applicationboard(int viewno) throws Exception {
		
		applicationboarddao.cntupdate(viewno);
		
		return applicationboarddao.selectOne(viewno);
	}

	@Override
	public int totalCnt(String aword) throws Exception {
		
		return applicationboarddao.totalCnt(aword);
	}

	@Override
	public void del_applicationboard(int delno) throws Exception {
		
		applicationboarddao.delApplicationboard(delno);
	}

	@Override
	public ApplicationBoardVO mod_applicationboard(int modno) throws Exception {
		
		return applicationboarddao.selectOne(modno);
	}

	@Override
	public void mod_applicationboard(ApplicationBoardVO avo) throws Exception {
		
		applicationboarddao.modApplicationboard(avo);
	}
	
	

}
