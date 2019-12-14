package servise;

import database.AdminDB;
import model.IAdmin;

import java.sql.SQLException;

public class AdminService implements IAdmin {
    private AdminDB adminDB = new AdminDB();
    @Override
    public Boolean login(String username,String password)  {
        return adminDB.login(username,password);
    }
}
