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
  <title>Sign Up</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
  $(function () {
    $("#btn").click(function () {
      $.post({
        url:"${pageContext.request.contextPath}/user/signUp",
        data:{
          'telephone':$("#telephone").val(),
          'password':$("#password").val(),
          'name':$("#name").val()
        },
        success:function (data) {
          console.log(data);
        }
      })
    })
  })
</script>
<label for="telephone">Telephone:</label><input id="telephone" type="text">
<label for="password">Password:</label><input type="password" id="password">
<label for="name">Username:</label><input type="text" id="name">
<input type="button" id="btn" value="Sign up">
</body>
</html>
