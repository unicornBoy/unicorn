package com.hsbc.unicorn.repository;

import java.util.List;

import com.hsbc.unicorn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 角色表的中间类
 */
public interface RoleDao extends JpaRepository<Role,Long> {

	/**
	 * 查出所有的角色列表
	 * @return
	 */
//	@Query("from Role")
	public  List<Role> findAll();

}
