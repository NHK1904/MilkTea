/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Account;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author khang
 */
public class AddController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        String price = req.getParameter("price");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        HttpSession session = req.getSession();
        Account a = (Account) session.getAttribute("acc");
        String sid = a.getId();
        Product p = new Product();

        if (price.matches("\\d+") && isValidImageUrl(image)) {
            p.addProduct(name, image, price, title, description, category, sid);
            resp.sendRedirect("manager");

        } else {
            if (price.matches("\\d+")) {
                String messs = "image phai la duong link image";
                req.setAttribute("messss", messs);
                req.getRequestDispatcher("Erroll.jsp").forward(req, resp);
            } else if(isValidImageUrl(image)){
                
                String messs = "Price phai la so";
                req.setAttribute("messss", messs);
                req.getRequestDispatcher("Erroll.jsp").forward(req, resp);
            }else{
                String messs = "Price phai la so,image phai la duong link image";
                req.setAttribute("messss", messs);
                req.getRequestDispatcher("Erroll.jsp").forward(req, resp);
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String image = req.getParameter("image");
//        String price = req.getParameter("price");
//        String title = req.getParameter("title");
//        String description = req.getParameter("description");
//        String category = req.getParameter("category");
//        HttpSession session = req.getSession();
//        Account a = (Account) session.getAttribute("acc");
//        String sid = a.getId();
//
//        Product p = new Product();
//
//        p.addProduct(name, image, price, title, description, category, sid);
//        resp.sendRedirect("manager");
    }

    public boolean isValidImageUrl(String imageUrl) {
        String[] allowedExtensions = {"jpg", "jpeg", "png", "gif"};
        for (String extension : allowedExtensions) {
            if (imageUrl.toLowerCase().endsWith("." + extension)) {
                return true;
            }
        }
        return false;
    }

}
