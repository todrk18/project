package com.human.admin;

import java.util.ArrayList;

import com.human.VO.ProtectBoardVO;

public class ProtectBoard_admin {
	
	private ArrayList<ProtectBoardVO> pList = new ArrayList<>();
	public void insert(ProtectBoardVO p) {
		pList.add(p);
	}
	public ArrayList<ProtectBoardVO> getList(){
		return pList;
	}
	
	public ArrayList<ProtectBoardVO> getSearch(String pword){
		ArrayList<ProtectBoardVO> searchList = new ArrayList<>();		
		for(int i=0; i < pList.size(); i++) {
			ProtectBoardVO temp = pList.get(i);
			if(temp.getTitle().indexOf(pword) != -1) {
				searchList.add(temp);
			}
		}		
		return searchList;
	}

}
