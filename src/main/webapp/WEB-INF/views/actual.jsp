<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<!-- Section-->
<section class="py-5">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false">MENU</a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="/menu">Pulpit</a></li>
                <li>
                    <hr class="dropdown-divider"/>
                </li>
                <a class="dropdown-item" href="/menu/actual">Aktualnie wypożyczone auta</a>
                <a class="dropdown-item" href="/menu/history">Historia wypożyczeń</a>
                <a class="dropdown-item" href="/menu/#">Napisz wiadomość do CarRental (aktualnie niedostępne)</a>
                <a class="dropdown-item" href="/menu/#">Zmień hasło (aktualnie niedostępne)</a>
                <a class="dropdown-item" href="/menu/#">Zmień dane (aktualnie niedostępne)</a>
            </ul>
        </li>
    </ul>
    <div class="container px-4 px-lg-5 mt-5">
        <p class="lead fw-bold text-black-50 mb-0" style="color: #1a1e21">Aktualnie wynajęte samochody:</p>
        <div class="justify-content-center">
            <table>
                <colgroup>
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 20%;">
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 20%;">
                </colgroup>
                <tr>
                    <th>auto</th>
                    <th>okres wynajmu</th>
                    <th>dzień rozpoczęcia wynajmu</th>
                    <th>akcje</th>
                </tr>

                <c:forEach items="${history}" var="history">
                    <tr>
                        <td>${history.car.model}</td>
                        <c:choose>
                            <c:when test="${history.days==0}">
                                <td>${history.months} miesiąc/miesięcy</td>
                                <td>${history.rentDay.toString()}</td>

                            </c:when>
                            <c:otherwise>
                                <td>${history.days} dzień/dni</td>
                                <td>${history.rentDay.toString()}</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a href="/menu/actual/${history.id}">zakończ wynajem</a>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
<%@ include file="fragments/footer.jsp" %>