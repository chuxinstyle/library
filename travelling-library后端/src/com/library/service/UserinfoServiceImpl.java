package com.library.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.library.dao.UserinfoMapper;
import com.library.pojo.Userinfo;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper UserinfoMapper;
	public List<Userinfo> selectbyopenid(String openid) {
		
		return UserinfoMapper.selectbyopenid(openid);
	}
	@Override
	public void address(Userinfo userinfo) {
		UserinfoMapper.address(userinfo);
		
	}
	@Override
	public void deleteaddress(String address, String openid) {
		UserinfoMapper.deleteaddress(address, openid);
		
	}
	@Override
	public List<Userinfo> selectborrowmsg(String openid) {
		/*<select id ="selectborrowmeg" resultType="Userifo" parameterType="String" >
		SELECT u.name,u.address,u.mobile,u.openid,b.boookname FROM book b RIGHT OUTER JOIN userinfo u ON b.borrower=u.openid 
		WHERE b.openId=#{openid}

		</select>*/
		return UserinfoMapper.selectborrowmsg(openid);
	}

}
