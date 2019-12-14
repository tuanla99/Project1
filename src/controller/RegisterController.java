package controller;

import model.User;
import servise.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("tenKH") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }
        // check cookie
        Cookie cookies[] = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tenKH")) {
                    session = req.getSession(true);
                    session.setAttribute("tenKH", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }

        req.getRequestDispatcher("/view/client/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("Email");
        String soDT = req.getParameter("SoDT");
        String password = req.getParameter("PassWord");
        String diaChi = req.getParameter("DiaChi");
        String tenKH = req.getParameter("tenKH");
        String roleId = req.getParameter("roleId");

        UserService userService = new UserService();
        String alertMsg="";

        try {
            if (!userService.checkExistEmail_Sdt(email,soDT)){
                alertMsg ="Email hoặc số điện thoại đã được sử dụng. Hãy sử dụng email hoặc số khác";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/view/client/view/register.jsp").forward(req, resp);
            }else {
                userService.register(tenKH,email,soDT,password,diaChi,Integer.parseInt(roleId));
                alertMsg="Đăng ký thành công!";
                req.setAttribute("alert", alertMsg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/login.jsp");
                dispatcher.forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
