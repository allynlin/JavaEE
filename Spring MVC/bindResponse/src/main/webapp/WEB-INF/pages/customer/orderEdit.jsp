<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
    <style>
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>编辑客户订单</h1>
    <hr/>
    <form>
        当前客户：<input type="text" value="刘小" readonly/><br/>
        <table>
            <tr>
                <th>订单编号</th>
                <th>订单总价</th>
                <th>发货地址</th>
            </tr>
            <tr>
                <td><input type="text" value="001"></td>
                <td><input type="text" value="205.8"></td>
                <td><input type="text" value="湖南长沙"></td>
            </tr>
            <tr>
                <td><input type="text" value="002"></td>
                <td><input type="text" value="89.8"></td>
                <td><input type="text" value="北京"></td>
            </tr>
            <tr>
                <td><input type="text" value="003"></td>
                <td><input type="text" value="2009"></td>
                <td><input type="text" value="广东广州"></td>
            </tr>
        </table>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
