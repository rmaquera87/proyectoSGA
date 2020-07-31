/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Clase;
import entity.Producto;
import entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ClaseModel;
import model.ProductoModel;
import util.ViewResolve;

public class MainService {

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ViewResolve.showMain("main/index.jsp", request, response);
    }

        public void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession misession= (HttpSession) request.getSession();
 
        misession.invalidate();

        response.sendRedirect("login");
        
        System.out.println("cerrando sesion");

    }

}
