/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.UniMedida;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UniMedidaModel;
import util.ViewResolve;

public class UniMedidaService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
 
        
        //Se crea el objeto unidad de medida
        UniMedida a = new UniMedida();
        a.setUme_descripcion(descripcion);
        a.setUme_abreviatura(abreviatura);
    

        //Se inserta a la BD la UniMedida
       UniMedidaModel model = new UniMedidaModel();
        model.insertarUme(a);
        
        //Se lista todos las Unidades de Medida
        lista(request, response);
        
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UniMedidaModel model = new UniMedidaModel();
        List<UniMedida> data = model.listaUme();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("unimedida/listaUniMedida.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto UniMedida
        UniMedida a = new UniMedida();
        a.setId_undmed(id);
        a.setUme_descripcion(descripcion);
        a.setUme_abreviatura(abreviatura);

        
        //Se inserta a la BD la undiad de medida
        UniMedidaModel model = new UniMedidaModel();
        model.actualizaUme(a);
        
        //Se lista todos los proveedores
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el proveedor
        UniMedidaModel model = new UniMedidaModel();
        UniMedida a = model.buscaUme(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("unimedida/actualizaUniMedida.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        UniMedidaModel model = new UniMedidaModel();
        model.eliminaUme(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
        
        UniMedida p = new UniMedida();
        p.setUme_descripcion(descripcion);
        p.setUme_abreviatura(abreviatura);

        UniMedidaModel model = new UniMedidaModel();
        List<UniMedida> data = model.listaUbicaUme(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("unimedida/listaUniMedida.jsp", request, response);
    }
    
}
