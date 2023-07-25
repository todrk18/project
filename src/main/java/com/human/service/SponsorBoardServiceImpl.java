package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.VO.PageVO;
import com.human.VO.SponsorBoardVO;
import com.human.dao.SponsorBoardDAO;



@Service
public class SponsorBoardServiceImpl implements SponsorBoardService {
	

	@Inject
	private SponsorBoardDAO sponsorboarddao;

	@Override
	public List<SponsorBoardVO> listAll(PageVO pageVO) throws Exception {
		
		return sponsorboarddao.listAll(pageVO);
	}

	@Override
	public void insertOne(SponsorBoardVO svo) throws Exception {
		
		sponsorboarddao.insertOne(svo);
	}

	@Override
	public SponsorBoardVO view_sponsorboard(int viewno) throws Exception {
		
		sponsorboarddao.cntupdate(viewno);
		
		return sponsorboarddao.selectOne(viewno);
	}

	@Override
	public int totalCnt(String sword) throws Exception {
		
		return sponsorboarddao.totalCnt(sword);
	}

	@Override
	public void del_sponsorboard(int delno) throws Exception {
	
		sponsorboarddao.delSponsorboard(delno);
	}

	@Override
	public SponsorBoardVO mod_sponsorboard(int modno) throws Exception {
		
		return sponsorboarddao.selectOne(modno);
	}

	@Override
	public void mod_sponsorboard(SponsorBoardVO svo) throws Exception {
		
		 sponsorboarddao.modSponsorboard(svo);
	}

}
