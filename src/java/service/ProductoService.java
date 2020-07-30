/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Clase;
import entity.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClaseModel;
import model.ProductoModel;
import util.ViewResolve;

/**
 *
 * @author MELANY
 */
public class ProductoService {

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClaseModel model = new ClaseModel();
        //List<Clase> data = model.listaClase();

        //request.setAttribute("lsClase", data);
        ViewResolve.showMain("producto/index.jsp", request, response);
    }

    public void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String descripcion = request.getParameter("txtDescripcion");
        Double costo = (!request.getParameter("txtcosto").isEmpty())?Double.parseDouble(request.getParameter("txtcosto")):0;
        Double preciov = (!request.getParameter("txtprecio").isEmpty())?Double.parseDouble(request.getParameter("txtprecio")):0;
        int stkmin = (!request.getParameter("txtstkmin").isEmpty())?Integer.parseInt(request.getParameter("txtstkmin")):0;
        int stkmax = (!request.getParameter("txtstkmax").isEmpty())?Integer.parseInt(request.getParameter("txtstkmax")):0;
        Double peso = (!request.getParameter("txtstkmax").isEmpty())?Double.parseDouble(request.getParameter("txtpeso")):0;
        String estado = request.getParameter("txtestado");
        
        /*
        descripcion=(descripcion!=null)?descripcion.toUpperCase():descripcion;
        costo=(costo!=null)?costo.toUpperCase():costo;
        preciov=(material!=null)?material.toUpperCase():material;
        stkmin=(tamanio!=null)?tamanio.toUpperCase():tamanio;
        stkmax=(color!=null)?color.toUpperCase():color;
        */
        Producto p = new Producto();
        p.setDescripcion(descripcion);
        p.setCosto(costo);
        p.setPreciov(preciov);
        p.setStkmin(stkmin);
        p.setStkmax(stkmax);
        p.setPeso(peso);
        p.setEstado(estado);

        ProductoModel pm = new ProductoModel();
        pm.insertProducto(p);

        PrintWriter out = response.getWriter();

        out.println("{\"estado\":\"OK\",\"mensaje\":\"Se guardo correctamente\"}");

    }

    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoModel mo = new ProductoModel();
        List<Producto> data = mo.listaproductos();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        ViewResolve.show("producto/listaProducto.jsp", request, response);
        /*
        String descripcion = request.getParameter("txtBusDescripcion");
        String marca = request.getParameter("txtMarca");
        String material = request.getParameter("txtBusMaterial");
        String clase = request.getParameter("sltBusClasificacion");
        Integer idcla = null;
        if (clase != null && !clase.equals("")) {
            idcla = Integer.parseInt(clase);
        }

        descripcion=(descripcion!=null)?descripcion.toUpperCase():descripcion;
        forma=(forma!=null)?forma.toUpperCase():forma;
        material=(material!=null)?material.toUpperCase():material;

        
        Producto p = new Producto();
        p.setDescripcion(descripcion);
        p.setForma(forma);
        p.setMaterial(material);
        p.setIdClase(idcla);

        ProductoModel model = new ProductoModel();
        List<Producto> data = model.listaProducto(p);

        request.setAttribute("lsProducto", data);

        //request.getRequestDispatcher("/view/producto/listaProducto.jsp").forward(request, response);
        ViewResolve.show("producto/listaProducto.jsp", request, response);

    */
    }
    
    public void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("txtDescripcion");
        Double costo = Double.parseDouble(request.getParameter("txtcosto"));
        Double preciov = Double.parseDouble(request.getParameter("txtprecio"));
        int stkmin = Integer.parseInt(request.getParameter("txtstkmin"));
        int stkmax = Integer.parseInt(request.getParameter("txtstkmax"));
        Double peso = Double.parseDouble(request.getParameter("txtpeso"));
        String estado = request.getParameter("txtestado");
        int id = Integer.parseInt(request.getParameter("id"));
        /*
        String descripcion = request.getParameter("txtDescripcion");
        String forma = request.getParameter("txtForma");
        String material = request.getParameter("txtMaterial");
        String tamanio = request.getParameter("txtTamanio");
        String color = request.getParameter("txtColor");
        String clase = request.getParameter("sltClasificacion");
        int id = Integer.parseInt(request.getParameter("id"));
        
        descripcion=(descripcion!=null)?descripcion.toUpperCase():descripcion;
        forma=(forma!=null)?forma.toUpperCase():forma;
        material=(material!=null)?material.toUpperCase():material;
        tamanio=(tamanio!=null)?tamanio.toUpperCase():tamanio;
        color=(color!=null)?color.toUpperCase():color;
        */
        Producto p = new Producto();
        p.setProducto(id);
        p.setDescripcion(descripcion);
        p.setCosto(costo);
        p.setPreciov(preciov);
        p.setStkmin(stkmin);
        p.setStkmax(stkmax);
        p.setPeso(peso);
        p.setEstado(estado);
        //p.set(Integer.parseInt(clase));

        ProductoModel pm = new ProductoModel();
        //pm.actualizarProdcuto(p);
        pm.actualizaProducto(p);

        PrintWriter out = response.getWriter();

        out.println("{\"estado\":\"OK\",\"mensaje\":\"Se guardo correctamente\"}");
        

    }
    
    
    public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        request.setAttribute("metodo", new String("registra"));
        if (id != null && !id.isEmpty()) {
            ProductoModel model = new ProductoModel();
            Producto a = model.buscaProducto(Integer.parseInt(id));

            request.setAttribute("metodo", new String("actualiza"));
            request.setAttribute("dataProd", a);

        }

        //ClaseModel model = new ClaseModel();
        //List<Clase> data = model.listaClase();

        //request.setAttribute("lsClase", data);

        ViewResolve.show("producto/MProducto.jsp", request, response);
    }
    
    public void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (!id.isEmpty()) {
            ProductoModel model = new ProductoModel();
            model.eliminarProducto(Integer.parseInt(id));

            PrintWriter out = response.getWriter();

            out.println("{\"estado\":\"OK\",\"mensaje\":\"Se elimino correctamente\"}");
        }
        //lista(request, response);
    }
    /*
    public void ubica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("txtDescripcion");
        Double costo = Double.parseDouble(request.getParameter("txtcosto"));
        Double preciov = Double.parseDouble(request.getParameter("txtpreciov"));
        int stkmin = Integer.parseInt(request.getParameter("txtstkmin"));
        int stkmax = Integer.parseInt(request.getParameter("txtstkmax"));
        Double peso = Double.parseDouble(request.getParameter("txtpeso"));
        String estado = request.getParameter("txtestado");
        
        Producto p = new Producto();
        p.setDescripcion(descripcion);
        p.setCosto(costo);
        p.setPreciov(preciov);
        p.setStkmin(stkmin);
        p.setStkmax(stkmax);
        p.setPeso(peso);
        p.setEstado(estado);
        
        ProductoModel model = new ProductoModel();
        List<Producto> data = model.listaproductos();
        
        //Se almacena en memoria llamada request
        request.setAttribute("data", data);
        
        //Se reenvia el request (con los datos) al jsp listaProveedor.jsp
        ViewResolve.showMain("proveedor/listaProveedor.jsp", request, response);
    }*/
}
