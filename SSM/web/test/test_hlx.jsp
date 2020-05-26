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
<script src="js/utils.js"></script>
<%--话题--%>
<script>
    $(function () {
        // 新建话题
        $("#btn_0").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/bringUpTopic",
                data:{
                    'userId':5,
                    'topicName':$("#txt_t_0").val()
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })
        // 检测是否已存在同名话题
        $("#btn_1").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/checkTopic",
                data:{
                    'topicName':$("#txt_t_1").val()
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })
        // 获取话题 by topicId
        $("#btn_2").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/queryTopicById",
                data:{
                    'topicId':$("#txt_t_2").val()
                },
                success:function (data) {
                    console.log(data)
                }
            })
        })
        // 获取话题 by topicName（模糊）
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
        // 获取话题下的问题
        $("#btn_4").click(function () {
            $.post({
                url:"${pageContext.request.contextPath}/topic/queryQuestions",
                data:{
                    'topicId':$("#txt_t_3").val(),
                    'extra':$("#txt_t_4").val(),
                    'start':$("#txt_t_5").val(),
                    'count':$("#txt_t_6").val()
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
        // 新建收藏夹
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
        // 删除收藏夹
        $("#btn_f_1").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/delete",
                data: {
                    "favoritesIds":[7, 8]
                },
                traditional: true,
                success: function (data) {
                    console.log(data);
                }
            })
        })
        // 修改收藏夹名称
        $("#btn_f_2").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/updateFavoritesName",
                data: {
                    "favoritesId":$("#txt_f_1").val(),
                    "favoritesName":$("#txt_f_2").val()
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
        // 获取收藏夹列表 by userId
        $("#btn_f_4").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/getFavoritesByUserId",
                data: {
                    "userId":5,
                    "start":$("#txt_f_7").val(),
                    "count":$("#txt_f_8").val()
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
        // 收藏回答/取消收藏回答
        $("#btn_f_5").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/toFavour",
                data: {
                    "answerId":$("#txt_f_3").val(),
                    "answererId": 5,
                    "favoritesId":$("#txt_f_4").val(),
                    "type":true
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
        // 清空收藏夹内容
        $("#btn_f_6").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/emptyFavorites",
                data: {
                    "favoritesId":$("#txt_f_5").val()
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
        // 获取收藏该回答的收藏夹ID列表
        $("#btn_f_7").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/getHostFavoritesId",
                data: {
                    "userId":5,
                    "answerId":$("#txt_f_6").val()
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
        // 获取收藏夹内的回答
        $("#btn_f_8").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/favorites/getFavoritesContents",
                data: {
                    "favoritesId":$("#txt_f_9").val(),
                    "start":0,
                    "count":10
                },
                success: function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
<%--关注--%>
<script>
    $(function () {
        $("#btn_follow_0").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/follow/follow",
                data:{
                    "fanId":5,
                    "userId": $("#txt_follow_0").val(),
                    "type":false
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })

        $("#btn_follow_2").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/follow/getList",
                data:{
                    "userId": 5,
                    "start":0,
                    "count":10,
                    "type":$("#txt_follow_1").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })

        $("#btn_follow_3").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/follow/checkRelation",
                data:{
                    "userId": 5,
                    "targetUserId":$("#txt_follow_2").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
<%--点赞--%>
<script>

</script>
<body>

<h1>以下操作，均为5号用户所为</h1>


<h1>点赞</h1>


<h1>关注</h1>
<div>
    <input type="text" id="txt_follow_0" placeholder="用户ID">
    <input type="button" id="btn_follow_0" value="关注/取消关注"><br>
    <input type="text" id="txt_follow_1" placeholder="0关注1粉丝">
    <input type="button" id="btn_follow_2" value="关注/粉丝列表"><br>
    <input type="text" id="txt_follow_2" placeholder="目标用户ID">
    <input type="button" id="btn_follow_3" value="检查是否关注"><br>
</div>

<h1>收藏夹</h1>
<div>
    <input type="text" id="txt_f_0" placeholder="收藏夹名称">
    <input type="button" id="btn_f_0" value="新建收藏夹"><br>
    <input type="button" id="btn_f_1" value="删除收藏夹"><br>
    <input type="text" id="txt_f_1" placeholder="收藏夹原ID">
    <input type="text" id="txt_f_2" placeholder="收藏夹新名称">
    <input type="button" id="btn_f_2" value="修改收藏夹名称"><br>
    <input type="text" id="txt_f_7" placeholder="start" value="0">
    <input type="text" id="txt_f_8" placeholder="count" value="10">
    <input type="button" id="btn_f_4" value="通过用户ID获取收藏夹"><br>
    <input type="text" id="txt_f_3" placeholder="回答的ID">
    <input type="text" id="txt_f_4" placeholder="收藏夹的ID">
    <input type="button" id="btn_f_5" value="收藏/取消收藏回答"><br>
    <input type="text" id="txt_f_5" placeholder="收藏夹的ID">
    <input type="button" id="btn_f_6" value="清空收藏夹"><br>
    <input type="text" id="txt_f_6" placeholder="问题的ID">
    <input type="button" id="btn_f_7" value="获取被哪些收藏夹收藏"><br>
    <input type="text" id="txt_f_9" placeholder="favoritesId" value="9">
    <input type="button" id="btn_f_8" value="获取收藏夹收藏的回答"><br>
</div>


<h1>测试</h1>
<div>
    <div>
        <input type="text" id="topic_name" placeholder="新话题名称" onblur="checkTopicName()">
        <label id="repeat">1</label>
        <label id="topic">1</label>
    </div>
    <div>
        <input type="button" id="new_topic" value="确认建立">
        <label id="answer">1</label>
    </div>
</div>


<H1>Topic模块</H1>
<div>
    <input type="text" id="txt_t_0" placeholder="新话题名称">
    <input type="button" id="btn_0" value="新建话题"><br>
    <input type="text" id="txt_t_1" placeholder="话题名称">
    <input type="button" id="btn_1" value="话题存在"><br>
    <input type="text" id="txt_t_2" placeholder="话题名称">
    <input type="button" id="btn_2" value="ID查询"><br>
    <input type="text" id="btn_3_name" value="球">
    <input type="text" id="btn_3_start" value="0">
    <input type="text" id="btn_3_count" value="10">
    <input type="button" id="btn_3" value="名称查询"><br>
    <input type="text" id="txt_t_3" value="14">
    <input type="text" id="txt_t_4" value="1">
    <input type="text" id="txt_t_5" value="0">
    <input type="text" id="txt_t_6" value="10">
    <input type="button" id="btn_4" value="查询问题">
</div>

</body>
</html>
