package com.mybatisdemo1.demo.service;


import com.mybatisdemo1.demo.entity.UserEntity;
import com.mybatisdemo1.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZHY on 2019/2/11 16:04
 * @E-Mail: AriesHoo@126.com
 * @Function:
 * @Description:
 */
//@Repository
@Service
public class UserService {
    @Autowired
    private UserMapper mMapper;

    public UserEntity findUser(String account, String password, String openId) {
        return mMapper.findUser(account, password,openId);
    }

    public UserEntity findUserById(String account) {
        return mMapper.findUserById(account);
    }

    public List<UserEntity> getUserList() {
        return mMapper.getUserList();
    }

    public void register(String id, String account, String password, String headUrl, String weChatId, String qqId) {
        mMapper.register(id, account, password, headUrl, weChatId, qqId);
    }

    public void updateUserInfo(String id, String nickName, String headUrl, String password, String phone,
                               String weChatId, String qqId, String signature, Date loginTime) {
        mMapper.updateUserInfo(id, nickName, headUrl, password, phone, weChatId, qqId, signature, loginTime);
    }
}
