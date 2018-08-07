package com.hsbc.unicorn.repository;

import java.util.List;

import com.hsbc.unicorn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 用户角色中间表的dao类
 */
public interface UserRoleDao extends JpaRepository<Role,Long> {

	/**
	 * 通过用户id获取角色信息
	 * @param userId
	 * @return
	 */
	@Query(value = "SELECT\n" +
			"\tr.id,\n" +
			"\tr. NAME\n" +
			"FROM\n" +
			"\tuser_role ur\n" +
			"LEFT JOIN role r ON ur.`role_id` = r.`id`\n" +
			"WHERE\n" +
			"\tur.id = :userId",nativeQuery = true)
	public List<Role> getRolesByUserId(@Param("userId") Long userId);
	
}
