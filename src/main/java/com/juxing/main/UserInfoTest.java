package com.juxing.main;

import com.juxing.common.util.CommonUtil;
import com.juxing.pojo.App;
import com.juxing.pojo.WeixinUserInfo;

import static com.juxing.common.util.CommonUtil.getUserInfo;

/**
 * @Auther: Mr.Liu
 * @Date: 2018/10/31 09
 * @Description: 输入用户openID可以得到用户的信息
 */
public class UserInfoTest {

    public static void main(String[] args) {

        // 获取接口访问凭证
        String accessToken = CommonUtil.getToken(App.APPID, App.APPSECRET).getAccessToken();
        /**
         * 获取用户信息
         * 用户的openID，在
         */
        WeixinUserInfo user = getUserInfo(accessToken, "o9zJA1UB0YnKD94A0ZqasywW8MX0");
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
    }


}


