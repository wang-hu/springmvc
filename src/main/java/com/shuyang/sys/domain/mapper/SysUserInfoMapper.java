package com.shuyang.sys.domain.mapper;

import com.shuyang.sys.component.pojo.UserAuth;
import com.shuyang.sys.domain.SysUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(Integer id);

    SysUserInfo getSysUserInfoByUserNameAndPassword(@Param("loginName") String loginName, @Param("password")String password);

    SysUserInfo getSysUserInfoByUserName(String loginName);

    List<UserAuth> listUserAuthorities(String loginName);


    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);
}