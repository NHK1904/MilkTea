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
public class CategoryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //Không cần làm gì 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cidd = req.getParameter("cid");
                
        Product p = new Product();
        Category c = new Category();
        
        ArrayList<Category> cate = c.getListCategory();
        ArrayList<Product> data = p.getListProductCid(cidd);
        req.setAttribute("cate", cate);
        req.setAttribute("data", data);
        req.setAttribute("tag", cidd);

        req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }

}
