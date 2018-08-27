package com.etc.dao;

import com.etc.entity.SysUser;

import java.util.List;

public interface SysUserDao {
    SysUser queryById(Long id);

    List<SysUser> queryAll();

    List<SysUser> queryAll2();
}
