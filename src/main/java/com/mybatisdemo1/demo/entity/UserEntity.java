package com.mybatisdemo1.demo.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author: zhanghaiyang on 2019/2/11 14:29
 * @E-Mail: zhanghaiyang@126.com
 * @Function:
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

    public String id;
    public String headUrl;
    public String userName;
    public String nickName;
    public String phone;
    public String signature;
    public String weChatOpenId;
    public String qqOpenId;
    public String createTime;
    public Long createDate;

}
