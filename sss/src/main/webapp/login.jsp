<%@page pageEncoding="UTF-8" %>
<html>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/login">
    账户：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="登陆">
</form>
</body>
</html>
