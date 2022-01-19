<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fragments/dashboardHeader.jsp" %>

<div class="container px-4 px-lg-5 mt-5">
    <p class="lead fw-bold text-black-50 mb-0" style="color: #1a1e21">WIADOMOŚĆ OD ${message.user.username}</p>
    <div class="justify-content-center">
        <p>${message.content}</p>
    </div>
    <a href="/dashboard/messages">wróć do wiadomości</a> lub <a href="/${id}/delete"
                                                                onclick="return confirm('Czy na pewno chcesz usunąć tą wiadomość?');">usuń</a>
</div>
</section>
<%@ include file="fragments/footer.jsp" %>