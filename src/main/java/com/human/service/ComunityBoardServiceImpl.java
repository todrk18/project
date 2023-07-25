package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.ComunityBoardVO;
import com.human.VO.PageVO;
import com.human.dao.ComunityBoardDAO;



@Service
public class ComunityBoardServiceImpl  implements ComunityBoardService{
	

	@Inject
	private  ComunityBoardDAO comunityboarddao;

	@Override
	public List<ComunityBoardVO> listAll(PageVO pageVO) throws Exception {
		
		return comunityboarddao.listAll(pageVO);
	}

	@Override
	public void insertOne(ComunityBoardVO cvo) throws Exception {
		
		comunityboarddao.insertOne(cvo);
	}

	@Override
	public ComunityBoardVO view_comunityboard(int viewno) throws Exception {
		
		comunityboarddao.cntupdate(viewno);
		
		return comunityboarddao.selectOne(viewno);
	}

	@Override
	public int totalCnt(String cword) throws Exception {
		
		return comunityboarddao.totalCnt(cword);
	}

	@Override
	public void del_comunityboard(int delno) throws Exception {
	
		comunityboarddao.delComunityboard(delno);
	}

	@Override
	public ComunityBoardVO mod_comunityboard(int modno) throws Exception {
		
		
		return comunityboarddao.selectOne(modno);
	}

	@Override
	public void mod_comunityboard(ComunityBoardVO cvo) throws Exception {
		
		comunityboarddao.modComunityboard(cvo);
		
	}
	
	
	

}
