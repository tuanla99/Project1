package servise;

import database.UserDB;
import model.IUser;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUser {
    private UserDB userDB;
    @Override
    public User checkExist(String email, String passWord)   {
         return userDB.checkExist(email,passWord);
    }

    @Override
    public List<User> getAllUser()   {
        return userDB.getAllUser();
    }

    @Override
    public void addUser(User u)   {
       userDB.addUser(u);
    }

    @Override
    public void updateUser(User u)   {
       userDB.updateUser(u);
    }

    @Override
    public User getUserBySoDT(String soDT)   {
       return userDB.getUserBySoDT(soDT);
    }

    @Override
    public Boolean checkExistEmail_Sdt(String email, String phone)   {
        return userDB.checkExistEmail_Sdt(email,phone);
    }

    @Override
    public User login(String soDT, String pass)   {
        return userDB.login(soDT, pass);
    }

    @Override
    public boolean register(String name, String email, String soDT, String pass, String address, int roleID)   {
        return userDB.register(name, email, soDT, pass, address,roleID);
    }




}
