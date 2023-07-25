package com.human.admin;

import java.util.ArrayList;

import com.human.VO.ComunityBoardVO;



public class ComunityBoard_admin {
	
	private ArrayList<ComunityBoardVO> cList = new ArrayList<>();
	public void insert(ComunityBoardVO c) {
		cList.add(c);
	}
	public ArrayList<ComunityBoardVO> getList(){
		return cList;
	}
	
	public ArrayList<ComunityBoardVO> getSearch(String cword){
		ArrayList<ComunityBoardVO> searchList = new ArrayList<>();		
		for(int i=0; i < cList.size(); i++) {
			ComunityBoardVO temp = cList.get(i);
			if(temp.getTitle().indexOf(cword) != -1) {
				searchList.add(temp);
			}
		}		
		return searchList;
	}


}
