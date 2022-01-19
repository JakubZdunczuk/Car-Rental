<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/dashboardHeader.jsp" %>

<div class="container px-4 px-lg-5 mt-5">
    <p class="lead fw-bold text-black-50 mb-0" style="color: #1a1e21">Lista samochodów:</p>
    <div class="justify-content-center">
        <table>
            <colgroup>
                <col span="1" style="width: 5%;">
                <col span="1" style="width: 30%;">
                <col span="1" style="width: 30%;">
                <col span="1" style="width: 30%;">

            </colgroup>
            <tr>
                <th>ID</th>
                <th>username</th>
                <th>e-mail</th>
                <th>akcje</th>

            </tr>

            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="/dashboard/users/${user.id}/delete"
                           onclick="return confirm('Czy na pewno chcesz usunąć tego użytkownika?');">Usuń</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</section>
<%@ include file="fragments/footer.jsp" %>