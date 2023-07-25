package com.human.VO;

import java.util.Date;

public class ComunityBoardVO {

	private int num;
	private String img_url;
	private String animal_kind;
	private String title;
	private String content;
	private String writer;
	private Date indate;
	private int cnt;
	private String img_thumb;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getAnimal_kind() {
		return animal_kind;
	}
	public void setAnimal_kind(String animal_kind) {
		this.animal_kind = animal_kind;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getImg_thumb() {
		return img_thumb;
	}
	public void setImg_thumb(String img_thumb) {
		this.img_thumb = img_thumb;
	}
	
}
