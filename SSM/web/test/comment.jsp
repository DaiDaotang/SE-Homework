<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $.post({
        url:"${pageContext.request.contextPath}/comment/comment",
        data:{
            'commenterId':'6',
            'answerId':'1',
            'commentContent':'说到底'
        },
        success:function (data) {
            console.log(data);
        }
    })
</script>
</body>
</html>