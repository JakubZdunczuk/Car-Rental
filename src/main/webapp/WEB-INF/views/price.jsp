<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/dashboardHeader.jsp" %>
<!-- Section-->
<section class="py-5">

    <c:choose>
        <c:when test="${car!=null}">
            <!-- Product image-->
            <style type="text/css">
                .tg {
                    border-collapse: collapse;
                    border-spacing: 0;
                }

                .tg td {
                    border-color: black;
                    border-style: solid;
                    border-width: 1px;
                    font-family: Arial, sans-serif;
                    font-size: 14px;
                    overflow: hidden;
                    padding: 10px 5px;
                    word-break: normal;
                }

                .tg th {
                    border-color: black;
                    border-style: solid;
                    border-width: 1px;
                    font-family: Arial, sans-serif;
                    font-size: 14px;
                    font-weight: normal;
                    overflow: hidden;
                    padding: 10px 5px;
                    word-break: normal;
                }

                .tg .tg-0pky {
                    border-color: inherit;
                    text-align: left;
                    vertical-align: top
                }
            </style>
            <table class="tg">
                <colgroup>
                    <col span="1" style="width: 40%;">
                    <col span="1" style="width: 30%;">
                    <col span="1" style="width: 30%;">
                </colgroup>
                <thead>
                <tr>
                    <th class="tg-0pky" colspan="7">ZMIANA CENY:</th>
                </tr>
                </thead>
                <form:form modelAttribute="car" method="post">
                    <tbody>
                    <tr>
                        <td class="tg-0pky">Model</td>
                        <td colspan="2" class="tg-0pky">${car.model}</td>
                    </tr>
                    <tr>
                        <td class="tg-0pky">Cena</td>
                        <td class="tg-0pky">${car.price} PLN</td>
                        <td class="tg-0pky">Nowa cena:<form:input type="number" value="${car.price}" path="price"/></td>
                    </tr>
                    <tr>
                        <td class="tg-0pky">promocyjna oferta</td>
                        <c:choose>
                            <c:when test="${car.promotion==1}">
                                <td class="tg-0pky">TAK <form:radiobutton path="promotion" value="1"
                                                                          checked="true"/></td>
                                <td class="tg-0pky">NIE <form:radiobutton path="promotion" value="0"/></td>
                            </c:when>
                            <c:otherwise>
                                <td class="tg-0pky">TAK <form:radiobutton path="promotion" value="1"/></td>
                                <td class="tg-0pky">NIE <form:radiobutton path="promotion" value="0"
                                                                          checked="true"/></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td class="tg-0pky"><input type="submit" value="Zatwierdź zmiany"></td>
                    </tr>
                    </tbody>
                </form:form>
            </table>
            <!-- Product actions-->
        </c:when>
    </c:choose>

</section>
<%@ include file="fragments/footer.jsp" %>