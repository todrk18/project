package com.human.admin;

import java.util.ArrayList;

import com.human.VO.ApplicationBoardVO;



public class ApplicationBoard_admin {
	

	private ArrayList< ApplicationBoardVO> aList = new ArrayList<>();
	public void insert( ApplicationBoardVO a) {
		aList.add(a);
	}
	public ArrayList< ApplicationBoardVO> getList(){
		return aList;
	}
	
	public ArrayList< ApplicationBoardVO> getSearch(String aword){
		ArrayList< ApplicationBoardVO> searchList = new ArrayList<>();		
		for(int i=0; i < aList.size(); i++) {
			 ApplicationBoardVO temp = aList.get(i);
			if(temp.getTitle().indexOf(aword) != -1) {
				searchList.add(temp);
			}
		}		
		return searchList;
	}


}
