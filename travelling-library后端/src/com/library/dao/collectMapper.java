package com.library.dao;
import java.util.List;

import com.library.pojo.collect;
public interface collectMapper {
	  List<collect> selectcollect(String openid);
	  void  addcollect(collect c);
	  void  deletecollect(String isbn);

}
