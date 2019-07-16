package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BookMapper;
import com.library.pojo.Book;
import com.library.pojo.PageBean;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;
	public List<Book> selectAll() {
		
		return bookMapper.selectAll();
	}
	public List<Book> selectBynewbook(int newbook) {
		
		return bookMapper.selectBynewbook(newbook);
	}
	public List<Book> selectBybookclass(String bookclass) {
		
		return bookMapper.selectBybookclass(bookclass);
	}
	public Book selectByisbn(String isbn) {
		
		return bookMapper.selectByisbn(isbn);
	}
	
	public void borrow(String borrower,String isbn) {
		bookMapper.borrow(borrower, isbn);
		
	}
	
	public void returnBook(String isbn) {
		bookMapper.returnBook(isbn);
		
	}
	
	public String publishbook(Book book) {
		
		Book b=bookMapper.selectByisbn(book.getIsbn());
		if(b==null)
		{bookMapper.publishbook(book);
		return "success";
		}
		else{
			return "fail"; 
		}
		
		
	}
	
	public List<Book> selectByborrower(String borrower) {
		
		return bookMapper.selectByborrower(borrower);
	}
    public List<Book> selectByopenId(String openId) {
		
		return bookMapper.selectByopenId(openId);
	}
	@Override
	public PageBean selectByPage(int currPage, String bookclass) {
				//自己指定每页显示多少数量的数据
				int pageSize =5;
				//数据库查询出总记录数
				int count =bookMapper.findBookCountbybookclass(bookclass);
				//转成double类型, 方便调用Math函数处理总页数,仅此而已
				double totalCount = count;
				//总页数
				int totalPage = (int) Math.ceil(totalCount / pageSize);
				//mysql中 使用limit查询的参数第一个为  起始记录数; 第二个为 每页的数量
				int begin = (currPage - 1) * pageSize;
				List<Book> list = bookMapper.findBookByPage(bookclass,begin , pageSize);
				//封装
				PageBean pg = new PageBean();
				pg.setCurrPage(currPage);
				pg.setPageSize(pageSize);
				pg.setCount(count);
				pg.setTotalPage(totalPage);
				pg.setList(list);
				return pg;
        }
	@Override
	public PageBean selectByPage(int currPage) {
		//自己指定每页显示多少数量的数据
		int pageSize =5;
		//数据库查询出总记录数
		int count =bookMapper.findBookCount();
		//转成double类型, 方便调用Math函数处理总页数,仅此而已
		double totalCount = count;
		//总页数
		int totalPage = (int) Math.ceil(totalCount / pageSize);
		//mysql中 使用limit查询的参数第一个为  起始记录数; 第二个为 每页的数量
		int begin = (currPage - 1) * pageSize;
		List<Book> list = bookMapper.findBook(begin , pageSize);
		//封装
		PageBean pg = new PageBean();
		pg.setCurrPage(currPage);
		pg.setPageSize(pageSize);
		pg.setCount(count);
		pg.setTotalPage(totalPage);
		pg.setList(list);
		return pg;
	}
	@Override
	public List<Book> selectcollectbook(String openid) {
		
		return bookMapper.selectcollectbook(openid);
	}
	@Override
	public void deleteBook(String openid,String isbn) {
		// TODO Auto-generated method stub
		bookMapper.deleteBook(openid,isbn);
	}

}
