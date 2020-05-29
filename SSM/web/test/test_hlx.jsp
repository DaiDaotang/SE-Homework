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
                    'count':$("#txt_t_6").val(),
                    'n':100
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
                    "favoritesIds":[9, 10]
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
                    "count":10,
                    "n": 100
                },
                success: function (data) {
                    console.log(data);
                    console.log(data.list[0].answerContent)
                    data.get("list")
                }
            })
        })
    })
</script>
<%--关注--%>
<script>
    $(function () {
        // 关注/取消关注
        $("#btn_follow_0").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/follow/follow",
                data:{
                    "fanId":5,
                    "userId": $("#txt_follow_0").val(),
                    "type":true
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 关注/粉丝列表
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
        // 检查是否检查
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
    $(function () {
        // 点赞/取消点赞回答
        $("#btn_like_0").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/like/answer",
                data:{
                    "userId":5,
                    "answerId": $("#txt_like_0").val(),
                    "type":true
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 查询是否点赞回答
        $("#btn_like_1").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/like/likedAnswer",
                data:{
                    "userId": 5,
                    "answerId": $("#txt_like_0").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 点赞/取消点赞评论
        $("#btn_like_2").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/like/comment",
                data:{
                    "userId":5,
                    "commentId": $("#txt_like_1").val(),
                    "type":true
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 查询是否点赞评论
        $("#btn_like_3").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/like/likedCommentd",
                data:{
                    "userId":5,
                    "commentId": $("#txt_like_1").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
<%--搜索--%>
<script>
    $(function () {
        // 搜索问题
        $("#btn_s_0").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/search/questions",
                data:{
                    "keyword": $("#txt_s_0").val(),
                    "extra": $("#txt_s_1").val(),
                    "start":$("#txt_s_3").val(),
                    "count":$("#txt_s_4").val(),
                    "n":100
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 搜索话题
        $("#btn_s_1").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/search/topics",
                data:{
                    "keyword": $("#txt_s_0").val(),
                    "extra": $("#txt_s_1").val(),
                    "start":$("#txt_s_3").val(),
                    "count":$("#txt_s_4").val(),
                    "n":0
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 搜索用户
        $("#btn_s_2").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/search/users",
                data:{
                    "keyword": $("#txt_s_0").val(),
                    "extra": $("#txt_s_1").val(),
                    "start":$("#txt_s_3").val(),
                    "count":$("#txt_s_4").val(),
                    "n":0
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 搜索
        $("#btn_s_3").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/search/search",
                data:{
                    "keyword": $("#txt_s_0").val(),
                    "type": $("#txt_s_2").val(),
                    "extra": $("#txt_s_1").val(),
                    "start":$("#txt_s_3").val(),
                    "count":$("#txt_s_4").val(),
                    "n":100
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
<%--回答--%>
<script>
    $(function () {
        // 新建回答
        $("#btn_a_0").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/answer/new",
                data:{
                    "userId": 5,
                    "questionId": 1,
                    "answerContent":$("#txt_a_0").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })
        // 修改回答
        $("#btn_a_1").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/answer/modify",
                data:{
                    "answerId": $("#txt_a_1").val(),
                    "answerContent":$("#txt_a_2").val()
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })

        // 删除回答
        $("#btn_a_2").click(function () {
            <%--$.post({--%>
            <%--    url : "${pageContext.request.contextPath}/answer/delete",--%>
            <%--    data:{--%>
            <%--        "answerId": $("#txt_a_4").val()--%>
            <%--    },--%>
            <%--    success:function (data) {--%>
            <%--        console.log(data);--%>
            <%--        console.log(timestampToTime(data.answerTime))--%>
            <%--    }--%>
            <%--})--%>
        })

        // 获取回答 by answerId
        $("#btn_a_3").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/answer/getAnswerByAnswerId",
                data:{
                    "answerId": $("#txt_a_4").val()
                },
                success:function (data) {
                    console.log(data);
                    console.log(timestampToTime(data.answerTime))
                }
            })
        })

        // 获取回答列表 by userId
        $("#btn_a_4").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/answer/getAnswersListByUserId",
                data:{
                    "userId": $("#txt_a_5").val(),
                    "extra":$("#txt_a_5_0").val(),
                    "start":0,
                    "count":100,
                    "n":100
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })

        // 获取回答列表 by questionId
        $("#btn_a_5").click(function () {
            $.post({
                url : "${pageContext.request.contextPath}/answer/getAnswersListByQuestionId",
                data:{
                    "questionId": $("#txt_a_6").val(),
                    "extra":$("#txt_a_6_0").val(),
                    "start":0,
                    "count":100,
                    "n":100
                },
                success:function (data) {
                    console.log(data);
                }
            })
        })

    })
</script>
<body>

<h1>以下操作，均为5号用户所为</h1>


<h1>回答</h1>
<div>
    <input type="text" id="txt_a_0" placeholder="回答" value="Just an answer!">
    <input type="button" id="btn_a_0" value="创建回答"><br>
    <input type="text" id="txt_a_1" placeholder="回答ID" value="6">
    <input type="text" id="txt_a_2" placeholder="新内容" value="Just an answer!">
    <input type="button" id="btn_a_1" value="修改回答"><br>
    <input type="text" id="txt_a_3" placeholder="回答ID" value="1">
    <input type="button" id="btn_a_2" value="删除回答"><br>
    <input type="text" id="txt_a_4" placeholder="回答ID" value="1">
    <input type="button" id="btn_a_3" value="获取回答"><br>
    <input type="text" id="txt_a_5" placeholder="用户ID" value="5">
    <input type="text" id="txt_a_5_0" placeholder="排序方法" value="5">
    <input type="button" id="btn_a_4" value="获取回答"><br>
    <input type="text" id="txt_a_6" placeholder="问题ID" value="1">
    <input type="text" id="txt_a_6_0" placeholder="排序方法" value="1">
    <input type="button" id="btn_a_5" value="获取回答"><br>
</div>


<h1>搜索</h1>
<div>
    <input type="text" id="txt_s_0" placeholder="关键字">
    <input type="text" id="txt_s_1" placeholder="排序方法" value="0">
    <input type="text" id="txt_s_2" placeholder="搜索类型" value="0">
    <input type="text" id="txt_s_3" placeholder="开始" value="0">
    <input type="text" id="txt_s_4" placeholder="数量" value="4">
    <input type="button" id="btn_s_0" value="搜索问题">
    <input type="button" id="btn_s_1" value="搜索话题">
    <input type="button" id="btn_s_2" value="搜索用户">
    <input type="button" id="btn_s_3" value="搜索">
</div>


<h1>点赞</h1>
<div>
    <input type="text" id="txt_like_0" placeholder="回答ID">
    <input type="button" id="btn_like_0" value="点赞"><br>
    <input type="button" id="btn_like_1" value="查询点赞"><br>
    <input type="text" id="txt_like_1" placeholder="评论ID">
    <input type="button" id="btn_like_2" value="点赞"><br>
    <input type="button" id="btn_like_3" value="查询点赞"><br>
</div>


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
