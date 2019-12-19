package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("account")!= null)
        {
            User user =(User)session.getAttribute("account");
            req.setAttribute("tenKH",user.getTenKH());
            if (user.getRoleID()!=0)
            {
                resp.sendRedirect(req.getContextPath()+"/admin");
            }else {
                resp.sendRedirect(req.getContextPath()+"/welcome");
            }
        }

    }
}
