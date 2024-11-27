<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="hello" method="post">
        <h2>Регистрация</h2>
        <label for="name">Имя:</label>
        <input type="text" placeholder="Иван" id="name" name="name" required>
        <label for="email">Email:</label>
        <input type="email" placeholder="Email@gmail.com" id="email" name="email" required>
        <label for="password">Пароль:</label>
        <p class="text-center" style="color: red">${errorMessage}</p>
        <input type="password" placeholder="Ivan1234!" id="password" name="password" required>
        <input type="submit" value="Зарегистрироваться">
    </form>
</body>
</html>
