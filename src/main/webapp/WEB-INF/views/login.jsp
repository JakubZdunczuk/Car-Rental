<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 20.12.2021
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<form method="post">
    <div class="text-center">User Name:<input type="text" name="username"/> </div>
    <div class="text-center">Password: <input type="password" name="password"/></div>
    <div class="text-center"><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<%@ include file="fragments/footer.jsp" %>
