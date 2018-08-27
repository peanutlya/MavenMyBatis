package com.etc.entity;

import com.etc.dao.SysUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SysUserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("SysUserMapperTest init");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryById(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            SysUser user = session.selectOne("queryById",2L);
            System.out.println(user);
            Assert.assertNull(user);
            //Assert.assertTrue(user != null);
        }
    }

    @Test
    public void testQueryById2(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            List<SysUser> users = session.selectList("queryById2",1L);
            System.out.println(users);
        }
    }

    @Test
    public void testQueryAll(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            List<SysUser> users = session.selectList("queryAll");
            System.out.println(users);
        }
    }

    @Test
    public void testQueryById3(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            SysUserDao userDao = session.getMapper(SysUserDao.class);
            SysUser user = userDao.queryById(1L);
            System.out.println(user);
        }
    }

    @Test
    public void testQueryAll2(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            SysUserDao userDao = session.getMapper(SysUserDao.class);
            List<SysUser> users = userDao.queryAll2();
            System.out.println(users);
        }
    }
}
