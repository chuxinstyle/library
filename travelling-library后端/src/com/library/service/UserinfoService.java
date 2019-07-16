package com.library.service;
import java.util.List;

import com.library.pojo.Userinfo;

public interface UserinfoService {
	public List<Userinfo> selectbyopenid(String openid);
	public void address(Userinfo userinfo);
	public void deleteaddress(String address,String openid);
	public List<Userinfo>  selectborrowmsg   (String openid);

}
