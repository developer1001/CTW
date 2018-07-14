<%@ page import="javax.naming.Context" %><%--
  Created by IntelliJ IDEA.
  User: StephenChow
  Date: 2018/7/12
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
</head>
<script src="../static/js/jQuery-2.2.0.min.js"></script>
<script>

</script>
<body>
<form action="../User_addUser.do" method="post">
    <input type="text" name="baseEntity.userName" placeholder="userName"><br>
    <input type="text" name="baseEntity.loginName" id="" placeholder="loginName"><br>
    <input type="password" placeholder="password" name="baseEntity.password"><br>
    <input type="button" onclick="document.forms[0].submit()" value="提交表单">
</form>
</body>
</html>
