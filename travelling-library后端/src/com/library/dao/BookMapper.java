package com.library.dao;
import com.library.pojo.Book;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
   

	List<Book> selectAll();
	List<Book> selectBynewbook(int newbook);
    List<Book> selectBybookclass(String bookclass);
    Book       selectByisbn(String isbn);
    void       borrow(String borrower, String isbn);
    void       returnBook(String isbn);
    void       deleteBook(String openid,String isbn);
    void       publishbook(Book book);
    List<Book> selectByborrower(String borrower);
    List<Book> selectByopenId(String openId);
	List<Book> findBookByPage( String bookclass,int begin, int pageSize);
	int        findBookCountbybookclass(String bookclass);
	int        findBookCount();
	List<Book> findBook(int begin, int pageSize);
	List<Book> selectcollectbook(String openid);

}
