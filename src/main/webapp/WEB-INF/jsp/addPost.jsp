<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Post</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous"/>
    <style>
        body {
            background-color: azure;
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
</head>
<body>
<h2 align="center">ДОБАВИТЬ ТЕМУ</h2>

<br>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand">Forum job4j users</a>
    <a class="navbar-brand" href="<c:url value='/'/>">Main page</a>
</nav>
<br>

<div class="container">
    <form action="<c:url value='/save'/>" method="post">
        <div class="table table-bordered">
            <table class="table table-bordered" id="table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type='text' name="name"></td>
                    <td><input type='text' name="description"></td>
                </tr>
                </tbody>
            </table>
            <div align="center">
                <input name="submit" type="submit" value="Добавить">
            </div>
        </div>
    </form>
</div>
</body>
</html>