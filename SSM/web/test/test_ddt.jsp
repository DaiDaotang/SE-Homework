<%--
  Created by IntelliJ IDEA.
  User: 夕汐
  Date: 2020/5/18
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DDT Test</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            location.href="${pageContext.request.contextPath}/test/modifyHead.jsp";
        })
    });
</script>
<input type="button" id="btn" value="测试">
</body>
</html>
