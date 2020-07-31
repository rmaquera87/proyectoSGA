/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Marca;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MarcaModel;
import util.ViewResolve;


public class MarcaService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        
        String descripcion = request.getParameter("descripcion");
//        String direccion = request.getParameter("direccion");
 
        
        //Se crea el objeto marca
        Marca a = new Marca();
        a.setMrc_descripcion(descripcion);
//        a.setDireccion(direccion);
    

        //Se inserta a la BD la marca
       MarcaModel model = new MarcaModel();
        model.insertarAlmacen(a);
        
        //Se lista todos los proveedores
        lista(request, response);
        
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MarcaModel model = new MarcaModel();
        List<Marca> data = model.listaMarca();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("marca/listarMarca.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String descripcion = request.getParameter("descripcion");
//        String direccion = request.getParameter("direccion");
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto marca
        Marca a = new Marca();
        a.setId_marca(id);
        a.setMrc_descripcion(descripcion);
//        a.setDireccion(direccion);

        
        //Se inserta a la BD el proveedor
        MarcaModel model = new MarcaModel();
        model.actualizaAlmacen(a);
        
        //Se lista todos los proveedores
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el proveedor
        MarcaModel model = new MarcaModel();
        Marca a = model.buscaMarca(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("marca/actualizaMarca.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        MarcaModel model = new MarcaModel();
        model.eliminaMarca(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
//        String direccion = request.getParameter("direccion");
        
        Marca p = new Marca();
        p.setMrc_descripcion(descripcion);
//        p.setDireccion(direccion);

        MarcaModel model = new MarcaModel();
        List<Marca> data = model.listaUbicaMarca(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("marca/listarMarca.jsp", request, response);
    }
    
}
