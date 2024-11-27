
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">
<head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333; /* Цвет заголовка */
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center; /* Центрирование контейнера */
        }
        button {
            background-color: #4CAF50; /* Зеленый цвет */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 18px; /* Увеличенный размер шрифта */
            margin: 10px; /* Увеличенный отступ между кнопками */
            cursor: pointer;
            border-radius: 12px; /* Увеличенные скругленные углы */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Тень для кнопок */
            transition: background-color 0.3s, transform 0.2s; /* Плавные переходы */
        }
        button:hover {
            background-color: #45a049; /* Темно-зеленый цвет при наведении */
            transform: translateY(-2px); /* Эффект поднятия при наведении */
        }
    </style>
</head>
<body>
    <div class="container"> <!-- Контейнер для кнопок -->
        <h1>Hello, Jakarta EE!</h1>
        <p>
            <%= new java.util.Date()%>
        </p>
        <!-- Кнопки -->
        <button onclick= "document.location='firstCandidate.jsp'">Первый кандидат</button>
        <button onclick= "document.location='secondCandidate.jsp'">Второй кандидат</button>
       
    </div> <!-- Закрываем контейнер -->
</body>
</html>


