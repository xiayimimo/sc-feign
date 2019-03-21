package com.example.scfeign.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scfeign.feign.MFeignClient;


@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
    private MFeignClient feignClient;

    /**
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Object getUser(@PathVariable String id) {
    	Object user = feignClient.getUser(id);
        return user;
    }


    @GetMapping("list")
    public List<Object> users(HttpServletRequest request) {
        try {
            List<Object> users = feignClient.getUsers();
            return users == null ? new ArrayList<Object>() : users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("test")
    public String get() {
        return feignClient.getString();
    }
}
