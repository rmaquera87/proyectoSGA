/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Almacen;
import entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AlmacenModel;
import model.UsuariosModel;
import util.ViewResolve;

public class LoginService {

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.show("login/login.jsp", request, response);
    }
    
    public void loguear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String pass = request.getParameter("pass");


        username=(username!=null)?username.toUpperCase():"";

        Usuarios u = new Usuarios();
        u.setUsuUsername(username);
        u.setUsuPassword(pass);


        UsuariosModel usuariosModel = new UsuariosModel();
        Usuarios userResult=usuariosModel.obtenerUsuario(u);
        
        if(userResult!=null ){
            System.out.println(userResult.getUsuEstado());
            if(userResult.getUsuEstado().equals("A")){
                
                //ViewResolve.show("login/login.jsp", request, response);
                
                HttpSession sesionSGA= request.getSession(false);
                sesionSGA.setAttribute("sesionSGA",userResult);
                
                System.out.println("acceso correcto");
                response.sendRedirect("main");
            }
            
        }else{
            System.out.println("Error en el acceso");
            request.setAttribute("data", "Error en el acceso, vuelva a intentarlo");
            ViewResolve.show("login/login.jsp", request, response);
        }
    }
}
