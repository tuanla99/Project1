package connection;

import java.sql.*;

public class ConnectionDB {
    public static Connection getConnectionDB() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String pass = "1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Project1DB";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("thanh cong");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB.getConnectionDB();
        String sql ="select * from Admin;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
    }

