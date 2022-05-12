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
            <form class="white-pink" method="post" action="${pageContext.request.contextPath}/showOrders">
                <h1>编辑客户订单</h1>
                <label>
                    <span>当前客户：</span>
                    <input type="text" value="刘小" readonly name="username"/>
                </label>
                <table>
                    <tr>
                        <td>订单号</td>
                        <td>订单名称</td>
                        <td>配送地址</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" value="1" name="orders[0].orderId"/>
                        </td>
                        <td>
                            <input name="orders[0].orderName" value="Java基础教程" type="text">
                        </td>
                        <td>
                            <input type="text" name="address" value="北京海淀">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" value="2" name="orders[1].orderId"/>
                        </td>
                        <td>
                            <input name="orders[1].orderName" value="JavaWeb案例" type="text">
                        </td>
                        <td>
                            <input type="text" name="address" value="北京昌平">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" value="3" name="orders[2].orderId"/>
                        </td>
                        <td>
                            <input name="orders[2].orderName" value="SSM框架实战" type="text">
                        </td>
                        <td>
                            <input type="text" name="address" value="北京朝阳">
                        </td>
                    </tr>
                </table>
                <label>
                    <input type="submit" value="提交" class="btn btn-block btn-success"/>
                </label>
            </form>
        </div>
    </div>
</div>
</body>
</html>
