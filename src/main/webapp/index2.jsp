<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/31
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.juxing.pojo.UserInfo,java.lang.*" %>
<html>
<head>
    <title>OAuth2.0网页授权</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0
        }

        table {
            border: 1px dashed #B9B9DD;
            font-size: 12pt
        }

        td {
            border: 1px dashed #B9B9DD;
            word-break: break-all;
            word-wrap: break-word;
        }
    </style>
</head>
<body>

<%
    // 获取由OAuthServlet中传入的参数
    UserInfo user = (UserInfo) request.getAttribute("snsUserInfo");
    String state = request.getAttribute("state").toString();
    if (null != user) {
%>
<table width="100%" cellspacing="0" cellpadding="0">
    <tr>
        <td width="20%">属性</td>
        <td width="80%">值</td>
    </tr>
    <tr>
        <td>OpenID</td>
        <td><%=user.getOpenid()%>
        </td>
    </tr>
    <tr>
        <td>昵称</td>
        <td><%=user.getNickname()%>
        </td>
    </tr>
    <tr>
        <td>性别</td>
        <td><%=user.getSex()%>
        </td>
    </tr>
    <tr>
        <td>国家</td>
        <td><%=user.getCountry()%>
        </td>
    </tr>
    <tr>
        <td>省份</td>
        <td><%=user.getProvince()%>
        </td>
    </tr>
    <tr>
        <td>城市</td>
        <td><%=user.getCity()%>
        </td>
    </tr>
    <tr>
        <td>头像</td>
        <td><%=user.getHeadimgurl()%>
        </td>
    </tr>
    <tr>
        <td>特权</td>
        <%--<td><%=user.getPrivilegeList()%>--%>
        </td>
    </tr>
    <tr>
        <td>state:</td>
        <td><%=state%>
        </td>
    </tr>
</table>
<%
    } else

%>


</body>
</html>
