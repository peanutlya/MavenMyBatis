package com.etc.entity;

import com.etc.dao.SysUserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class SysUserMapperTest extends  BaseMapperTest {

    @Test
    public void testQueryById(){
        try(SqlSession session = this.getSqlSession()){
            SysUser user = session.selectOne("queryById",2L);
            System.out.println(user);
            Assert.assertNull(user);
            //Assert.assertTrue(user != null);
        }
    }

    @Test
    public void testQueryById2(){
        try(SqlSession session = this.getSqlSession()){
            List<SysUser> users = session.selectList("queryById2",1L);
            System.out.println(users);
        }
    }

    @Test
    public void testQueryAll(){
        try(SqlSession session = this.getSqlSession()){
            List<SysUser> users = session.selectList("queryAll");
            System.out.println(users);
        }
    }

    @Test
    public void testQueryById3(){
        try(SqlSession session = this.getSqlSession()){
            SysUserDao userDao = session.getMapper(SysUserDao.class);
            SysUser user = userDao.queryById(1L);
            System.out.println(user);
        }
    }
}
