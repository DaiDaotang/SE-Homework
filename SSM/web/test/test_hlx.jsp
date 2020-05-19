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
                    'topicName':'球'
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })

        $("#btn_1").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/checkTopic",
                data:{
                    'topicName':'网'
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })

        $("#btn_2").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/queryTopicById",
                data:{
                    'topicId':3
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })

        $("#btn_3").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/queryTopicByName",
                data:{
                    'topicName':'球',
                    'start':1,
                    'count':3
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
<input type="button" id="btn_1" value="话题存在">
<input type="button" id="btn_2" value="ID查询">
<input type="button" id="btn_3" value="名称查询">
</body>
<script>
</script>
</html>
