package com.example.functional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class added {
    static Scanner scanner = new Scanner(System.in);
    private static final String url = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
    private static final String userNameBD = "root";
    private static final String passwordBD = "root";
    static PreparedStatement preparedStatement;
    private static String UserName,Password,NickName;
    private static float Balance;

public static void registration() throws SQLException {
    System.out.println("Введите ваше имя");
    UserName = scanner.nextLine();
    System.out.println("Придумайте никнейм");
    try (Connection connection = DriverManager.getConnection(url, userNameBD, passwordBD)) {
        while (true) {
            NickName = scanner.nextLine();
            
            // SQL-запрос для проверки существующего никнейма
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM user WHERE NickName = ?");
            preparedStatement.setString(1, NickName);
            
            // Выполняем запрос
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    System.out.println("Такой никнейм уже существует, попробуйте другой:");
                } else {
                    break;  // Никнейм доступен
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
    }
    System.out.println("Введите пароль,он должен быть не менее 8 символов");
    while (true) { 
        Password = scanner.nextLine();
        if (Password.length() >= 8) {
        System.out.println("Вы успешно зарегестрировались!");
        break;
        } else {
            System.out.println("Введите корректный пароль");
        }
    }
    
    addendum();
}

    
public static void addendum() throws SQLException{
    
try (Connection connection = DriverManager.getConnection(url, userNameBD, passwordBD)) {
        System.out.println("Подключение успешно!");
        String sql = "INSERT INTO user (UserName, Password, Balance,NickName) VALUES (?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);
            
            // 1. Установка значений
            preparedStatement.setString(1, UserName); 
            preparedStatement.setString(2, Password); 
            preparedStatement.setDouble(3, Balance);
            preparedStatement.setString(4, NickName);

            
            // 2. Выполняем запрос
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Данные добавлены: " + rowsAffected);
        if (!connection.isClosed()) {
            System.out.println("Подключен");
        
        }
    } catch (SQLException e){
        System.out.println("Не удалось подключиться: " + e.getMessage());
    }
   
             
         
}
}

