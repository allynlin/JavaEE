<%--
  Created by IntelliJ IDEA.
  User: Allyn
  Date: 2022/5/25
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/white-pink.css" rel="stylesheet" type="text/css">
    <meta content="light dark" name="color-scheme">
    <title>显示产品信息</title>
    <style>
        h1 {
            text-align: center;
        }

        th, td {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 white-pink">
            <h1>检索图书信息</h1>
            <label>
                <span>图书名称：</span>
                <input type="text" name="bookName" id="bookName">
            </label>
            <label>
                <button id="ok" type="button" value="查询" class="btn btn-default btn-block">查询</button>
            </label>
        </div>
        <div class="col-md-6 table-responsive" id="tab">
            <table class="table table-striped table-hover" id="products">
            </table>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<script>
    $(
        $("#ok").click(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/findBooksByName",
                type: "post",
                data: {
                    bookName: $("#bookName").val()
                },
                dataType: "json",
                success: function (data) {
                    // 先清空表格
                    $("#tab").empty();
                    // 添加CSS样式white-pink
                    $("#tab").addClass("white-pink");
                    // 创建表格
                    let str='<table class="table table-striped table-hover" id="products">';
                    // 再添加表头
                    str+='<thead><tr><th>图书编号</th><th>图书名称</th><th>图书作者</th><th>图书出版社</th><th>图书价格</th><th>出版时间</th></tr></thead>';
                    // 再添加表格内容
                    str+='<tbody>';
                    for (var i = 0; i < data.length; i++) {
                        str = str + "<tr>";
                        str = str + "<td>" + data[i].bookId + "</td>";
                        str = str + "<td>" + data[i].bookName + "</td>";
                        str = str + "<td>" + data[i].bookAuthor + "</td>";
                        str = str + "<td>" + data[i].bookPress + "</td>";
                        str = str + "<td>" + data[i].bookPrice + "</td>";
                        str = str + "<td>" + data[i].bookDate + "</td>";
                        str = str + "</tr>";
                    }
                    str+='</tbody>';
                    str+='</table>';
                    $("#tab").append(str);
                    $("#tab").trigger("create");
                }
            })
        })
    )
</script>
</html>
