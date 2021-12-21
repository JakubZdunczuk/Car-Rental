<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="fragments/header.jsp" %>

<h1>Rejestracja nowego użytkownika:</h1>
<form:form method="post" modelAttribute="user">
    <div>nazwa użytkownika:</div><form:input type="text" path="username"/>
    <div>hasło:</div><form:input type="password" path="password"/>
    <div>powtórz hasło:</div><form:input type="password" path="passwordConfirm"/>

    <div><input type="submit" value="Zatwierdź"></div>
</form:form>

<%@ include file="fragments/footer.jsp" %>