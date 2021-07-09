<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
    <h2>Hello World!</h2>
        <a href="${pageContext.request.contextPath}/WEB-INF/jsp/msg.jsp">跳转</a>
        <form action="${pageContext.request.contextPath}/start" method="get">
            <input type="submit">
        </form>
    </body>
</html>
