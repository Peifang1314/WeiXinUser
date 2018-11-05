package com.juxing.service.impl;

import com.juxing.common.vo.Resp;
import com.juxing.mapper.UserInfoMapper;
import com.juxing.pojo.UserInfo;
import com.juxing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Mr.Liu
 * @Date: 2018/10/31 16
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper mapper;

    @Override
    public Resp userSave(UserInfo userInfo) {
        System.out.println("result:"+mapper.insert(userInfo));
        return Resp.ok();
    }
}
