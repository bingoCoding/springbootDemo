<%--
  Created by IntelliJ IDEA.
  User:
  Date: 17/8/11
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div class="upload">
        <form action="/upload" enctype="multipart/form-data" method="post">
            <input name="file" type="file"/>
            <input type="submit" value="上传">
        </form>
    </div>
</body>
</html>
