package com.library.service;

import java.util.List;

import com.library.pojo.Book;
import com.library.pojo.PageBean;

public interface BookService {
 public List<Book> selectAll();
 public List<Book> selectBynewbook(int newbook);
 public List<Book> selectBybookclass(String bookclass);
 public Book       selectByisbn(String isbn);
 public void       borrow(String borrower ,String isbn);
 public void       returnBook(String isbn);
 public String       publishbook(Book book);
 public List<Book> selectByborrower(String borrower);
 public List<Book> selectByopenId(String openId);
 public PageBean   selectByPage(int currPage,String bookclass);
 public PageBean   selectByPage(int currPage);
 public List<Book> selectcollectbook(String openid);
 public void       deleteBook(String openid,String isbn);

}
