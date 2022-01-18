<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <p class="lead fw-normal text-white-50 mb-0" style="color: #1a1e21">Wszystkie nasze auta:</p>
        <div class="justify-content-center">
            <table>
                <colgroup>
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 50%;">
                    <col span="1" style="width: 20%;">
                </colgroup>
                <tr>
                    <th>id</th>
                    <th>logo</th>
                    <th>samochód</th>
                    <th>akcje</th>
                </tr>

                <c:forEach items="${carlist}" var="car">
                    <tr>
                        <td> ${car.id}</td>
                        <td>
                            <img class="card-img-top" style="max-height:80px; max-width:80px;"
                                 src="<spring:url value="/images/logos/${car.model.brand.lowercase}.png"/>" alt="..."/>
                        </td>
                        <td>
                            <h5 class="fw-bolder">${car.model}, silnik: ${car.engine}</h5>
                        </td>
                        <td>
                            <a href="/dashboard/car/${car.id}/price">zmień cenę/promocję</a>
                            <a href="/dashboard/car/${car.id}/delete">usuń</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</section>
<%@ include file="fragments/footer.jsp" %>