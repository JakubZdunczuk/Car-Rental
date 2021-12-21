<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <p class="lead fw-normal text-white-50 mb-0">Wszystkie nasze auta:</p>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:choose>
                <c:when test="${car!=null}">
                    <!-- Product image-->
                    <img class="card-img-top" src="<spring:url value="/images/logos/${car.model.brand}.png"/>" alt="..."/>
                    <style type="text/css">
                        .tg  {border-collapse:collapse;border-spacing:0;}
                        .tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
                            overflow:hidden;padding:10px 5px;word-break:normal;}
                        .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
                            font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
                        .tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
                    </style>
                    <table class="tg">
                        <thead>
                        <tr>
                            <th class="tg-0pky" colspan="7">SPECYFIKACJA</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="tg-0pky">Model</td>
                            <td class="tg-0pky">${car.model}</td>

                        </tr>
                        <tr>
                            <td class="tg-0pky">rok produkcji</td>
                            <td class="tg-0pky">${car.productionYear}</td>

                        </tr>
                        <tr>
                            <td class="tg-0pky">nadwozie</td>
                            <td class="tg-0pky">${car.carBody}</td>

                        </tr>
                        <tr>
                            <td class="tg-0pky">kolor</td>
                            <td class="tg-0pky">${car.colour}</td>
                        </tr>
                        <tr>
                            <td class="tg-0pky">silnik</td>
                            <td class="tg-0pky">${car.engine}</td>
                        </tr>
                        <tr>
                            <td class="tg-0pky">paliwo</td>
                            <td class="tg-0pky">${car.fuel}</td>
                        </tr>
                        <tr>
                            <td class="tg-0pky">skrzynia biegów</td>
                            <td class="tg-0pky">${car.gearbox}</td>
                        </tr>
                        <tr>
                            <td class="tg-0pky">Wyposażenie dodatkowe</td>
                            <td class="tg-0pky">${car.specification}</td>
                        </tr>
                        </tbody>

                    </table>
                    <!-- Product actions-->
                </c:when>
            </c:choose>
        </div>
        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
            <div class="text-center"><a class="btn btn-outline-dark mt-auto"
                                        href="/cars/${car.id}/rent">Wynajmij</a>
            </div>
        </div>
    </div>
</section>
<%@ include file="fragments/footer.jsp" %>