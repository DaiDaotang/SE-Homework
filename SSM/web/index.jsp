<%--
  Created by IntelliJ IDEA.
  User: 夕汐
  Date: 2020/5/13
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
  $(function () {
    $("#btn").click(function () {
      location.href="${pageContext.request.contextPath}/test/logIn.jsp";
    })

    $("#btn_test_ddt").click(function () {
      location.href="test/test_ddt.jsp";
    })

    $("#btn_test_hlx").click(function () {
      location.href="test/test_hlx.jsp";
    })
  });
</script>
<input type="button" id="btn" value="Sign up">
<input type="button" id="btn_test_ddt" value="DDT测试页面">
<input type="button" id="btn_test_hlx" value="CC测试页面">
</body>
</html>
