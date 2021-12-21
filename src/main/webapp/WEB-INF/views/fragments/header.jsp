<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>CAR RENTAL - wynajem samochodów</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<spring:url value="/assets/favicon.ico" />"/>
    <!-- Bootstrap icons-->
    <link rel="stylesheet" href="<spring:url value="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"  />"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/styles.css" />"/>
</head>
<body>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/"><img width="120px" height="auto" src="<spring:url value="/images/car-logo2.jpg"/>"/> </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Wynajem</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/cars">Wszystkie dostępne auta</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="/short">Wynajem krótkoterminowy</a></li>
                        <li><a class="dropdown-item" href="/long">Wynajem długoterminowy</a></li>
                    </ul>
                </li>
                <li class="nav-item"><a class="nav-link" aria-current="page" href="/about">O nas</a></li>
                <li class="nav-item"><a class="nav-link" href="/contact">Kontakt</a></li>
            </ul>
            <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <a class="nav-link" href="/dashboard">Dashboard</a>
                <form id="logoutForm" method="POST" action="/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <a onclick="document.forms['logoutForm'].submit()" href="#">Logout</a></h2>
            </c:when>
            <c:otherwise>
                <hr class="dropdown-divider"/>
                <a class="nav-link" href="/login">Logowanie</a>
                <hr class="dropdown-divider"/>
                <a class="nav-link" href="/register">Rejestracja</a>
            </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
<!-- Header-->
<header class="bg-dark py-3">
    <div class="container px-2 px-lg-3 my-3">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Car Rental</h1>
            <p class="lead fw-normal text-white-50 mb-0">Auto dostępne dla każdego! Wybierz, opłać, a my dostarczymy pojazd pod wskazane przez Ciebie miejsce!</p>
        </div>
    </div>
</header>