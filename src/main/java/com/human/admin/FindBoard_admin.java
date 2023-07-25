package com.human.admin;

import java.util.ArrayList;

import com.human.VO.FindBoardVO;



public class FindBoard_admin {
	
	private ArrayList<FindBoardVO> fList = new ArrayList<>();
	public void insert(FindBoardVO f) {
		fList.add(f);
	}
	public ArrayList<FindBoardVO> getList(){
		return fList;
	}
	
	public ArrayList<FindBoardVO> getSearch(String fword){
		ArrayList<FindBoardVO> searchList = new ArrayList<>();		
		for(int i=0; i < fList.size(); i++) {
			FindBoardVO temp = fList.get(i);
			if(temp.getTitle().indexOf(fword) != -1) {
				searchList.add(temp);
			}
		}		
		return searchList;
	}

}
