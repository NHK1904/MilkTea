/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Account;
import Model.Category;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.ws.soap.AddressingFeature;

/**
 *
 * @author khang
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        Account ac = new Account();

        Account a = ac.checkAccount(user,pass);

        if(a != null){
            HttpSession session=req.getSession();
            session.setMaxInactiveInterval(1000);
            session.setAttribute("acc", a);
            resp.sendRedirect("home");
        } else {
            String errol = "Pass word hoac tk sai";
            String erol1 = "Forgot";
            req.setAttribute("errol", errol);
            req.setAttribute("errol1", erol1);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lỗi 23:19 LoginController
    }

}
