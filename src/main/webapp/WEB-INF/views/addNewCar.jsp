<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="fragments/header.jsp" %>
<h1>Wprowadzenie nowego samochodu do bazy:</h1>

<form:form method="post" modelAttribute="car">
    <div>marka:</div>
    <form:select path="model.brand">
    <c:choose>
    <c:when test="${not empty carList}">
        <c:forEach var="car" items="${carList}">
            <form:option value="${car.model.brand}">${car.model.brand}</form:option>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <option selected disabled>Brak wprowadzonych marek samochodów, najpierw dodaj nowe</option>
    </c:otherwise>
</c:choose>
    </form:select>
    <div>silnik:</div><form:input type="text" path="engine"/>

    <div><input type="submit" value="Zatwierdź"></div>
</form:form>
<%@ include file="fragments/footer.jsp" %>