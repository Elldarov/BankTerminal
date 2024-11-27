    package com.example;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    public class DBEditor {

        public static Connection DbConnection() throws SQLException, ClassNotFoundException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&serverTimezone=Europe/Moscow", "root", "root");
            } catch (SQLException e) {
                // Handle the exception here (e.g., log or rethrow)
                e.printStackTrace();
                throw e;
            }
        }

        public static void addendum(String Password, String Name, String Gmail) throws ClassNotFoundException {
            try (Connection connection = DbConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO UserWEB(Password, Gmail, Name) VALUES (?, ?, ?)")) {

                statement.setString(1, Password);
                statement.setString(2, Name);
                statement.setString(3, Gmail);

                statement.executeUpdate();

                System.out.println("Data successfully added to the table.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
