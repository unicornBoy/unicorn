package com.hsbc.unicorn.repository;

import java.util.List;

import com.hsbc.unicorn.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 角色资源中间表的dao类
 */
public interface RoleResourceDao extends PagingAndSortingRepository<Role, Long> {
	/**
	 * 通过资源的id获取所有的角色
	 * 		先通过role_resource中间表的resource_id查出对应的role_id
	 * 		再通过role表的id查出对应的所有信息
	 * @return
	 */
	@Query(value = "SELECT\n" +
			"\tr.*\n" +
			"FROM\n" +
			"\trole_resource rr\n" +
			"LEFT JOIN Role r ON rr.role_id = r.id\n" +
			"WHERE\n" +
			"\trr.Resource_id = :resourceId",nativeQuery = true)
	List<Role> findRolesByResourceUrl(@Param("resourceId") Long resourceId);
}
