package com.library.service;

import java.util.List;

import com.library.pojo.collect;

public interface collectService {
	public List<collect> selectcollect(String openid);
	public void addcollect(collect c);
	public void deletecollect (String isbn);

}
