<%@ page isELIgnored="false" %>
<%@ taglib prefix="fss" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="kbr" uri="/WEB-INF/core.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>线下服务demo</title>
    <
</head>
<body>
<!-- HEADER -->
<header id="header" style="background: #17BC84">
</header>
<c:forEach items="${list}" var="d">
    ${d.projectName}
</c:forEach>
<a href="<%=path%>/demo/findAll">链接</a>
</body>
</html>