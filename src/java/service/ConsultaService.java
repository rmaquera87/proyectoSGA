/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.KardexCabeceraDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.KardexCabeceraDAO;
import util.ViewResolve;

/**
 *
 * @author VAIO
 */
public class ConsultaService {
    
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ViewResolve.showMain("consulta/listaConsulta.jsp", request, response);
    }
        
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
//        String razonSocial = request.getParameter("razonSocial");
//        String direccion = request.getParameter("direccion");
//        String telefono = request.getParameter("telefono");
//        String email = request.getParameter("email");
//        String pais = request.getParameter("pais");
//        
        KardexCabeceraDTO k = new KardexCabeceraDTO();
        k.setPrdDescripcion(descripcion);
//        p.setTelefono(telefono);
//        p.setDireccion(direccion);
//        p.setEmail(email);
//        p.setPais(pais);
        KardexCabeceraDAO model = new KardexCabeceraDAO();
        List<KardexCabeceraDTO> data = model.listaConsulta(k);
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("consulta/listaConsulta.jsp", request, response);
    }
    
}
