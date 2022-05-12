<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link href="css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.6.0.js"></script>
    <meta content="light dark" name="color-scheme">

    <style>
        h1 {
            text-align: center;
        }

        .white-pink input[type="text"], .white-pink input[type="password"], .white-pink input[type="file"], .white-pink input[type="date"], .white-pink select, .white-pink input[type="number"], .white-pink input[type="tel"], .white-pink textarea, .white-pink select, .white-pink input[type="email"], .white-pink input[type="url"], .white-pink input[type="search"], .white-pink input[type="time"], .white-pink input[type="datetime-local"], .white-pink input[type="month"], .white-pink input[type="week"] {
            width: 60%;
            padding: 3px 0 3px 5px;
            margin-top: 2px;
            margin-right: 6px;
            margin-bottom: 16px;
            border: 1px solid #e5e5e5;
            height: 25px;
            line-height: 15px;
            outline: 0;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="${pageContext.request.contextPath}/loginUser" class="col-md-12 white-pink">
                <h1>用户登录</h1>
                <label>
                    <span>用户名：</span>
                    <input type="text" placeholder="输入用户名" name="username"/>
                </label>
                <label>
                    <span>密码：</span>
                    <input type="password" placeholder="输入密码" name="password"/>
                </label>
                <label>
                    <input type="submit" value="登录" class="btn btn-block btn-success"/>
                </label>
            </form>
        </div>
    </div>
</div>
</body>
</html>
