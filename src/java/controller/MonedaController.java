/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MonedaService;

/**
 *
 * @author VAIO
 */
@WebServlet(name = "moneda", urlPatterns = {"/moneda"})
public class MonedaController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MonedaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MonedaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metodo = request.getParameter("metodo");
        MonedaService monedaService= new MonedaService();
        
        if (metodo==null) {
          monedaService.lista(request, response);
        }else if (metodo.equals("registra")) {
            monedaService.registra(request, response);
        }else if (metodo.equals("lista")) {
            monedaService.lista(request, response);
        }else if (metodo.equals("actualiza")) {
            monedaService.actualiza(request, response);
        }else if (metodo.equals("busca")) {
            monedaService.busca(request, response);
        }else if (metodo.equals("elimina")) {
            monedaService.elimina(request, response);
        }else if (metodo.equals("ubica")) {
            monedaService.ubica(request, response); 
        }
 
    }
}
