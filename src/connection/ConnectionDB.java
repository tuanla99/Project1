package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection getConnectionDB() throws SQLException {
        Connection connection;
        connection= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Project1DB","sa","1234");
        return connection;
    }
}
