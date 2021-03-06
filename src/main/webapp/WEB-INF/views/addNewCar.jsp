<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="fragments/dashboardHeader.jsp" %>

<h1 style="text-align: center">Wprowadzenie nowego samochodu do bazy:</h1>

<form:form method="post" modelAttribute="car">
    <div>marka:</div>
    <form:select path="model.brand">
        <c:choose>
            <c:when test="${not empty brandList}">
                <c:forEach var="brand" items="${brandList}">
                    <form:option value="${brand}">${brand.brandName}</form:option>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <option selected disabled>wystąpił błąd, odśwież stronę</option>
            </c:otherwise>
        </c:choose>
    </form:select><form:errors path="model.brand"/>

    <div>model:</div>
    <form:input type="text" path="model.modelName"/><form:errors path="model.modelName"/>

    <div>nadwozie:</div>
    <form:select path="carBody">
        <form:option value="Hatchback">Hatchback</form:option>
        <form:option value="Kombi">Kombi</form:option>
        <form:option value="SUV">SUV</form:option>
        <form:option value="Cabrio">Cabrio</form:option>
        <form:option value="Sedan">Sedan</form:option>
        <form:option value="Coupe">Coupe</form:option>
    </form:select>

    <div>rok produkcji:</div>
    <form:input type="number" path="productionYear"/><form:errors path="productionYear"/>

    <div>silnik:</div>
    <form:input type="text" path="engine"/><form:errors path="engine"/>

    <div>kolor:</div>
    <form:input type="text" path="colour"/><form:errors path="colour"/>

    <div>rodzaj paliwa:</div>
    <form:select path="fuel">
        <form:option value="PB">PB</form:option>
        <form:option value="Diesel">Diesel</form:option>
        <form:option value="Hybrid">Hybryda</form:option>
        <form:option value="Electric">Elektryczny</form:option>
    </form:select>

    <div>Skrzynia biegów:</div>
    <form:select path="gearbox">
        <form:option value="Automatyczna">Automatyczna</form:option>
        <form:option value="Manualna">Manualna</form:option>
    </form:select>

    <div>cena za dzień wynajmu:</div>
    <form:input type="number" path="price"/><form:errors path="price"/>

    <div>Specyfikacja:</div>
    <form:input type="textarea" path="specification"/><form:errors path="specification"/>

    <div>Promocja:</div>
    <form:radiobutton path="promotion" value="1"/>Tak
    <form:radiobutton path="promotion" value="0"/>Nie

    <div><input type="submit" value="Zatwierdź"></div>
</form:form>
<%@ include file="fragments/footer.jsp" %>