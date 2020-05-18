<%--
  Created by IntelliJ IDEA.
  User: 夕汐
  Date: 2020/5/18
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CC Test</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $(function () {
        $("#btn_0").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/bringUpTopic",
                data:{
                    'userId':1,
                    'topicName':'网球'
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })
    })
</script>
<body>
<H1>Topic模块</H1>
<input type="button" id="btn_0" value="新建话题">
</body>
<script>
</script>
</html>
