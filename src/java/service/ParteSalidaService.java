/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.ClienteDAO;
import dao.KardexDetalleDAO;
import dao.KardexCabeceraDAO;
import dao.MotivoMovimientoDAO;
import dto.ClienteDTO;
import dto.KardexCabeceraDTO;
import dto.KardexDetalleDTO;
import dto.MotivoMovimientoDTO;
import entity.Almacen;
import entity.Clase;
import entity.Producto;
import entity.Proveedor;
import entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AlmacenModel;
import model.ClaseModel;
import model.ProductoModel;
import model.ProveedorModel;
import util.ViewResolve;

/**
 *
 * @author MELANY
 */
public class ParteSalidaService {

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AlmacenModel almacenModel = new AlmacenModel();
        List<Almacen> dataAlmacen = almacenModel.listaAlmacen();

        request.setAttribute("lsAlmacen", dataAlmacen);

        MotivoMovimientoDAO motivoDAO = new MotivoMovimientoDAO();
        List<MotivoMovimientoDTO> dataMotivo = motivoDAO.listarMotivo();
        request.setAttribute("lsMotivo", dataMotivo);

        /*ProveedorModel proveedorModel = new ProveedorModel();
        List<Proveedor> dataProveedor = proveedorModel.listaProveedor();
        request.setAttribute("lsProveedor", dataProveedor);*/

        ClienteDAO clienteDAO = new ClienteDAO();
        List<ClienteDTO> clienteDTO = clienteDAO.listar();
        request.setAttribute("lsCliente", clienteDTO);
        
        ViewResolve.showMain("parteSalida/index.jsp", request, response);
    }

    public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        request.setAttribute("metodo", new String("registra"));
        if (id != null && !id.isEmpty()) {
            KardexCabeceraDAO kcDAO = new KardexCabeceraDAO();
            KardexCabeceraDTO a = kcDAO.buscaKardex(Integer.parseInt(id));

            request.setAttribute("metodo", new String("actualiza"));
            request.setAttribute("dataParte", a);

        }

        AlmacenModel almacenModel = new AlmacenModel();
        List<Almacen> dataAlmacen = almacenModel.listaAlmacen();

        request.setAttribute("lsAlmacen", dataAlmacen);

        MotivoMovimientoDAO motivoDAO = new MotivoMovimientoDAO();
        List<MotivoMovimientoDTO> dataMotivo = motivoDAO.listarMotivo();
        request.setAttribute("lsMotivo", dataMotivo);

        //ProveedorModel proveedorModel = new ProveedorModel();
        //List<Proveedor> dataProveedor = proveedorModel.listaProveedor();
        //request.setAttribute("lsProveedor", dataProveedor);

        ClienteDAO clienteDAO = new ClienteDAO();
        List<ClienteDTO> clienteDTO = clienteDAO.listar();
        request.setAttribute("lsCliente", clienteDTO);
        
        ProductoModel productoModel = new ProductoModel();
        List<Producto> dataProducto = productoModel.listaProductoMin();
        request.setAttribute("lsProducto", dataProducto);

        request.setAttribute("lsKardexDetalle", null);

        ViewResolve.show("parteSalida/MParteSalida.jsp", request, response);
    }

    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String fecha = request.getParameter("fecha");
            int almacen = (request.getParameter("cboAlmacen") != null) ? Integer.parseInt(request.getParameter("cboAlmacen")) : null;
            int motivo = (request.getParameter("cboMotivo") != null) ? Integer.parseInt(request.getParameter("cboMotivo")) : null;
            int cliente = (request.getParameter("cboCliente") != null) ? Integer.parseInt(request.getParameter("cboCliente")) : null;
            String tipDocRef = request.getParameter("cboTipDocRef");
            String nroDocRef = request.getParameter("txtNroDocRef");
            String glosa = request.getParameter("txtGlosa");
            String dataDetalle = request.getParameter("detalle");

            HttpSession session = (HttpSession) request.getSession();
            Usuarios sesionSGA = (Usuarios) session.getAttribute("sesionSGA");

            SimpleDateFormat strDate = new SimpleDateFormat("dd/MM/yyyy");
            Date dateFecha = strDate.parse(fecha);

            SimpleDateFormat dateStr = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = dateStr.format(dateFecha);

            System.out.println(strFecha);

            KardexCabeceraDTO kc = new KardexCabeceraDTO();
            kc.setIdAlmacen(almacen);
            kc.setIdTdo(4);
            kc.setIdMotivo(motivo);
            kc.setKacTdoref1(tipDocRef);
            kc.setKacDocref1(nroDocRef);
            kc.setIdCliente(cliente);
            kc.setKacFecha(strFecha);
            kc.setKacGlosa(glosa);
            kc.setIdUsuario(sesionSGA.getIdUsuario());

            KardexCabeceraDAO kcDAO = new KardexCabeceraDAO();
            int ultReg = kcDAO.insertar(kc);

            Gson gson = new Gson();

            Type tipoListaDetalle = new TypeToken<List<Properties>>() {
            }.getType();
            List<Properties> lsDetalle = gson.fromJson(dataDetalle, tipoListaDetalle);

            for (Properties pr : lsDetalle) {

                KardexDetalleDTO kdDTO = new KardexDetalleDTO();
                kdDTO.setIdKdxcab(ultReg);
                kdDTO.setIdProducto(Integer.parseInt(pr.getProperty("idprod")));
                kdDTO.setKadCantidad(Integer.parseInt(pr.getProperty("cant")));
                kdDTO.setIdUsuario(sesionSGA.getIdUsuario());
                KardexDetalleDAO kdDAO = new KardexDetalleDAO();
                kdDAO.insertarParteIngDet(kdDTO);
            }

            PrintWriter out = response.getWriter();

            out.println("{\"estado\":\"OK\",\"mensaje\":\"Se guardo correctamente\"}");
        } catch (ParseException ex) {
            Logger.getLogger(ParteSalidaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listaDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {

            KardexDetalleDAO kcDAO = new KardexDetalleDAO();

            //if (id > 0) {
            List<KardexDetalleDTO> data = kcDAO.listaKardexDetalle(Integer.parseInt(id));

            //request.setAttribute("lsKardexDetalle", data);
            request.setAttribute("lsKardexDetalle", "");
            //}

            //request.getRequestDispatcher("/view/producto/listaProducto.jsp").forward(request, response);
            //ViewResolve.show("parteIngreso/listaMParteIngreso.jsp", request, response);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String json = new Gson().toJson(data);
            PrintWriter out = response.getWriter();
            out.println("{\"estado\":\"OK\",\"result\":" + json + "}");
            //out.println(json);
            out.flush();
        }

    }

    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String fecha = request.getParameter("txtBusFecha");
            int almacen = (request.getParameter("cboBusAlmacen") != null) ? Integer.parseInt(request.getParameter("cboBusAlmacen")) : null;
            int motivo = (request.getParameter("cboBusMotivo") != null) ? Integer.parseInt(request.getParameter("cboBusMotivo")) : null;
            int cliente = (request.getParameter("cboBusCliente") != null) ? Integer.parseInt(request.getParameter("cboBusCliente")) : null;
            String strFecha = "";
            if (!fecha.equals("")) {
                SimpleDateFormat strDate = new SimpleDateFormat("dd/MM/yyyy");
                Date dateFecha = strDate.parse(fecha);

                SimpleDateFormat dateStr = new SimpleDateFormat("yyyy-MM-dd");
                strFecha = dateStr.format(dateFecha);
            }

            KardexCabeceraDTO kcDTO = new KardexCabeceraDTO();
            kcDTO.setKacFecha(strFecha);
            kcDTO.setIdAlmacen(almacen);
            kcDTO.setIdMotivo(motivo);
            kcDTO.setIdCliente(cliente);
            kcDTO.setIdTdo(4);

            KardexCabeceraDAO kardexCabeceraDAO = new KardexCabeceraDAO();
            List<KardexCabeceraDTO> data = kardexCabeceraDAO.listaKardex(kcDTO);

            request.setAttribute("lsParte", data);

            //request.getRequestDispatcher("/view/producto/listaProducto.jsp").forward(request, response);
            ViewResolve.show("parteSalida/listaParteSalida.jsp", request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ParteSalidaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fecha = request.getParameter("fecha");
            int almacen = (request.getParameter("cboAlmacen") != null) ? Integer.parseInt(request.getParameter("cboAlmacen")) : null;
            int motivo = (request.getParameter("cboMotivo") != null) ? Integer.parseInt(request.getParameter("cboMotivo")) : null;
            int cliente = (request.getParameter("cboCliente") != null) ? Integer.parseInt(request.getParameter("cboCliente")) : null;
            String tipDocRef = request.getParameter("cboTipDocRef");
            String nroDocRef = request.getParameter("txtNroDocRef");
            String glosa = request.getParameter("txtGlosa");
            String dataDetalle = request.getParameter("detalle");
            int id = Integer.parseInt(request.getParameter("id"));

            HttpSession session = (HttpSession) request.getSession();
            Usuarios sesionSGA = (Usuarios) session.getAttribute("sesionSGA");

            SimpleDateFormat strDate = new SimpleDateFormat("dd/MM/yyyy");
            Date dateFecha = strDate.parse(fecha);

            SimpleDateFormat dateStr = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = dateStr.format(dateFecha);

            KardexCabeceraDTO kc = new KardexCabeceraDTO();
            kc.setIdKdxcab(id);
            kc.setIdAlmacen(almacen);
            kc.setIdMotivo(motivo);
            kc.setKacTdoref1(tipDocRef);
            kc.setKacDocref1(nroDocRef);
            kc.setIdCliente(cliente);
            kc.setKacFecha(strFecha);
            kc.setKacGlosa(glosa);

            KardexCabeceraDAO kcDAO = new KardexCabeceraDAO();
            kcDAO.actualizar(kc);

            Gson gson = new Gson();

            Type tipoListaDetalle = new TypeToken<List<Properties>>() {
            }.getType();
            List<Properties> lsDetalle = gson.fromJson(dataDetalle, tipoListaDetalle);

            if (lsDetalle.size() > 0) {
                KardexDetalleDAO kdDAO = new KardexDetalleDAO();
                kdDAO.eliminar(id);

                for (Properties pr : lsDetalle) {

                    KardexDetalleDTO kdDTOIns = new KardexDetalleDTO();
                    kdDTOIns.setIdKdxcab(id);
                    kdDTOIns.setIdProducto(Integer.parseInt(pr.getProperty("idprod")));
                    kdDTOIns.setKadCantidad(Integer.parseInt(pr.getProperty("cant")));
                    kdDTOIns.setIdUsuario(sesionSGA.getIdUsuario());
                    KardexDetalleDAO kdDAOIns = new KardexDetalleDAO();
                    kdDAOIns.insertarParteIngDet(kdDTOIns);
                }
            }

            PrintWriter out = response.getWriter();

            out.println("{\"estado\":\"OK\",\"mensaje\":\"Se guardo correctamente\"}");
        } catch (ParseException ex) {
            Logger.getLogger(ParteSalidaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (!id.isEmpty()) {
            
            KardexDetalleDAO kdDAO = new KardexDetalleDAO();
            kdDAO.eliminar(Integer.parseInt(id));
            
            KardexCabeceraDAO kcDAO = new KardexCabeceraDAO();
            kcDAO.eliminar(Integer.parseInt(id));
            
            PrintWriter out = response.getWriter();

            out.println("{\"estado\":\"OK\",\"mensaje\":\"Se elimino correctamente\"}");
        }

    }
}
