<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        h1{
            text-align: center;
        }
        input{
            margin: 5px;
        }
    </style>
</head>
<body>
    <h1>用户登录</h1>
    <hr/>
    <form action="<%=request.getContextPath()%>/user/index">
        用户名：<input type="text" placeholder="输入用户名"/><br/>
        密码：<input type="password" placeholder="输入密码"/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
