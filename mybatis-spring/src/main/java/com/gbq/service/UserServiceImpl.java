package com.gbq.service;

import com.gbq.dao.OrderMapper;
import com.gbq.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderMapper orderMapper;

	public String selectUser(){
		System.out.println(orderMapper.selectOrder());
		return userMapper.selectUser();
	}
}
