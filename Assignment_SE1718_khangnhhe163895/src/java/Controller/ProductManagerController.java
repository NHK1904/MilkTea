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

/**
 *
 * @author khang
 */
public class ProductManagerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Account a = (Account) session.getAttribute("acc");
//        String selid = a.getId();
//        
//        Product p = new Product();
//        
//        ArrayList<Product> list = p.getListProductSell(selid);
//        
//        req.setAttribute("list", list);
//        req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account a = (Account) session.getAttribute("acc");
        String selid = a.getId();
        Category c = new Category();
        
        Product p = new Product();
        
        ArrayList<Category> cate = c.getListCategory();
        ArrayList<Product> list = p.getListProductSell(selid);
        req.setAttribute("cate", cate);
        req.setAttribute("list", list);
        req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }

}
