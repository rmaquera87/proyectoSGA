/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.TipoDocId;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoDocIdModel;
import util.ViewResolve;

public class TipoDocIdService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
 
        
        //Se crea el objeto Tipo Documento de identidad
        TipoDocId a = new TipoDocId();
        a.setTdi_descripcion(descripcion);
        a.setTdi_abreviatura(abreviatura);
    

        //Se inserta a la BD el Tipo Documento de identidad
        TipoDocIdModel model = new TipoDocIdModel();
        model.insertarAlmacen(a);
        
        //Se lista todos los Tipo Documentos de identidad
        lista(request, response);
        
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoDocIdModel model = new TipoDocIdModel();
        List<TipoDocId> data = model.listaTipoDocId();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("tipoDocId/listaTipoDocId.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto TipoDocId
        TipoDocId a = new TipoDocId();
        a.setId_tipodoc(id);
        a.setTdi_descripcion(descripcion);
        a.setTdi_abreviatura(abreviatura);

        
        //Se inserta a la BD el TipoDocId
        TipoDocIdModel model = new TipoDocIdModel();
        model.actualizaTipoDocId(a);
        
        //Se lista todos los TipoDocId
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el proveedor
        TipoDocIdModel model = new TipoDocIdModel();
        TipoDocId a = model.buscaTipoDocId(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("tipoDocId/actualizaTipoDocId.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        TipoDocIdModel model = new TipoDocIdModel();
        model.eliminaTipoDocId(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
        
        TipoDocId p = new TipoDocId();
        p.setTdi_descripcion(descripcion);
        p.setTdi_abreviatura(abreviatura);

        TipoDocIdModel model = new TipoDocIdModel();
        List<TipoDocId> data = model.listaUbicaTipoDocId(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("tipoDocId/listaTipoDocId.jsp", request, response);
    }
}
