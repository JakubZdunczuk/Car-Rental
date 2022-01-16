<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/header.jsp" %>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <p class="lead fw-normal text-black-50 mb-0">Wynajem auta:</p>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:choose>
            <c:when test="${car!=null}">
            <!-- Product image-->
            <img class="card-img-top" style="max-height: 300px; max-width: 300px"
                 src="<spring:url value="/images/logos/${car.model.brand.lowercase}.png"/>"
                 alt="..."/>


            <h3 class="tg-0pky">${car.model}</h3>
            <div>
                <h2 class="tg-0pky">Cena</h2>
                <h3 class="tg-0pky">${car.price}PLN/doba</h3>
                <br>
                <h3 class="tg-0pky">${car.price*18}PLN/miesiąc</h3>
                </c:when>
                </c:choose>
            </div>
            <div>
                <form:form method="post" modelAttribute="rentHistory">
                    <h5 class="text-center">Na ile chcesz wynająć?</h5>
                    <div>dziennie</div>
                    <form:select path="days">
                        <form:option value="1">1 dzień</form:option>
                        <form:option value="2">2 dni</form:option>
                        <form:option value="3">3 dni</form:option>
                        <form:option value="4">4 dni</form:option>
                        <form:option value="5">5 dni</form:option>
                        <form:option value="6">6 dni</form:option>
                        <form:option value="7">7 dni</form:option>
                    </form:select>
                    <form:hidden path="user.username" value="${pageContext.request.remoteUser}"/>
                    <input type="submit" value="Zamów na dni">
                </form:form>

                <form:form method="post" modelAttribute="rentHistory">
                    <div>miesięcznie</div>
                    <form:select path="months">
                        <form:option value="1">1 miesiąc</form:option>
                        <form:option value="2">2 miesiące</form:option>
                        <form:option value="3">3 miesiące</form:option>
                        <form:option value="4">4 miesiące</form:option>
                        <form:option value="5">5 miesięcy</form:option>
                        <form:option value="6">6 miesięcy</form:option>
                        <form:option value="7">7 miesięcy</form:option>
                        <form:option value="8">8 miesięcy</form:option>
                        <form:option value="9">9 miesięcy</form:option>
                        <form:option value="10">10 miesięcy</form:option>
                        <form:option value="11">11 miesięcy</form:option>
                        <form:option value="12">12 miesięcy</form:option>
                    </form:select>
                    <form:hidden path="user.username" value="${pageContext.request.remoteUser}"/>
                    <input type="submit" value="Zamów na miesiące">
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@ include file="fragments/footer.jsp" %>