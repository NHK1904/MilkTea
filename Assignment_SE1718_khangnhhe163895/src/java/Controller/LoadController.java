/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Category;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author khang
 */
public class LoadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lỗi 23:19 LoadController
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idd = req.getParameter("pid");
        
        Product p =new Product();
        Category c = new Category();
        
        ArrayList<Category> cate = c.getListCategory();
        Product data = p.getListProductid(idd);
        req.setAttribute("cate", cate);
        req.setAttribute("detail", data);
        req.getRequestDispatcher("Edit.jsp").forward(req, resp);
        

    }

}
