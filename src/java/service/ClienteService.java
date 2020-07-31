/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteModel;
import util.ViewResolve;

public class ClienteService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        int tipodoc = Integer.parseInt(request.getParameter("tipodoc"));
        String nrodoc = request.getParameter("nrodoc");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String razonSocial = request.getParameter("razonSocial");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        //Se crea el objeto cliente
        Cliente a = new Cliente();
        a.setId_tipodoc(tipodoc);
        a.setCli_nrodoc(nrodoc);
        a.setCli_nombres(nombres);
        a.setCli_apellidos(apellidos);
        a.setCli_rzasoc(razonSocial);
        a.setCli_direccion(direccion);
        a.setCli_telefono(telefono);
        a.setCli_email(email);

        //Se inserta a la BD el cliente
        ClienteModel model = new ClienteModel();
        model.insertarCliente(a);
        
        //Se lista todos los proveedores
        lista(request, response);     
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteModel model = new ClienteModel();
        List<Cliente> data = model.listaCliente();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("cliente/listaCliente.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String nrodoc = request.getParameter("nrodoc");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String razonSocial = request.getParameter("razonSocial");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto cliente
        Cliente a = new Cliente();
        a.setId_cliente(id);
        a.setCli_nrodoc(nrodoc);
        a.setCli_nombres(nombres);
        a.setCli_apellidos(apellidos);
        a.setCli_rzasoc(razonSocial);
        a.setCli_direccion(direccion);
        a.setCli_telefono(telefono);
        a.setCli_email(email);
        
        //Se inserta a la BD el cliente
        ClienteModel model = new ClienteModel();
        model.actualizaCliente(a);
        
        //Se lista todos los cliente
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el cliente
        ClienteModel model = new ClienteModel();
        Cliente a = model.buscaCliente(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("cliente/actualizaCliente.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        ClienteModel model = new ClienteModel();
        model.eliminaCliente(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nrodoc = request.getParameter("nrodoc");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String razonSocial = request.getParameter("razonSocial");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        Cliente p = new Cliente();
        p.setCli_nrodoc(nrodoc);
        p.setCli_nombres(nombres);
        p.setCli_apellidos(apellidos);
        p.setCli_rzasoc(razonSocial);
        p.setCli_direccion(direccion);
        p.setCli_telefono(telefono);
        p.setCli_email(email);
        ClienteModel model = new ClienteModel();
        List<Cliente> data = model.listaUbicaCliente(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("cliente/listaCliente.jsp", request, response);
    }
}
