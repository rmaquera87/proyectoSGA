/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Moneda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MonedaModel;
import util.ViewResolve;

public class MonedaService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        
        String descripcion = request.getParameter("descripcion");
        String simbolo = request.getParameter("simbolo");
 
        
        //Se crea el objeto moneda
        Moneda a = new Moneda();
        a.setTmo_descripcion(descripcion);
        a.setTmo_simbolo(simbolo);
    

        //Se inserta a la BD la moneda
       MonedaModel model = new MonedaModel();
        model.insertarMoneda(a);
        
        //Se lista todos las Unidades de Medida
        lista(request, response);
        
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MonedaModel model = new MonedaModel();
        List<Moneda> data = model.listaMoneda();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("moneda/listaMoneda.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String descripcion = request.getParameter("descripcion");
        String simbolo = request.getParameter("simbolo");
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto Moneda
        Moneda a = new Moneda();
        a.setId_moneda(id);
        a.setTmo_descripcion(descripcion);
        a.setTmo_simbolo(simbolo);

        
        //Se inserta a la BD la undiad de medida
        MonedaModel model = new MonedaModel();
        model.actualizaMoneda(a);
        
        //Se lista todos los proveedores
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el moneda
        MonedaModel model = new MonedaModel();
        Moneda a = model.buscaMoneda(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("moneda/actualizaMoneda.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        MonedaModel model = new MonedaModel();
        model.eliminaMoneda(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        String simbolo = request.getParameter("simbolo");
        
        Moneda p = new Moneda();
        p.setTmo_descripcion(descripcion);
        p.setTmo_simbolo(simbolo);

        MonedaModel model = new MonedaModel();
        List<Moneda> data = model.listaUbicaMoneda(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("moneda/listaMoneda.jsp", request, response);
    }
}
