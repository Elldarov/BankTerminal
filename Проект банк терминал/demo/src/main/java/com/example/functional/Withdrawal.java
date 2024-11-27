package com.example.functional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.example.functional.entry.getCurrentUserCode;

public class Withdrawal {

    private static final String url = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
    private static final String userNameBD = "root";
    private static final String passwordBD = "root";

    public static void withdraw() {
        try {
            String userCode = getCurrentUserCode(); // Получаем текущий UserCode
            withdrawAmount(userCode); // Передаем его в метод withdrawAmount
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void withdrawAmount(String userCode) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userNameBD, passwordBD);
        int currentBalance = getCurrentBalance(connection, userCode);

        int inputMoney = inputMoney(); // Запрашиваем у пользователя сумму для снятия

        if (inputMoney > currentBalance) {
            System.out.println("Недостаточно средств для снятия. Ваш текущий баланс: " + currentBalance);
            return;
        }

        int newBalance = currentBalance - inputMoney; // Вычитаем введенную сумму из текущего баланса
        updateBalance(connection, userCode, newBalance);
        System.out.println("Средства сняты, доступные средства: " + newBalance);

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
            System.out.println("Введите сумму для снятия, кратную 50");
            while (true) {
                try {
                    int inMoney = scanner.nextInt();
                    if (inMoney % 50 != 0) {
                        System.out.println("Сумма должна быть кратна 50");
                    } else {
                        return inMoney;
                    }
                } catch (Exception e) {
                    System.out.println("Пожалуйста, введите число, а не символы");
                    scanner.next(); // Чтение неверного ввода
                }
            }
        }
    }
}
