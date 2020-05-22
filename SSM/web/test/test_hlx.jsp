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
<%--话题--%>
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
                    'topicName':'乒'
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
                    'topicName':$("#btn_3_name").val(),
                    'start':$("#btn_3_start").val(),
                    'count':$("#btn_3_count").val()
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })
    })
</script>
<%--测试--%>
<script>
    function checkTopicName(){
        $.post({
            url:"${pageContext.request.contextPath}/topic/checkTopic",
            data:{
                'topicName':$("#topic_name").val()
            },
            success:function (data) {
                console.log(data)
                // 若存在这个话题
                if(data.msg === "Yes"){
                    $("#repeat").html("Repeat");
                }
                // 若不存在
                else{
                    $("#repeat").html("Not Repeat");
                }
                // 若存在推荐话题或重复话题
                if(data.topic != null){
                    $("#topic").html(data.topic.topicName);
                }
                else{
                    $("#topic").html("暂无推荐");
                }
            }
        })
    }
    $(function () {
        $("#new_topic").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/bringUpTopic",
                data:{
                    'userId':1,
                    'topicName':$("#topic_name").val()
                },
                success:function (data) {
                    console.log(data)
                    $("#answer").html(data.topicId);
                }
            })
        })
    })
</script>
<%--收藏夹--%>
<script>
    $(function () {
        $("#btn_f_0").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/newFavorites",
                data:{
                    "userId":5,
                    "favoritesName":$("#txt_f_0").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
    })

    $(function () {
        $("#btn_f_1").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/delete",
                data: {
                    "favoritesIds":[2, 3]
                },
                traditional: true,
                success: function (data) {
                    console.log(data);
                }
            })
        })
    })

    $(function () {
        $("#btn_f_2").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/updateFavoritesName",
                data: {
                    "favoritesId":6,
                    "favoritesName":$("#txt_f_2").val()
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
<body>

<h1>收藏夹</h1>
<input type="text" id="txt_f_0" placeholder="收藏夹名称">
<input type="button" id="btn_f_0" value="新建收藏夹">
<input type="button" id="btn_f_1" value="删除收藏夹">
<input type="text" id="txt_f_2" placeholder="收藏夹新名称">
<input type="button" id="btn_f_2" value="修改收藏夹名称">



<h1>测试</h1>
<div>
    <input type="text" id="topic_name" placeholder="新话题名称" onblur="checkTopicName()">
    <label id="repeat">1</label>
    <label id="topic">1</label>
</div>
<div>
    <input type="button" id="new_topic" value="确认建立">
    <label id="answer">1</label>
</div>


<H1>Topic模块</H1>
<input type="button" id="btn_0" value="新建话题">
<input type="button" id="btn_1" value="话题存在">
<input type="button" id="btn_2" value="ID查询">
<input type="text" id="btn_3_name" value="球">
<input type="text" id="btn_3_start" value="0">
<input type="text" id="btn_3_count" value="10">
<input type="button" id="btn_3" value="名称查询">

</body>
</html>
