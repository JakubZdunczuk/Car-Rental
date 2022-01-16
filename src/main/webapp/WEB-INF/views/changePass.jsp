<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="fragments/header.jsp" %>

<h1>Zmiana hasła:</h1>
<form:form method="post" modelAttribute="user">
    <div>obecne hasło:</div><form:input type="password" path="password"/><p1 class="text-danger"><form:errors path="password"/></p1>
    <div>nowe hasło:</div><form:input type="password" path="newPassword"/><p1 class="text-danger"><form:errors path="newPassword"/></p1>
    <div>powtórz nowe hasło:</div><form:input type="password" path="passwordConfirm"/><p1 class="text-danger"><form:errors path="passwordConfirm"/></p1>

    <div><input type="submit" value="Zatwierdź"></div>
</form:form>

<%@ include file="fragments/footer.jsp" %>