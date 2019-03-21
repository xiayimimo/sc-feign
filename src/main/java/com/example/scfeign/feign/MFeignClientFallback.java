package com.example.scfeign.feign;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MFeignClientFallback implements MFeignClient{
	@Override
	public Object getUser(String id) {
		Object user = new Object();
	        return user;
	}

	@Override
	public List<Object> getUsers() {
		  return new ArrayList<Object>();
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return "测试断路器";
	}

}
