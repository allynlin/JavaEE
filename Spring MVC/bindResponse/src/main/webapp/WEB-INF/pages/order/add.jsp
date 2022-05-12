<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>生成订单信息</title>
        <style>
            h1{
                text-align: center;
            }
            table{
                border: 1px solid gray;
                border-collapse: collapse;
                margin: 10px 0px;
            }
            th,td{
                border: 1px solid gray;
                line-height: 30px;
                text-align: center;
                min-width: 50px;
            }
            input[type="text"]{
                background-color: #e9e9e9;
                padding: 5px 3px;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1>生成订单信息</h1>
        <hr/>
        <form>
            订单Id:<input type="text" name="orderId" placeholder="输入订单Id"/>
            <table>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                </tr>
                <tr>
                    <td><input type="text" placeholder="输入海鲜编号"/></td>
                    <td><input type="text"  placeholder="输入海鲜名称"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="输入酒水编号"/></td>
                    <td><input type="text" placeholder="输入酒水名称"/></td>
                </tr>
            </table>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>
