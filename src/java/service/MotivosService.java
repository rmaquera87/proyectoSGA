/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.MotivoMovimientos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MotivosModel;
import util.ViewResolve;

public class MotivosService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        
        String descripcion = request.getParameter("descripcion");
        
        //Se crea el objeto motivo
        MotivoMovimientos a = new MotivoMovimientos();
        a.setMmo_descripcion(descripcion);

        //Se inserta a la BD la motivo
       MotivosModel model = new MotivosModel();
        model.insertarMotivo(a);
        
        //Se lista todos los proveedores
        lista(request, response);
        
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MotivosModel model = new MotivosModel();
        List<MotivoMovimientos> data = model.listaMotivo();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("motivo/listaMotivo.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String descripcion = request.getParameter("descripcion");
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto motivo
        MotivoMovimientos a = new MotivoMovimientos();
        a.setId_motivo(id);
        a.setMmo_descripcion(descripcion);
        
        //Se inserta a la BD el motivo
        MotivosModel model = new MotivosModel();
        model.actualizaMotivo(a);
        
        //Se lista todos los proveedores
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el proveedor
        MotivosModel model = new MotivosModel();
        MotivoMovimientos a = model.buscaMotivo(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("motivo/actualizaMotivo.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        MotivosModel model = new MotivosModel();
        model.eliminaMotivo(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        
        MotivoMovimientos p = new MotivoMovimientos();
        p.setMmo_descripcion(descripcion);

        MotivosModel model = new MotivosModel();
        List<MotivoMovimientos> data = model.listaUbicaMotivo(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("motivo/listaMotivo.jsp", request, response);
    }
}
