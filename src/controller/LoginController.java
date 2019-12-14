package controller;


import model.User;
import servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check session
        HttpSession session = req.getSession(false);
        if (session!=null && session.getAttribute("account")!=null)
        {
            resp.sendRedirect(req.getContextPath()+"/waiting");
            return;
        }

        // check cookies
        Cookie cookies[] = req.getCookies();
        if (cookies!= null )
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("tenKH"))
                {
                    session =req.getSession(true);
                    session.setAttribute("tenKH",cookie.getValue());
                    resp.sendRedirect(req.getContextPath()+"/waiting");
                    return;
                }
            }
        }

        // Neu chua co chuyen sang trang login client

        req.getRequestDispatcher("view/client/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String soDT = req.getParameter("SoDT");
        String passWord = req.getParameter("PassWord");
        String alertMsg ="";
        if (soDT.isEmpty() || passWord.isEmpty()){
            alertMsg ="số điện thoại và password không thể để trống! Xin nhập lại.";
            req.setAttribute("alertMsg",alertMsg);
            req.getRequestDispatcher("view/client/view/login.jsp").forward(req, resp);
            return;
        }

        UserService userService = new UserService();
        try {
            User  user = userService.login(soDT,passWord);
            if (user!=null){
                HttpSession session = req.getSession(true);
                session.setAttribute("account",user);
                resp.sendRedirect(req.getContextPath()+"/waiting");
            }else{
                alertMsg="tài khoản hoặc mật khẩu không đúng, hãy nhập lại.";
                req.setAttribute("alertMsg",alertMsg);
                req.getRequestDispatcher("view/client/view/login.jsp").forward(req, resp);

            }
        } catch (SQLException e) {
            req.setAttribute("alertMsg",alertMsg);
            alertMsg="Đã xảy ra lỗi hệ thống, xin mời đăng nhập lại!";
            req.getRequestDispatcher("view/client/view/login.jsp").forward(req, resp);
            e.printStackTrace();
        }


    }
}
