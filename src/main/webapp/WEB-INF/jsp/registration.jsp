<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
  <title>Регистрация</title>
</head>
<style>
  body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
  }

  * {
    box-sizing: border-box;
  }

  /* Add padding to containers */
  .container {
    padding: 16px;
    background-color: white;
  }

  /* Full-width input fields */
  input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
  }

  input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
  }
</style>

<body>
<div class="container">
  <form:form method="POST" modelAttribute="userForm">
    <h2>Регистрация</h2>
    <div>
      <form:input type="text" path="username" placeholder="Username"
                  autofocus="true"></form:input>
      <form:errors path="username"></form:errors>
        ${usernameError}
    </div>
    <div>
      <form:input type="password" path="password" placeholder="Password"></form:input>
    </div>
    <div>
      <form:input type="password" path="passwordConfirm"
                  placeholder="Confirm your password"></form:input>
      <form:errors path="password"></form:errors>
        ${passwordError}
    </div>
    <button type="submit" style="animation-delay: initial">Зарегистрироваться</button>
  </form:form>
  <br>
  <a href="/">Главная</a>
</div>
</body>
</html>