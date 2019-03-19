package com.yijie.yilian.dao;

import java.util.List;

import com.yijie.yilian.model.User;

public interface UserMapper {
	
	//用户账户查询
	public List<User> userSelect(User user);
	
	//用户账户添加
	public void userInsert(User user);
	
	//用户账户更新
	public void userUpdate(User user);
	
	//用户账户注销
	public void userDelete(User user);

}
