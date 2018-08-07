package com.hsbc.unicorn.repository;

import com.hsbc.unicorn.entity.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author:CHM
 * @date:2018/8/7 15:15
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceDaoTest {

    @Autowired
    ResourceDao resourceDao;

    @Test
    public void findAll() {
        List<Resource> list=resourceDao.findAll();
        System.out.println(list);
    }
}