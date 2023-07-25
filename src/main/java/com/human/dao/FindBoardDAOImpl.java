package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.VO.FindBoardVO;
import com.human.VO.PageVO;

@Repository
public class FindBoardDAOImpl implements FindBoardDAO {
	private static String mapperQuery = "com.human.dao.FindBoardDAO";
	@Inject  // 이 어노테이션이 있으면 컨테이너에서 객체를 받겠다는뜻.. 전제조건은 컨테이너에 객체가 있어야한다.
	private SqlSession sql; //객체는 컨테이너에 있다. 그 객체의 주소를 받아 오겠다.

	@Override
	public List<FindBoardVO> listAll(PageVO pagevo) throws Exception {
		
		return sql.selectList(mapperQuery+".selectall",pagevo);
	}

	@Override
	public void insertOne(FindBoardVO fvo) throws Exception {
		sql.insert(mapperQuery+".insert",fvo); 
		
	}

	@Override
	public FindBoardVO selectOne(int num_no) throws Exception {
		
		return  sql.selectOne(mapperQuery+".selectOne",num_no);
	}

	@Override
	public void cntupdate(int num) throws Exception {
		
		sql.update(mapperQuery+".cntupdate",num);
		
	}

	@Override
	public int totalCnt(String fword) throws Exception {
		
		return sql.selectOne(mapperQuery+".totalCount",fword);
	}

	@Override
	public int getSq() throws Exception {
		
		return sql.selectOne(mapperQuery+".animal_find_seq_num");
	}

	@Override
	public void delFindboard(int delno) throws Exception {
		sql.delete(mapperQuery+".delFindboard",delno);
		
	}

	@Override
	public void modFindboard(FindBoardVO fvo) throws Exception {
		 sql.update(mapperQuery+".modFindboard",fvo);
		
	}

	

}
