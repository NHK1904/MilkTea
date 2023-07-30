/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Category;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author khang
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String text = request.getParameter("txt");
        Product p = new Product();
        ArrayList<Product> search = p.getListProductSearch(text);
        PrintWriter out = response.getWriter();
        for (Product o : search) {
            out.println("<div class=\"col mb-5\" >\n"
                    + "                            <div class=\"card h-100\">\n"
                    + "                                <!-- Product image-->\n"
                    + "                                <img class=\"card-img-top\" src=\"" + o.getImage() + "\" alt=\"...\" />\n"
                    + "                                <!-- Product details-->\n"
                    + "                                <div class=\"card-body p-4\">\n"
                    + "                                    <div class=\"text-center\">\n"
                    + "                                        <!-- Product name-->\n"
                    + "                                        <h5 class=\"card-title show_txt\"><a href=\"detail?pid=${item.getId()}\" title=\"View Product\">" + o.getName() + "</a></h5><br>\n"
                    + "                                        <!-- Product price-->\n"
                    + "                                        $" + o.getPrice() + " \n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <!-- Product actions-->\n"
                    + "                                <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\n"
                    + "                                    <div class=\"text-center\"><a class=\"btn btn-outline-dark mt-auto\" href=\"#\">ADD</a></div>\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "");
        }

//        request.setAttribute("cate", cate);
//        request.setAttribute("data", search);
//        request.getRequestDispatcher("Home.jsp").forward(request, response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
