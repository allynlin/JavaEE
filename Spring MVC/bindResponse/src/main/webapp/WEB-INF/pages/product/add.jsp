<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加商品信息</title>
        <style>
            h1{
                text-align: center;
            }
            table{
                border: 1px solid gray;
                border-collapse: collapse;
            }
            th,td{
                border: 1px solid gray;
                line-height: 30px;
                text-align: center;
                min-width: 50px;
            }
            input[type="text"]{
                border:none;
                background-color: #e9e9e9;
                padding: 5px 3px;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1>添加商品信息</h1>
        <hr/>
        <form >
            <table>
                <tr>
                    <th>选择</th>
                    <th>商品名称</th>
                    <th>出版地点</th>
                </tr>
                <tr>
                    <td><input type="checkbox" name="proId" value="1"/></td>
                    <td><input type="text" name="proName" value="Java基础教程"/></td>
                    <td><input type="text" name="proAddress" value="北京"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="proId" value="2"/></td>
                    <td><input type="text" name="proName" value="Java web案例教程"/></td>
                    <td><input type="text" name="proAddress" value="上海"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="proId" value="3"/></td>
                    <td><input type="text" name="proName" value="SSM实践"/></td>
                    <td><input type="text" name="proAddress" value="长沙"/></td>
                </tr>
            </table>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>
