/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author khang
 */
public class ChangePassController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        String repass = req.getParameter("repass");

        if (pass.equals(repass)) {
            Account a = new Account();
            a.changePass(pass, user);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {

            String mess = "Mat khau khong trung nhau";
            req.setAttribute("mess", mess);

            req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lỗi 42:19 ChangePassController
    }

}
