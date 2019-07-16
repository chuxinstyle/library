package com.library.controller;
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

import com.library.pojo.collect;
import com.library.pojo.Userinfo;
import com.library.service.collectService;


@Controller
public class collectionController {
	@Autowired
	private collectService collectionService;
	//查询收藏信息
	@ResponseBody
	@RequestMapping(value = "/selectcollect.action")
	public List<collect> selectcollect(String openid){	
        
		return  collectionService.selectcollect(openid);
	}
 
	//添加收藏
		@ResponseBody
		@RequestMapping(value = "/addcollect.action")
		public void addcollect(collect c){	
	        
			collectionService.addcollect(c);
		}
		//取消收藏
		@ResponseBody
		@RequestMapping(value = "/deletecollect.action")
		public void deletecollect(String isbn){	
	        
		 collectionService.deletecollect(isbn);
		}
}
