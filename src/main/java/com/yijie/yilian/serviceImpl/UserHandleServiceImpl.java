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
		userMapper.userSelect(user);
		//获取系统UUID
		user.setUuid(Uuid.getUuid());
		try {
			userMapper.userInsert(user);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//验证用户电话号码是否已使用（如果已存在返回错误编码0，不存在返回成功编码1）
	@Override
	public Integer userPhoneExist(String num) {
		Integer result = 0;
		User u = new User();
		u.setNum(num);
		List<User> userLisst = userMapper.userSelect(u);
		if(userLisst.isEmpty()){
			result = 1;
		}
		return result;
	}
	
	

}
