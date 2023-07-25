package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.VO.PageVO;
import com.human.VO.ProtectBoardVO;

@Repository
public class ProtectBoardDAOImpl implements ProtectBoardDAO {
	
	private static String mapperQuery = "com.human.dao.ProtectBoardDAO";
	
	@Inject  // 이 어노테이션이 있으면 컨테이너에서 객체를 받겠다는뜻.. 전제조건은 컨테이너에 객체가 있어야한다.
	private SqlSession sql; //객체는 컨테이너에 있다. 그 객체의 주소를 받아 오겠다.

	@Override
	public List<ProtectBoardVO> listAll(PageVO pagevo) throws Exception {
		
		return sql.selectList(mapperQuery+".selectall",pagevo);
	}

	@Override
	public void insertOne(ProtectBoardVO pvo) throws Exception {
		
		sql.insert(mapperQuery+".insert",pvo); 
		
	}

	@Override
	public ProtectBoardVO selectOne(int num_no) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(mapperQuery+".selectOne",num_no);
	}

	@Override
	public void cntupdate(int num) throws Exception {
		
		sql.update(mapperQuery+".cntupdate",num);

		
	}

	@Override
	public int totalCnt(String pword) throws Exception {
		
		return sql.selectOne(mapperQuery+".totalCount",pword);
	}

	@Override
	public int getSq() throws Exception {
		
		return sql.selectOne(mapperQuery+".animal_protect_seq_num");
	}

	@Override
	public void delProtectboard(int delno) throws Exception {
		
		sql.delete(mapperQuery+".delProtectboard",delno);
	}

	@Override
	public void modProtectboard(ProtectBoardVO pvo) throws Exception {
		
		 sql.update(mapperQuery+".modProtectboard",pvo);
	}


}
