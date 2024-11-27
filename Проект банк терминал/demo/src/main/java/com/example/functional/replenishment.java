package com.example.functional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.example.functional.entry.getCurrentUserCode;


public class replenishment {

    private static final String url = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
    private static final String userNameBD = "root";
    private static final String passwordBD = "root";
     
   
    public static void replenishmen() {
        try {
            String userCode = getCurrentUserCode(); // Получаем текущий UserCode
            replenish(userCode); // Передаем его в метод replenish
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void replenish(String userCode) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userNameBD, passwordBD);
        int currentBalance = getCurrentBalance(connection, userCode);

        int inputMoney = inputMoney();
        int newBalance = currentBalance + inputMoney;

        updateBalance(connection, userCode, newBalance);
        System.out.println("Баланс пополнен, доступные средства: " + newBalance);

        connection.close(); // Закрытие соединения
    }

    private static int getCurrentBalance(Connection connection, String userCode) throws SQLException {
        String query = "SELECT balance FROM user WHERE UserCode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("balance");
            } else {
                throw new SQLException("Пользователь не найден.");
            }
        }
    }

    private static void updateBalance(Connection connection, String userCode, int newBalance) throws SQLException {
        String updateQuery = "UPDATE user SET balance = ? WHERE UserCode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, newBalance);
            preparedStatement.setString(2, userCode);
            preparedStatement.executeUpdate();
        }
    }

    private static int inputMoney() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Внесите сумму кратную 50");
            while (true) {
                try {
                    int inMoney = scanner.nextInt();
                    if (inMoney % 50 != 0) {
                        System.out.println("Сумма должна быть кратна 50");
                    } else {
                        return inMoney;
                    }
                } catch (Exception e) {
                    System.out.println("Пожалуйста, внесите число, а не символы");
                    scanner.next(); // Чтение неверного ввода
                }
            }
        }
    }
}
