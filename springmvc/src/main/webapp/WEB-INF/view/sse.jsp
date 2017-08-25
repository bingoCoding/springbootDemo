<%--
  Created by IntelliJ IDEA.
  User:
  Date: 17/8/21
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sse 远程服务发送事件</title>
</head>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(function () {
        alert($("#abc").html());
    });

    <%--EventSource 是sse的客户端--%>
    if(!!window.EventSource("push")){
        var source=new EventSource("push");
        var s="";
        source.addEventListener('message',function (e) {
            s+=e.data+"<br/>";
            $("#msgPush").html(s);
        });
        source.addEventListener('open',function (e) {
            console.log("连接打开");
        },false);

        source.addEventListener('error',function () {
            if(e.readyState==EventSource.CLOSED){
                console.info("连接关闭");
            }else{
                console.info("fail="+e.readyState);
            }
        },false);
    }else {
        console.log("你的浏览器不支持sse");
    }
</script>
<body>

<div id="msgPush">


</div>
<div id="abc">
    <h2>abc hhhh</h2>
</div>
</body>
</html>
