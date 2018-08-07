package com.hsbc.unicorn.service;

import java.util.List;

import com.hsbc.unicorn.entity.MyUserDetails;
import com.hsbc.unicorn.entity.Role;
import com.hsbc.unicorn.entity.User;
import com.hsbc.unicorn.repository.UserDao;
import com.hsbc.unicorn.repository.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 配置springsecurity数据库管理的类
 */
@Component
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userDao.findUserByUsername(username);
			// SecurityUser实现UserDetails并将SUser的Email映射为username
			if(user==null) {
				throw new UsernameNotFoundException(username);
			}
			Long userId = user.getId();
			List<Role> roles = userRoleDao.getRolesByUserId(userId);
			return new MyUserDetails(user,roles);
	}

}
