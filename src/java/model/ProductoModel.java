/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

/**
 *
 * @author MELANY
 */
public class ProductoModel {

    public int insertProducto(Producto p) {
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into productos (id_producto,prd_descripcion,prd_costo,prd_precio,prd_stkmin,prd_stkmax,prd_peso,prd_estado)values(null,?,?,?,?,?,?,?)";
            
            
            
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getDescripcion());
            pstm.setDouble(2, p.getCosto());
            pstm.setDouble(3, p.getPreciov());
            pstm.setInt(4, p.getStkmin());
            pstm.setInt(5, p.getStkmax());
            pstm.setDouble(6, p.getPeso());
            pstm.setString(7, p.getEstado());
            salida = pstm.executeUpdate();
            /*
            pstm.setString(2, p.getTamanio());
            pstm.setString(3, p.getColor());
            pstm.setString(4, p.getForma());
            pstm.setString(5, p.getMaterial());
            pstm.setInt(6, p.getIdClase());
            salida = pstm.executeUpdate();
            */
        } catch (SQLException ex) {
            Logger.getLogger(ProductoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    //metodo listar
    public ArrayList<Producto> listaproductos(){
        ArrayList<Producto> prod = new ArrayList<>();
        try{
           PreparedStatement pstm;
           Connection conn;
           conn = MysqlDBConexion.getConexion();
           ResultSet rs;
           String sql = "select * from productos";
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           Producto p;
            while(rs.next()){
                p = new Producto();
                p.setProducto(rs.getInt("id_producto"));
                p.setDescripcion(rs.getString("prd_descripcion"));
                p.setUndmed(rs.getInt("id_undmed"));
                p.setMarca(rs.getInt("id_marca"));
                p.setTipinv(rs.getInt("id_tipinv"));
                p.setCosto(rs.getDouble("prd_costo"));
                p.setPreciov(rs.getDouble("prd_precio"));
                p.setStkmin(rs.getInt("prd_stkmin"));
                p.setStkmax(rs.getInt("prd_stkmax"));
                p.setPeso(rs.getDouble("prd_peso"));
                p.setEstado(rs.getString("prd_estado"));
                prod.add(p);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(prod);
        return prod;
    }
    
    /*
    public List<Producto> listaProducto(Producto p) {

        List<Producto> data = new ArrayList<>();
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select p.*,c.descripcion as nom_clase\n"
                    + "from producto p\n"
                    + "inner join clase c on p.id_clase=c.id_clase\n"
                    + "where 1=1 ";

            if (p.getDescripcion() != null && p.getDescripcion() != "") {
                sql += " and p.descripcion like '%" + p.getDescripcion() + "%'";
            }
            if (p.getForma() != null && p.getForma() != "") {
                sql += " and p.forma like '%" + p.getForma() + "%'";
            }
            if (p.getMaterial() != null && p.getMaterial() != "") {
                sql += " and p.material like '%" + p.getMaterial() + "%'";
            }
            if (p.getIdClase() != null && p.getIdClase() != 0) {
                sql += " and p.id_clase=" + p.getIdClase();
            }
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            Producto regProd;

            while (rs.next()) {
                regProd = new Producto();
                regProd.setIdProducto(rs.getInt("id_producto"));
                regProd.setDescripcion(rs.getString("descripcion"));
                regProd.setForma(rs.getString("forma"));
                regProd.setMaterial(rs.getString("material"));
                regProd.setTamanio(rs.getString("tamanio"));
                regProd.setColor(rs.getString("color"));
                regProd.setIdClase(rs.getInt("id_clase"));
                regProd.setNomClase(rs.getString("nom_clase"));
                data.add(regProd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }
    */
    //actualizar producto
    public int actualizaProducto(Producto p) {
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update  productos set prd_descripcion=?, prd_costo=?, prd_precio=?, prd_stkmin=?, prd_stkmax=?, prd_peso=?,prd_estado=? where id_producto=?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, p.getDescripcion());
            pstm.setDouble(2, p.getCosto());
            pstm.setDouble(3, p.getPreciov());
            pstm.setInt(4, p.getStkmin());
            pstm.setInt(5, p.getStkmax());
            pstm.setDouble(6, p.getPeso());
            pstm.setString(7, p.getEstado());
            pstm.setInt(8, p.getProducto());
            salida = pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //buscar
    public Producto buscaProducto(int id) {

        Producto p = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from productos where id_producto=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                p = new Producto();
                p.setProducto(rs.getInt("id_producto"));
                p.setDescripcion(rs.getString("prd_descripcion"));
                p.setCosto(rs.getDouble("prd_costo"));
                p.setPreciov(rs.getDouble("prd_precio"));
                p.setStkmin(rs.getInt("prd_stkmin"));
                p.setStkmax(rs.getInt("prd_stkmax"));
                p.setPeso(rs.getDouble("prd_peso"));
                p.setEstado(rs.getString("prd_estado"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }
    //eliminar
    public int eliminarProducto(int id) {
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from productos where id_producto=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            salida = pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
