package com.hsbc.unicorn.repository;

import java.util.List;

import com.hsbc.unicorn.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * resource资源表对应的dao类
 */
public interface ResourceDao extends JpaRepository<Resource,Long> {
//	@Query(value = "from Resource",nativeQuery = false)
	List<Resource> findAll();
}
