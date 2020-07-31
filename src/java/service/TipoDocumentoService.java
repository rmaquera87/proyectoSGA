/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.TipoDocumento;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoDocumentoModel;
import util.ViewResolve;


public class TipoDocumentoService {
    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
//        int indicador = Integer.parseInt(request.getParameter("indicador"));
 
        
        //Se crea el objeto Tipo Documento
        TipoDocumento a = new TipoDocumento();
        a.setTdo_descripcion(descripcion);
        a.setTdo_abreviatura(abreviatura);
//        a.setTdo_induso(indicador);
    

        //Se inserta a la BD el Tipo Documento
        TipoDocumentoModel model = new TipoDocumentoModel();
        model.insertarTipoDoc(a);
        
        //Se lista todos los Tipo Documentos 
        lista(request, response);
        
    }
    
    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoDocumentoModel model = new TipoDocumentoModel();
        List<TipoDocumento> data = model.listaTipoDoc();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("tipoDocumento/listaTipoDocumento.jsp", request, response);
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
//        int indicador = Integer.parseInt(request.getParameter("indicador"));
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Se crea el objeto TipoDocumento
        TipoDocumento a = new TipoDocumento();
        a.setId_tipdoc(id);
        a.setTdo_descripcion(descripcion);
        a.setTdo_abreviatura(abreviatura);
//        a.setTdo_induso(indicador);

        
        //Se inserta a la BD el TipoDocumento
        TipoDocumentoModel model = new TipoDocumentoModel();
        model.actualizaTipoDoc(a);
        
        //Se lista todos los TipoDocumento
        lista(request, response);
    }
    
    public void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se inserta a la BD el proveedor
        TipoDocumentoModel model = new TipoDocumentoModel();
        TipoDocumento a = model.buscaTipoDoc(Integer.parseInt(id));
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", a);
        
        //Se reenvia el request (con los datos) al jsp listaAlumno.jsp
        ViewResolve.showMain("tipoDocumento/actualizaTipoDocumento.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        
        //Se elimina
        TipoDocumentoModel model = new TipoDocumentoModel();
        model.eliminaTipoDocId(Integer.parseInt(id));
        //Se lista
        lista(request, response);
    } 
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        String abreviatura = request.getParameter("abreviatura");
    //    int indicador = Integer.parseInt(request.getParameter("indicador"));
        
        TipoDocumento p = new TipoDocumento();
        p.setTdo_descripcion(descripcion);
        p.setTdo_abreviatura(abreviatura);

        TipoDocumentoModel model = new TipoDocumentoModel();
        List<TipoDocumento> data = model.listaUbicaTipoDocId(p);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("tipoDocumento/listaTipoDocumento.jsp", request, response);
    }
}
