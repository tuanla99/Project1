package model;

import java.sql.SQLException;

public interface IAdmin {
    public Boolean login( String username, String password) throws SQLException;
}
