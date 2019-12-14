package database;

import connection.ConnectionDB;
import model.IUser;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB implements IUser {
    @Override
    public User checkExist(String soDT, String passWord)  {
        try {
            boolean tmp = false;
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from KhachHang ;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                if (resultSet.getString(4).equals(soDT) && resultSet.getString(5).equals(passWord)){
                    User user =new User();
                    user.setMaKH(resultSet.getString(1));
                    user.setTenKH(resultSet.getString(2));
                    user.setEmail(resultSet.getString(3));
                    user.setSoDT(resultSet.getString(4));
                    user.setPassWord(resultSet.getString(5));
                    user.setDiaChi(resultSet.getString(6));
                    user.setRoleID(resultSet.getInt(7));
                    statement.close();
                    return user;
                }
            }
            statement.close();
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<User> getAllUser()  {
        try {
            List<User> users = new ArrayList<>();

            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from KhachHang;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user =new User();
                user.setMaKH(resultSet.getString(1));
                user.setTenKH(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setSoDT(resultSet.getString(4));
                user.setPassWord(resultSet.getString(5));
                user.setDiaChi(resultSet.getString(6));
                user.setRoleID(resultSet.getInt(7));
                users.add(user);
            }
            statement.close();
            return users;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void addUser(User u) {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="insert into KhachHang(TenKH, Email, SoDT, PassWord, DiaChi, Role_id) values (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,u.getTenKH());
            statement.setString(2,u.getEmail());
            statement.setString(3,u.getSoDT());
            statement.setString(4,u.getPassWord());
            statement.setString(5,u.getDiaChi());
            statement.setInt(6,u.getRoleID());
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User u) {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="update KhachHang set TenKH=?, Email=?, SoDT=?,Password=?,DiaChi=? where MaKH =? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(6,u.getMaKH());
            statement.setString(1,u.getTenKH());
            statement.setString(2,u.getEmail());
            statement.setString(3,u.getSoDT());
            statement.setString(4,u.getPassWord());
            statement.setString(5,u.getDiaChi());

            statement.executeLargeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public User getUserBySoDT(String soDT) {
        try {
            User user = new User();

            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from KhachHang where SoDT =?;";
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setString(1,soDT);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                user.setMaKH(resultSet.getString(1));
                user.setTenKH(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setSoDT(resultSet.getString(4));
                user.setPassWord(resultSet.getString(5));
                user.setDiaChi(resultSet.getString(6));
                user.setRoleID(resultSet.getInt(7));
            }

            statement.close();
            return user;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Boolean checkExistEmail_Sdt(String email, String phone)  {
        try {
            Connection connection = ConnectionDB.getConnectionDB();
            String sql ="select * from KhachHang where Email=? or SoDT=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,phone);
            int tmp=  statement.executeUpdate();
            statement.close();
            return tmp != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public User login(String soDT, String pass)  {
        User user = this.checkExist(soDT,pass);
        if (user != null) return user;
        else return null;

    }

    @Override
    public boolean register(String name, String email, String soDT, String pass, String address,int roleID)  {
         if (this.checkExistEmail_Sdt(email,soDT)){
            return false;
         }else {
            this.addUser(new User(name,email,soDT,pass,address, roleID));
            return true;
         }
    }


}
