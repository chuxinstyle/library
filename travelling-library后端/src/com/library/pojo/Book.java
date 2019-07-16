package com.library.pojo;

public class Book {
	private  String bookname;
	private  String isbn;
	private  String bookdetail;
	private  String writer;
	private  String image;
	private  int newbook;
	private  String bookclass;
	private  String openId;
	private  String borrower;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getBookclass() {
		return bookclass;
	}
	public void setBookclass(String bookclass) {
		this.bookclass = bookclass;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String booknane) {
		this.bookname = booknane;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookdetail() {
		return bookdetail;
	}
	public void setBookdetail(String bookdetail) {
		this.bookdetail = bookdetail;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNewbook() {
		return newbook;
	}
	public void setNewbook(int newbook) {
		this.newbook = newbook;
	}

}
