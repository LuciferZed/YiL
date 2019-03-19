package com.yijie.yilian.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.yilian.dao.UserMapper;
import com.yijie.yilian.model.User;
import com.yijie.yilian.service.UserHandleService;
import com.yijie.yilian.utils.Uuid;

@Service
public class UserHandleServiceImpl implements UserHandleService {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登录
	 */
	@Override
	public User userLogin(User user) {
		User u = null;
		List<User> userList = userMapper.userSelect(user);
		//验证密码
		if(userList.get(0).getPassword().equals(user.getPassword())){
			u = userList.get(0);
		}
		return u;
	}

	//用户注册
	@Override
	public Integer userRegist(User user) {
		Integer result = 0;
		//获取系统UUID
		user.setuuid(Uuid.getUuid());
		try {
			userMapper.userInsert(user);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
