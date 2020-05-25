<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $.post({
        url:"${pageContext.request.contextPath}/comment/responseComment",
        data:{
            'commenterId':'6',
            'answerId':'1',
            'commentContent':'文法单位清耳朵',
            'commentedId':'2'
        },
        success:function (data) {
            console.log(data);
        }
    })
</script>
</body>
</html>