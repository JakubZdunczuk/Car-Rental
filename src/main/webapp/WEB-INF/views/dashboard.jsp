<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<h1 style="text-align:center">ADMIN DASHBOARD</h1>
<div style="text-align: center">
        <a class="dropdown-item" href="/dashboard">Pulpit</a>
        <hr class="dropdown-divider"/></li>
        <a class="dropdown-item" href="/dashboard/add">Dodaj nowe auto</a>
        <a class="dropdown-item" href="/dashboard/carlist">Edytuj dostępne auta</a>
        <a class="dropdown-item" href="/dashboard/messages">Wiadomości</a>
        <a class="dropdown-item" href="/dashboard/changepass">Zmień hasło</a>
        <a class="dropdown-item" href="/dashboard/users">Użytkownicy</a>
</div>
<section class="padding-medium story bg-light">
    <div class="py-5">

    </div>
</section>

<%@ include file="fragments/footer.jsp" %>
