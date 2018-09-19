<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2018/7/24
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/base.jsp" %>
<html>
<head>
    <table style="width:364px;height: 280px;"  border="1" cellspacing="0">
        <thead>
        <tr>
            <td></td>
            <td align="center">服务项目</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="c" varStatus="status">
            <tr>
                <td align="center"><img src="<%=path%>/img/2842.png"></td>
                <td align="center">${c.served_items}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</head>
<body>
</body>
</html>
