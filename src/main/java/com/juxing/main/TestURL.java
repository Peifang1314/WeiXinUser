package com.juxing.main;

import com.juxing.common.util.CommonUtil;

/**
 * @Auther: Mr.Liu
 * @Date: 2018/10/31 11
 * @Description:
 */
public class TestURL {

    public static void main(String[] args) {
        String source="http://peifang1314.uicp.top/oauthServlet";
        System.out.println(CommonUtil.urlEncodeUTF8(source));
    }


}
