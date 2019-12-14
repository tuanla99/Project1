package model;

import java.sql.SQLException;
import java.util.List;

public interface IUser {

    public User checkExist(String email, String passWord) throws SQLException;
    public List<User> getAllUser() throws SQLException;
    public void addUser(User u) throws SQLException;
    public void updateUser(User u) throws SQLException;
    public User getUserBySoDT(String soDT) throws SQLException;   // Tim kiem tai khoan.
    public Boolean checkExistEmail_Sdt(String email, String phone) throws SQLException; // Kiểm tra định dạng email
    public User login(String soDT, String pass) throws SQLException;
    public boolean register(String name, String email, String soDT, String pass, String address,int roleID) throws SQLException;

}
