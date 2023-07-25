package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.VO.PageVO;
import com.human.VO.SponsorBoardVO;

@Repository
public class SponsorBoardDAOImpl implements SponsorBoardDAO {
	
private static String mapperQuery = "com.human.dao.SponsorBoardDAO";
	
	@Inject  // 이 어노테이션이 있으면 컨테이너에서 객체를 받겠다는뜻.. 전제조건은 컨테이너에 객체가 있어야한다.
	private SqlSession sql; //객체는 컨테이너에 있다. 그 객체의 주소를 받아 오겠다.

	@Override
	public List<SponsorBoardVO> listAll(PageVO pagevo) throws Exception {
	
		return sql.selectList(mapperQuery+".selectall",pagevo);
	}

	@Override
	public void insertOne(SponsorBoardVO svo) throws Exception {
		
		sql.insert(mapperQuery+".insert",svo); 
		
	}

	@Override
	public SponsorBoardVO selectOne(int num_no) throws Exception {
		
		return sql.selectOne(mapperQuery+".selectOne",num_no);
	}

	@Override
	public void cntupdate(int num) throws Exception {
		
		sql.update(mapperQuery+".cntupdate",num);
		
	}

	@Override
	public int totalCnt(String sword) throws Exception {
		
		return sql.selectOne(mapperQuery+".totalCount",sword);
	}

	@Override
	public int getSq() throws Exception {
		
		return sql.selectOne(mapperQuery+".sponsor_seq_num");
	}

	@Override
	public void delSponsorboard(int delno) throws Exception {
	
		sql.delete(mapperQuery+".delSponsorboard",delno);
	}

	@Override
	public void modSponsorboard(SponsorBoardVO svo) throws Exception {
		
		 sql.update(mapperQuery+".modSponsorboard",svo);
	}

}
