<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous"/>
    <style>
        body {
            background-color: azure;
            outline: 2px solid #000; /* Чёрная рамка */
            border-radius: 10px; /* Радиус скругления */
            border-width: 20px;
            padding: 10px;
        }
        #table {
            background-color: darkseagreen;
        }
        th {
            background-color: chocolate;
        }
        h2 {
            color: rebeccapurple;
        }
    </style>
    <script>
        function del2(id) {
            alert("Are you really want delete record with id: " + id);
            $.ajax({
                type: "POST",
                url: window.location + "delete/" + id
            });
        }

        $(document).on("click", ".showHideButton", function () {
            if ($(this).parent().parent().hasClass("service-header") && $(this).parent().parent().is(":visible")) {
                $(this).parent().parent().hide();
            } else {
                $(this).parent().parent().show();
            }
        });
    </script>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div align="right">
    <sec:authorize access="isAuthenticated()">
        <h3>Вы вошли как: ${pageContext.request.userPrincipal.name}</h3>
    </sec:authorize>
    <%--  В наших приложениях у нас может быть информация, которая должна отображаться только для определенных ролей
     или пользователей.
    В этом случае мы можем использовать  тег авторизации :--%>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Войти</a></h4>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
</div>
<div align="center">
    <h4><a href="/addPost">Добавить тему (только пользователь)</a></h4>
    <h4><a href="/admin">Пользователи (только админ)</a></h4>
</div>
<div>
    <table class="table table-bordered" id="table">
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Data</th>
        <th>Edit record</th>
        <th>Удаление только для пользователей</th>
        </thead>
        <c:forEach items="${posts}" var="post">
            <tr class="service-header">
                <form action="<c:url value='/edit'/>" method="GET">
                    <td><input type="hidden" name="id" id="id" value="${post.id}">${post.id}</td>
                    <td><input type="hidden" name="name" value="${post.name}">${post.name}</td>
                    <td><input type="hidden" name="description" value="${post.description}">${post.description}</td>
                    <td><fmt:formatDate type="date" value="${post.created.time}"/></td>
                    <td><input type="submit" class="button" name="edit" value="Edit"></td>
                    <td>
                        <button type='button' style="background-color: lightyellow"
                                class='showHideButton btn btn-default' onclick="del2(${post.id})">Delete
                        </button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
