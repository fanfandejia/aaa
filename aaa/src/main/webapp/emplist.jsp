<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>emplist</title>
    <%request.setAttribute("date", new java.util.Date()); %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd"/>
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                欢迎 ${sessionScope.admin.name} 来到本网站!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <th>
                        Chooses
                    </th>
                    <th>
                        ID
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        Salary
                    </th>
                    <th>
                        Age
                    </th>
                    <th>
                        Operation
                    </th>
                </tr>
                <c:forEach items="${sessionScope.list}" var="emp">
                    <tr class="row1">
                        <td>
                            <input type='checkbox' name='ids' value="${emp.id}"/>
                        </td>
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.age}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/emp/removeEmp?id=${emp.id}">删除</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/updateEmp.jsp?id=${emp.id}&name=${emp.name}&salary=${emp.salary}&age=${emp.age}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                <input type='submit' value='删除勾选项'/>
                </form>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
                /<a href="${pageContext.request.contextPath}/admin/exit">退出</a>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>

