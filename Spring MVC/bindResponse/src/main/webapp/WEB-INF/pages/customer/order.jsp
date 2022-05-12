<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
    <link href="css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.6.0.js"></script>
    <meta content="light dark" name="color-scheme">
    <style>
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="${pageContext.request.contextPath}/findOrderwithUser" method="post" class="white-pink">
            <h1>客户订单</h1>
                <label>
                    <span>当前客户：</span>
                    <input type="text" placeholder="客户姓名" name="username"/>
                </label>
                <label>
                    <span>订单编号：</span>
                    <input type="text" placeholder="编号" name="order.orderId">
                </label>
                <label>
                    <span>订单总价：</span>
                    <input type="text" placeholder="总金额" name="price">
                </label>
                <label>
                    <input type="submit" value="查询" class="btn btn-block btn-success">
                </label>
            </form>
        </div>
    </div>
</div>
</form>
</body>
</html>
