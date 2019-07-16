package com.library.dao;
import com.library.pojo.Userinfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface UserinfoMapper {
	List<Userinfo> selectbyopenid(String openid);
	void           address(Userinfo userinfo);
	void           deleteaddress(String address,String openid);
	List<Userinfo> selectborrowmsg(String openid);

}
