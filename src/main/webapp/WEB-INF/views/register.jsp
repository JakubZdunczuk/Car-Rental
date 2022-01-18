<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="fragments/header.jsp" %>

<h1>Rejestracja nowego użytkownika:</h1>
<form:form method="post" modelAttribute="user">

    <div>nazwa użytkownika:</div>
    <form:input type="text" path="username" size="20"/>
    <p1 class="text-danger"><form:errors path="username"/></p1>
    <div>hasło:</div>
    <form:input type="password" path="password"/>
    <p1 class="text-danger"><form:errors path="password"/></p1>
    <div>powtórz hasło:</div>
    <form:input type="password" path="passwordConfirm"/>
    <p1 class="text-danger"><form:errors path="passwordConfirm"/></p1>
    <div>email:</div>
    <form:input type="email" path="email"/>
    <p1 class="text-danger"><form:errors path="email"/></p1>
    <div><input type="submit" value="Zatwierdź"></div>
</form:form>

<%@ include file="fragments/footer.jsp" %>