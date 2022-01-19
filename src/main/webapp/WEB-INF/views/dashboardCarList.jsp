<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/dashboardHeader.jsp" %>

<div class="container px-4 px-lg-5 mt-5">
    <p class="lead fw-bold text-black-50 mb-0" style="color: #1a1e21">Lista samochodów:</p>
    <div class="justify-content-center">
        <table>
            <colgroup>
                <col span="1" style="width: 5%;">
                <col span="1" style="width: 20%;">
                <col span="1" style="width: 15%;">
                <col span="1" style="width: 10%;">
                <col span="1" style="width: 10%;">
                <col span="1" style="width: 20%;">
                <col span="1" style="width: 20%;">
            </colgroup>
            <tr>
                <th>ID</th>
                <th>auto</th>
                <th>silnik</th>
                <th>rocznik</th>
                <th>czy wynajęty</th>
                <th>cena</th>
                <th>akcje</th>
            </tr>

            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.model}</td>
                    <td>${car.engine}</td>
                    <td>${car.productionYear}</td>
                    <td>${car.rented ? "Nie":"Tak"}</td>
                    <td>${car.price} PLN</td>
                    <td>
                        <a href="/dashboard/cars/${car.id}">zmień cenę/promocję</a>
                        <a href="/dashboard/cars/${car.id}/delete"
                           onclick="return confirm('Czy na pewno chcesz usunąć to auto?');">Usuń</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</section>
<%@ include file="fragments/footer.jsp" %>