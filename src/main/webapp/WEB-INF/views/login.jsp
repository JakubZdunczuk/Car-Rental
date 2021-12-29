<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 20.12.2021
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<div class="text-center fw-bold">LOGOWANIE</div>
<br>
<form method="post">
    <div class="text-center">
        User Name:<input type="text" name="username"/>
        Password:<input type="password" name="password"/>
    </div>
    <br>
    <div class="text-center"><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<div class="text-center">nie masz jeszcze konta? <a href="/register"> zarejestruj się!</a></div>

<%@ include file="fragments/footer.jsp" %>
