package com.human.admin;

import java.util.ArrayList;

import com.human.VO.SponsorBoardVO;

public class SponsorBoard_admin {
	

	private ArrayList<SponsorBoardVO> sList = new ArrayList<>();
	public void insert(SponsorBoardVO s) {
		sList.add(s);
	}
	public ArrayList<SponsorBoardVO> getList(){
		return sList;
	}
	
	public ArrayList<SponsorBoardVO> getSearch(String sword){
		ArrayList<SponsorBoardVO> searchList = new ArrayList<>();		
		for(int i=0; i < sList.size(); i++) {
			SponsorBoardVO temp = sList.get(i);
			if(temp.getTitle().indexOf(sword) != -1) {
				searchList.add(temp);
			}
		}		
		return searchList;
	}


}
