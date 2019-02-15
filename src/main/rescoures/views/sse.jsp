<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>SSE page</title>
</head>
<body>
<div id="msgFromPush"></div>
<script src="assets/js/jquery.min.js" type="text/javascript"></script>
<script>
    if (!!window.EventSource) {
        var source = new EventSource("push");
        var s = "";
        source.addEventListener('message', function (e) {  // 添加SSE客户端监听 获取服务端数据
            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open', function (e) {
            console.log("连接打开.")
        }, false);

        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSE) {
                console.log("连接关闭.");
            } else {
                console.log(e.readyState);
            }
        }, false);
    } else {
        console.log("您的浏览器不支持SSE!");
    }

</script>
</body>
</html>

