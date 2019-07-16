package com.library.pojo;

import java.util.List;
public class PageBean {
	private int currPage;  //当前页
	private int totalPage; //总页数
	private int count;     //总记录数
	private int pageSize;  //每页显示数量
	private List<Book> list; //用于存储每页显示的记录Book对象的个数
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	


}
