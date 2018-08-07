package com.hsbc.unicorn.repository;

import com.hsbc.unicorn.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 用户表相关的dao类
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	@Query(value = "select * from user where username=:username",nativeQuery = true)
	public User findUserByUsername(@Param("username") String username);
	
}
