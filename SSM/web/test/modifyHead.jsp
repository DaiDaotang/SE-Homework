<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/modifyHead"
      method="post" enctype="multipart/form-data">
    <input type="file" name="head"/>
    <input type="submit" value="提交"/>
</form>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</body>
</html>