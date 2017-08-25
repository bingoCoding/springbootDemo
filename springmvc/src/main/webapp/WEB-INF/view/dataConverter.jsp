<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    function conVerter() {
        $.ajax({
            url:"/converter",
            data:"abc-cba",
            type:"post",
            contentType:"application/abc",
            success:function (data) {
                alert(data);
            }

        });
    }
</script>
<body>
<h2>welcome to helloworld</h2>

<input type="button" onclick="conVerter()" value="数据转换" ／>


</body>
</html>