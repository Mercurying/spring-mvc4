<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>servlet async support</title>
</head>
<body>

<script src="assets/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

    deferred();

    function deferred() {
        $.get('defer', function (data) {
            console.log("deferred result:", data);
            deferred(); // 循环请求后台接口
        })
    }
</script>
</body>
</html>

