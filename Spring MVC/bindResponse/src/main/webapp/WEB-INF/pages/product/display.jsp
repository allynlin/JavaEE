<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>显示产品信息</title>
        <style>
            h1{
                text-align: center;
            }
            table {
                border: 1px solid gray;
                width: 80%;
                margin: 0px auto;
                border-collapse: collapse;
            }

            th, td {
                text-align: center;
                font-size: 16px;
                line-height: 30px;
                border: 1px solid gray;
            }
        </style>
    </head>
    <body>
        <h1>产品信息</h1>
        <p>请求用户：<span id="user"></span></p>
        <hr/>
        <table id="products">
            <tr>
                <th>编号</th>
                <th>商品名称</th>
                <th>产地</th>
            </tr>
        </table>
    </body>
 </html>
