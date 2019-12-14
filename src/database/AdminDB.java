package database;

import connection.ConnectionDB;
import model.Admin;
import model.IAdmin;

import java.sql.*;

public class AdminDB implements IAdmin {
    @Override
    public Boolean login(String username, String password) {

        String sql = "select * from Admin where username=? and password =?;";
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                statement.close();
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
