<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $.post({
        url:"${pageContext.request.contextPath}/question/askQuestion",
        data:{
            "questionerId":5,
            "questionTitle":"耳朵",
            "questionContent":"我",
            "topicId":['14','15']
        },
        traditional: true,
        success:function (data) {
            console.log(data);
        }
    })
</script>
</body>
</html>