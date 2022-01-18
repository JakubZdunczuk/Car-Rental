<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <p class="lead fw-normal text-center text-black-50 mb-0">Obecnie dostępne auta do wynajmu na doby:</p>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${car}" var="car">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top"
                             src="<spring:url value="/images/logos/${car.model.brand.lowercase}.png"/>" alt="..."/>
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${car.model}</h5>
                                <!-- Product price-->
                                <c:choose>
                                    <c:when test="${car.promotion==1}">
                                        <div class="text-danger">już od ${car.price}PLN/doba!</div>
                                    </c:when>
                                    <c:otherwise>
                                        cena: ${car.price}PLN/doba
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/cars/${car.id}">Wyświetl
                                szczegóły</a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<%@ include file="fragments/footer.jsp" %>