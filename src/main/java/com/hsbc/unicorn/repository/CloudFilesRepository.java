package com.hsbc.unicorn.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hsbc.unicorn.entity.CloudFiles;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CloudFilesRepository extends PagingAndSortingRepository<CloudFiles, Long> {
    @Modifying
    @Transactional
    @Query(value = "update CloudFiles set fileName=:name where id=:id" ,nativeQuery = false)
    public void update(@Param("id")Long id, @Param("name") String name);
}
