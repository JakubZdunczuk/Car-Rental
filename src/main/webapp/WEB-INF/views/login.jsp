<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form method="post" modelAttribute="user">
    <div class="text-center">
        User Name:<form:input type="text" name="username" path="username"/>
        <p1 class="text-danger"><form:errors path="username"/></p1>

        Password:<form:input type="password" name="password" path="password"/>
        <p1 class="text-danger"><form:errors path="password"/></p1>
    </div>
    <br>
    <c:if test="${param.error!=null}">
        <div class="text-center">
            Nazwa użytkownika lub hasło jest nieprawidłowe. Spróbuj ponownie
        </div>
    </c:if>
    <div class="text-center"><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
<div class="text-center">nie masz jeszcze konta? <a href="/register"> zarejestruj się!</a></div>

<%@ include file="fragments/footer.jsp" %>
