package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.VO.ComunityBoardVO;
import com.human.VO.PageVO;

@Repository
public class ComunityBoardDAOImpl  implements ComunityBoardDAO {
	
	private static String mapperQuery = "com.human.dao.ComunityBoardDAO";
	@Inject  // 이 어노테이션이 있으면 컨테이너에서 객체를 받겠다는뜻.. 전제조건은 컨테이너에 객체가 있어야한다.
	private SqlSession sql; //객체는 컨테이너에 있다. 그 객체의 주소를 받아 오겠다.
	
	@Override
	public List<ComunityBoardVO> listAll(PageVO pagevo) throws Exception {
		
		return sql.selectList(mapperQuery+".selectall",pagevo);
	}
	@Override
	public void insertOne(ComunityBoardVO cvo) throws Exception {
		
		sql.insert(mapperQuery+".insert",cvo); 
	}
	@Override
	public ComunityBoardVO selectOne(int num_no) throws Exception {
		
		return sql.selectOne(mapperQuery+".selectOne",num_no);
	}
	@Override
	public void cntupdate(int num) throws Exception {
		
		sql.update(mapperQuery+".cntupdate",num);
	}
	@Override
	public int totalCnt(String cword) throws Exception {
		
		return sql.selectOne(mapperQuery+".totalCount",cword);
	}
	@Override
	public int getSq() throws Exception {
		
		return sql.selectOne(mapperQuery+".comunity_seq_num");
	}
	@Override
	public void delComunityboard(int delno) throws Exception {
		
		sql.delete(mapperQuery+".delComunityboard",delno);
	}
	@Override
	public void modComunityboard(ComunityBoardVO cvo) throws Exception {
		
		 sql.update(mapperQuery+".modComunityboard",cvo);
	}


}
