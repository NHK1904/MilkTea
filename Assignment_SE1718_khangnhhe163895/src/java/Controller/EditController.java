/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author khang
 */
public class EditController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String pid = req.getParameter("id");
        String pname = req.getParameter("name");
        String pimage = req.getParameter("image");
        String pprice = req.getParameter("price");
        String ptitle = req.getParameter("title");
        String pdescription = req.getParameter("description");
        String pcategory = req.getParameter("category");
        
        Product p = new Product();
        p.editProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, pid);
        resp.sendRedirect("manager");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        String pid = req.getParameter("id");
//        String pname = req.getParameter("name");
//        String pimage = req.getParameter("image");
//        String pprice = req.getParameter("price");
//        String ptitle = req.getParameter("title");
//        String pdescription = req.getParameter("description");
//        String pcategory = req.getParameter("category");
//        
//        Product p = new Product();
//        p.editProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, pid);
//        resp.sendRedirect("manager");

    }
    
    
}
