<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<h1 style="text-align:center">USER DASHBOARD</h1>
<div style="text-align: center">
    <a class="dropdown-item" href="/menu">Pulpit</a>
    <hr class="dropdown-divider"/>
    </li>
    <a class="dropdown-item" href="/menu/actual">Aktualnie wypożyczone auta</a>
    <a class="dropdown-item" href="/menu/history">Historia wypożyczeń</a>
    <a class="dropdown-item" href="/menu/write">Napisz wiadomość do CarRental</a>
    <a class="dropdown-item" href="/menu/changepass">Zmień hasło</a>
    <a class="dropdown-item" href="/menu/details">Zmień dane</a>
</div>
<section class="padding-medium story bg-light">
    <div class="py-5">

    </div>
</section>

<%@ include file="fragments/footer.jsp" %>
