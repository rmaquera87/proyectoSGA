/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Usuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MELANY
 */
public class ViewResolve {
    public static void showMain(String nameView, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session= (HttpSession) request.getSession();
        Usuarios sesionSGA= (Usuarios) session.getAttribute("sesionSGA");
        request.setAttribute("dataMain", sesionSGA);
        
        request.setAttribute("view", new String("/view/" + nameView));
        request.getRequestDispatcher("/template/layout.jsp").forward(request, response);

    }
    public static void show(String nameView, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/view/" + nameView).forward(request, response);

    }

    public static Object show(String proveedorlistaProveedorjsp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void showMain(String proveedorinsertarProveedorjsp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
