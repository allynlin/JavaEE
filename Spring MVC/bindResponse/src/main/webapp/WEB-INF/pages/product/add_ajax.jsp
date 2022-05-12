<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>异步提交</title>
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
                padding: 5px 3px;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1>添加商品信息</h1>
        <hr/>
        <form>
            <table>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>产地</th>
                    <th>提交</th>
                </tr>
                <tr>
                    <td><input type="text" id="proId1" value="1"/></td>
                    <td><input type="text" id="proName1" value="三文鱼"/></td>
                    <td><input type="text" id="proAddress1" value="北海"/></td>
                    <td><input type="button" value="提交单个商品" onclick="submitProduct()"/></td>
                </tr>
                <tr>
                    <td><input type="text" name="proId" id="proId2" value="2"/></td>
                    <td><input type="text" name="proName" id="proName2" value="红牛"/></td>
                    <td><input type="text" name="proAddress" id="proAddress2" value="北海"/></td>
                    <td><input type="button" value="提交多个商品" onclick="submitProducts()"/></td>
                </tr>
            </table>
        </form>
    </body>
 </html>
