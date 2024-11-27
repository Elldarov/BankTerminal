<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Предвыборная кампания Первого кандидата</title>
    <style>
        body {
            background-color: #f0f0f0; /* Цвет фона страницы */
            font-family: Arial, sans-serif; /* Шрифт текста */
            line-height: 1.6; /* Интервал между строками для лучшей читаемости */
        }
        
        h1 {
            color: #333; /* Цвет заголовка */
            text-align: center; /* Выравнивание заголовка по центру */
            margin-top: 30px; /* Отступ сверху заголовка */
        }
        
        p {
            color: #666; /* Цвет текста абзаца */
            padding: 20px; /* Отступ внутри абзаца */
            font-size: 18px; /* Размер шрифта абзаца */
            background-color: #fff; /* Цвет фона абзаца */
            border-radius: 10px; /* Закругление углов фона абзаца */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Тень для эффекта */
        }

        /* Стили для кнопки */
        .button {
            display: block; /* Блоковый элемент для лучшего выравнивания */
            width: 200px; /* Ширина кнопки */
            margin: 20px auto; /* Центрирование кнопки */
            padding: 10px; /* Отступы внутри кнопки */
            background-color: #d60707c4; /* Синий цвет кнопки */
            color: white; /* Цвет текста на кнопке */
            border: none; /* Без рамки */
            border-radius: 5px; /* Закругление углов кнопки */
            font-size: 18px; /* Размер шрифта кнопки */
            cursor: pointer; /* Указатель для курсора */
            text-align: center; /* Центрирование текста на кнопке */
        }

        .button:hover {
            background-color: #c70505c4; /* Цвет при наведении */
        }
    </style>
</head>
<body>
    <h1>Добро пожаловать на сайт предвыборной кампании Второго кандидата!</h1>
    <p>Уважаемые избиратели! Мы рады приветствовать вас на нашем официальном сайте. Здесь вы найдете всю необходимую информацию о программе и целях нашего кандидата. Мы стремимся к тому, чтобы сделать нашу страну лучше, более справедливой и процветающей. Присоединяйтесь к нам и узнайте больше о том, как мы планируем достичь этих целей вместе. Ваша поддержка имеет значение!</p>
    <button class="button" onclick= "document.location='reg.jsp'">Выбрать кандидата Н2</button> <!-- Кнопка добавлена здесь -->
</body>
</html>
