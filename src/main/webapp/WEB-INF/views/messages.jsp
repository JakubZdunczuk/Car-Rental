<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/dashboardHeader.jsp" %>

<div class="container px-4 px-lg-5 mt-5">
    <p class="lead fw-bold text-black-50 mb-0" style="color: #1a1e21">Lista wiadomości:</p>
    <div class="justify-content-center">
        <table>
            <colgroup>
                <col span="1" style="width: 40%;">
                <col span="1" style="width: 20%;">
                <col span="1" style="width: 40%;">


            </colgroup>
            <tr>
                <th>Temat wiadomości</th>
                <th>Autor</th>
                <th>akcje</th>

            </tr>

            <c:forEach items="${messages}" var="message">
                <tr>
                    <td>${message.read ? '':'<h6>'}<a
                            href="/dashboard/messages/${message.id}">${message.subject}</a>${not message.read ? '':'</h6>'}
                    </td>
                    <td>${message.user.username}</td>
                    <td>
                        <a href="/dashboard/messages/${message.id}/delete"
                           onclick="return confirm('Czy na pewno chcesz usunąć tą wiadomość?');">Usuń</a></td>
                    <td><a href="/dashboard/messages/${message.id}/read">Oznacz jako przeczytane/nieprzeczytane</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</section>
<%@ include file="fragments/footer.jsp" %>