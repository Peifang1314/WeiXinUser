package com.juxing.controller;

import com.juxing.common.util.AdvancedUtil;
import com.juxing.common.util.SignUtil;
import com.juxing.pojo.App;
import com.juxing.pojo.UserInfo;
import com.juxing.pojo.WeixinOauth2Token;
import com.juxing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Mr.Liu
 * @Date: 2018/10/30 17
 * @Description:
 */


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 确认消息来自微信服务器
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/check")
    public String check(HttpServletRequest request) {

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.print("echostr=" + echostr);
            return echostr;
        } else {
            return "fail";
        }
    }


    @RequestMapping("/oauthServlet")
    public void OAuthServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("servlet开始");
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("servlet2");

        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(App.APPID, App.APPSECRET, code);
            // 网页授权接口访问凭证
            System.out.println("weixinOauth2Token:----" + weixinOauth2Token);
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            UserInfo userInfo = AdvancedUtil.getUserInfo(accessToken, openId);
            System.out.println("userInfo:----" + userInfo);

            //将用户存储到数据库

         userService.userSave(userInfo);

            // 设置要传递的参数
            request.setAttribute("snsUserInfo", userInfo);
            request.setAttribute("state", state);



            // 跳转到index.jsp
            request.getRequestDispatcher("index2.jsp").forward(request, response);
        }


    }

}
