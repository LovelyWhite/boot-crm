package com.itheima.core.service;
import com.itheima.core.po.User;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface UserService {
	// 通过账号和密码查询用户
	public User findUser(String usercode,String password);
	public int setFace(String usercode , String pic);
	public List<User> getUsers();
}
