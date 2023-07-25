package com.human.VO;

public class PageVO {
	
	private int startNo;  // 페이지에 출력할 게시물의 시작번호 > 데이터베이스 정렬 후 가져올 튜플의 시작
	private int endNo;    // 페이지에 출력할 게시물의 마지막 번호 > 데이터베이스 정렬 후 가져올 튜플의 마지막
	
	//이것은 계산 대상은 아님
	private int perPageNum=10;   // 2가지의미.. 1. 페이지에 출력할 게시물의 수 , 2. 페이지 그룹의 수
	private Integer page;       // 현재 페이지.. 클라이언트로부터 정보를 받는다. 그래서 Integer로 선언함
	                            // 클라이언트가 텍스트로 보내기 때문에 null로 인해 예외방지
	private int totalCount;  //전체 게시물 수.. select count(*) from schedule
	//-----------------------
	
	private int startPage;  // 페이지 그룹의 시작번호
	private int endPage;    // 페이지 그룹의 마지막 번호
	
	private boolean prev;  //이전 페이지 그룹이 있는가?
	private boolean next;  //다음 페이지 그룹이 있는가?
	
	private String search_word;
	//클라이언트는 파라미터로 page search_word
	//이것을 컨트롤러가 pageVO 객체로 매핑을 시킴
	//pageVO는 페이징 정보와 검색어 정보를 db나 view에게 전송하는 역할
	//지금 실습에서는 page 객체를 VO로 정의를 함
	
	
	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

	public void prt() {
		System.out.println("현재 페이지 번호: "+page);
		System.out.println("페이지 시작 글 번호: "+startNo);
		System.out.println("페이지 끝 번호: "+endNo);
		System.out.println("페이지 그룹 시작 번호: "+startPage);
		System.out.println("페이지 그룹 끝 번호: "+endPage);
		System.out.println("prev: "+prev);
		System.out.println("next: "+next);
		
	}
	
	public void calcPage() {       // 페이지 계산 알고리즘 메서드.
		// 페이지에 출력할 게시물의 시작번호
		startNo = (page-1)*perPageNum+1;
		
		// startPage 계산
		//1. 마지막페이지를 계산..
		//2. 마지막페이지 정보로 시작페이지를 계산.
		//마지막 페이지는 유동적이다. 왜냐면 게시물의 수에 따라 마지막 페이지가 달라질수 있다.
		int tempEndPage = (int)(Math.ceil(page/(double)perPageNum)*perPageNum);
		
		startPage = (tempEndPage-perPageNum)+1;
		//endPage 보정
		if(tempEndPage * perPageNum > totalCount) {
			endPage =  (int)(Math.ceil(totalCount/(double)perPageNum));
			if(endPage != page) {
				endNo = startNo + perPageNum -1 ;
			}else {
				endNo = startNo + totalCount%10-1;
			}
		}else {
			endPage = tempEndPage;
			endNo = startNo + perPageNum-1;
		}
		prev = startPage != 1;
		next = endPage*perPageNum < totalCount;
		
		
	}
	
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	

}
