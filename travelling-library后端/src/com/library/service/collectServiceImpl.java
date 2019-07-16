package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.collectMapper;
import com.library.pojo.collect;
@Service
public class collectServiceImpl implements collectService {
	@Autowired
    private collectMapper collectionMapper;
	@Override
	public List<collect> selectcollect(String openid) {
		// TODO Auto-generated method stub
		return collectionMapper.selectcollect(openid);
	}
	@Override
	public void addcollect(collect c) {
		// TODO Auto-generated method stub
		collectionMapper.addcollect(c);
		
	}
	@Override
	public void deletecollect(String isbn) {
		// TODO Auto-generated method stub
		collectionMapper.deletecollect(isbn);
	}
	

}
