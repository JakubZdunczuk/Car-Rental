<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <p class="lead fw-bold text-black-50 mb-0" style="color: #1a1e21">Historia wynajmu:</p>
        <div class="justify-content-center">
            <table>
                <colgroup>
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 20%;">
                    <col span="1" style="width: 20%;">
                    <col span="1" style="width: 10%;">
                    <col span="1" style="width: 20%;">
                </colgroup>
                <tr>
                    <th>auto</th>
                    <th>okres wynajmu</th>
                    <th>dzień rozpoczęcia wynajmu</th>
                    <th>czy zakończony</th>
                    <th>całkowity koszt</th>
                </tr>

                <c:forEach items="${history}" var="history">
                    <tr>
                        <td>${history.car.model}</td>
                        <td>
                            <c:choose>
                                <c:when test="${history.days==0}">
                                    ${history.months} miesiąc/miesięcy
                                </c:when>
                                <c:otherwise>
                                    ${history.days} dzień/dni
                                </c:otherwise>
                            </c:choose></td>
                        <td>${history.rentDay.toString()}</td>
                        <td>${history.rented ? "Nie":"Tak"}</td>
                        <td>${history.price} PLN</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
<%@ include file="fragments/footer.jsp" %>