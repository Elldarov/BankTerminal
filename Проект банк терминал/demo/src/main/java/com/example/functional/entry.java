package com.example.functional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.example.functional.functional.functional;

public class entry {
    static Scanner scanner = new Scanner(System.in);

    private static final String url = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
    private static final String userNameBD = "root";
    private static final String passwordBD = "root";
    private static String password, nickName;
    private static String currentUserCode;

    public static void entry() {
        System.out.println("Введите свой никнейм");
        try (Connection connection = DriverManager.getConnection(url, userNameBD, passwordBD)) {
            while (true) {
                nickName = scanner.nextLine();
                
                // SQL-запрос для проверки существующего никнейма
                String sqlUser = "SELECT Password, UserCode FROM user WHERE NickName = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlUser);
                preparedStatement.setString(1, nickName);
                
                // Выполняем запрос
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    String userCode = resultSet.getString("UserCode"); // Извлечение UserCode
                    
                    String pass = resultSet.getString("Password");
                    
                    System.out.println("Нашли вас, теперь введите пароль");
                    password = scanner.next();
                    
                    // Используем метод equals для сравнения строк
                    if (password.equals(pass)) {
                        System.out.println("Вход выполнен");
                        login(userCode);
                        functional();
                        break;
                    } else {
                        System.out.println("Неверный пароль");
                    }
                    break;
                } else {
                    System.out.println("Такого пользователя нет");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
    public static void login(String userCode) {
        currentUserCode = userCode; // Сохраним код пользователя после входа
    }

    public static String getCurrentUserCode() {
        return currentUserCode; // Метод для получения текущего кода пользователя
    }

}
