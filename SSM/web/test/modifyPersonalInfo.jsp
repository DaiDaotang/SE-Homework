<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $.post({
        url:"${pageContext.request.contextPath}/user/modifyPersonalInfo",
        data:{
            'userId':6,
            'name':'dd',
            'sex':'男',
            'birthday':'2000-03-12'
        },
        success:function (data) {
            console.log(data);
        }
    })
</script>
</body>
</html>