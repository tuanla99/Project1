package controller;

import model.User;
import servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/myAccount")
public class MyAccountController extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("account");
        req.setAttribute("account",user);
        req.getRequestDispatcher("/view/client/my-account.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Email");
        String soDT = req.getParameter("SoDT");
        String password = req.getParameter("PassWord");
        String diaChi = req.getParameter("DiaChi");
        String tenKH = req.getParameter("tenKH");
        int roleId = 1;
        User user = new User(tenKH, email,soDT,password,diaChi,roleId);
        userService.updateUser(user);
        resp.sendRedirect(req.getContextPath()+"/myAccount");
    }
}
