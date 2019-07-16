package com.library.controller;

import java.io.File;
import java.io.IOException;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import com.library.util.*;

import net.sf.json.JSONObject;

import com.library.pojo.Book;
import com.library.pojo.PageBean;
import com.library.service.BookService;
import com.library.pojo.Userinfo;
import com.library.service.UserinfoService;

/**
 *
 * 
 * 
 *
 */
@Controller
public class ItemController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserinfoService userinfoService;
	
	@ResponseBody
	@RequestMapping(value = "/deleteBook.action")
	public void deleteBook(String openid,String isbn){	
        
		bookService.deleteBook(openid,isbn);
	}
	//查询收藏的图书
		@ResponseBody
		@RequestMapping(value = "/selectcollectbook.action")
		public List<Book> selectcollectbook(String openid){	
	        
			return  bookService.selectcollectbook(openid);
		}
	//查询借阅信息
		@ResponseBody
		@RequestMapping(value = "/selectborrowmsg.action")
		public List<Userinfo> selectborrowmsg(String openid){	
	        
			return  userinfoService.selectborrowmsg(openid);
		}
	//查询地址列表
	@ResponseBody
	@RequestMapping(value = "/addresslist.action")
	public List<Userinfo> addresslist(String openid){	
        
		return  userinfoService.selectbyopenid(openid);
	}
	//增添地址信息
	@ResponseBody
	@RequestMapping(value = "/address.action")
	public void address(Userinfo userinfo){	
          System.out.print(userinfo.getAddress());
		  userinfoService.address(userinfo);
	}
	//删除地址信息
	@ResponseBody
	@RequestMapping(value = "/deleteaddress.action")
	public void deleteaddress(String address,String openid){	
        
		  userinfoService.deleteaddress(address, openid);
	}
	
	
    //查询所有图书
	@ResponseBody
	@RequestMapping(value = "/selectAll.action")
	public List<Book> selectAll(){	
        
		return  bookService.selectAll();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectBynewbook.action")
	public List<Book> selectBynewbook( int newbook){	


		return  bookService.selectBynewbook(newbook);
	}
	
	//根据种类查询图书
	@ResponseBody
	@RequestMapping(value = "/selectBybookclass.action")
	public List<Book> selectBybookclass(String bookclass){	
		

		return  bookService.selectBybookclass(bookclass);
	}
	
	//根据isbn号查询图书
	@ResponseBody
	@RequestMapping(value = "/selectByisbn.action")
	public Book selectByisbn( String isbn){	


		return  bookService.selectByisbn(isbn);
	}
	//借书
	@ResponseBody
	@RequestMapping(value = "/borrow.action")
	public void borrow(String borrower, String isbn){	

	
		bookService.borrow(borrower, isbn);
	}
	//还书
	@ResponseBody
	@RequestMapping(value = "/returnBook.action")
	public void returnBook( String isbn){	
		bookService.returnBook(isbn);
	}
	//根据借书人查询
	@ResponseBody
	@RequestMapping(value = "/selectByborrower.action")
	public List<Book> selectByborrower( String borrower){	
		 return bookService.selectByborrower(borrower);
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectByopenId.action")
	public List<Book> selectByopenId( String openId){	
		 return bookService.selectByopenId(openId);
	}
	//发布图书
	@ResponseBody
	@RequestMapping(value = "/publishbook.action")
	public String publishbook(Book book){
		
       return bookService.publishbook(book);
	}
	
	//分页查询
	@ResponseBody
	@RequestMapping(value = "/selectByPage.action")
	public PageBean selectByPage(int currPage, String bookclass){
		
		if(bookclass.equals("全部")){
			return bookService.selectByPage(currPage);
		}else
		 {return bookService.selectByPage(currPage, bookclass);}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getopenId.action")
	public String getopenId(String code) {
	   //小程序唯一标识   (在微信小程序管理后台获取)
	    String wxspAppid = "wx60c614b472bb68bf";
	    //小程序的 app secret (在微信小程序管理后台获取)
	    String wxspSecret = "4365bb78011ec15c8e63c11526bfad54";
	    //授权（必填）
	    String grant_type = "authorization_code";
	    //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
	    //请求参数
	    String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
	    //发送请求
	    String sr = HttpRequest.sendPost("https://api.weixin.qq.com/sns/jscode2session", params);
	    //解析相应内容（转换成json对象）
	    JSONObject json = JSONObject.fromObject(sr);
	    //用户的唯一标识（openid）
	    String openid = (String) json.get("openid");
	    return openid;   
	}

	
	//图片上传
	 @ResponseBody
	  @RequestMapping(value="/upload.action")
	    public String upload(Book book,HttpServletRequest request,  MultipartFile file) throws IOException {
	            String fileName = file.getOriginalFilename();
	            book.setImage("http://jxlbw.cn/travelling-library/image/"+fileName);
	            String path = null;
	            System.out.println(fileName);
	             //项目在容器中实际发布运行的根路径
	               String realPath = request.getSession().getServletContext().getRealPath("/");
	               System.out.println(realPath);
	               // 自定义的文件名称
	              String trueFileName = fileName;
	                // 设置存放图片文件的路径
	              path = realPath + "/image/" + trueFileName;     
	                file.transferTo(new File(path));
	                return bookService.publishbook(book);
	     	    }
	 
	
	 
	
	
}
