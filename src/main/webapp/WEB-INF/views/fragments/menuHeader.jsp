<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
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
            <a class="dropdown-item" href="/menu/write">Napisz wiadomość do CarRental(niedostępne)</a>
            <a class="dropdown-item" href="/menu/changepass">Zmień hasło</a>
        </ul>
    </li>
</ul>