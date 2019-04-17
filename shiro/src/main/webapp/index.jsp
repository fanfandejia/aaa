<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
您好：
<shiro:authenticated>
  <shiro:principal/>
</shiro:authenticated>
<shiro:notAuthenticated>
    您还未<a href="login.jsp">登录</a>,登录之后可以浏览更多内容
</shiro:notAuthenticated>
<br/>
--------------------------------------------------------------------------
<br/>

</body>
</html>
