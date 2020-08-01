/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class ProveedorModel {
    //Metodo insertar
    public int insertarProveedor(Proveedor obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into proveedores values(null,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, obj.getIdTipoDoc());
            pstm.setString(2, obj.getRuc());
            pstm.setString(3, obj.getRazonSocial());
            pstm.setString(4, obj.getDireccion());
            pstm.setString(5, obj.getTelefono());
            pstm.setString(6, obj.getEmail());
            pstm.setString(7, obj.getPais());
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<Proveedor> listaProveedor(){
        ArrayList<Proveedor> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select p.*,tdi.tdi_abreviatura from proveedores p\n" +
                         "left join tipo_documento_identidad tdi on tdi.id_tipodoc=p.id_tipodoc ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Proveedor obj;
            while(rs.next()){
                obj = new Proveedor();
                obj.setIdProveedor(rs.getInt("id_proveedor"));
//                obj.setIdTipoDoc(rs.getInt("id_tipodoc"));
                obj.setTdiAbreviatura(rs.getString("tdi_Abreviatura"));
                obj.setRuc(rs.getString("pro_nrodoc"));
                obj.setRazonSocial(rs.getString("pro_razsoc"));
                obj.setDireccion(rs.getString("pro_direccion"));
                obj.setTelefono(rs.getString("pro_telefono"));
                obj.setEmail(rs.getString("pro_email"));
                obj.setPais(rs.getString("pro_pais"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(data);
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaProveedor(Proveedor obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update proveedores set pro_nrodoc=?,pro_razsoc=?, pro_direccion=?,pro_telefono=?, pro_email=?, pro_pais=? where id_proveedor=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getRuc());
            pstm.setString(2, obj.getRazonSocial());
            pstm.setString(3, obj.getDireccion());
            pstm.setString(4, obj.getTelefono());
            pstm.setString(5, obj.getEmail());
            pstm.setString(6, obj.getPais());
            pstm.setInt(7, obj.getIdProveedor());
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public Proveedor buscaProveedor(int idProveedor){
        Proveedor obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from proveedores where id_proveedor=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idProveedor);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new Proveedor();
                obj.setIdProveedor(rs.getInt("id_proveedor"));
                obj.setIdTipoDoc(rs.getInt("id_tipodoc"));
                obj.setRuc(rs.getString("pro_nrodoc"));
                obj.setRazonSocial(rs.getString("pro_razsoc"));
                obj.setTelefono(rs.getString("pro_telefono"));
                obj.setDireccion(rs.getString("pro_direccion"));
                obj.setEmail(rs.getString("pro_email"));
                obj.setPais(rs.getString("pro_pais"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaProveedor(int idProveedor){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from proveedores where id_proveedor=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idProveedor);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<Proveedor> listaUbicaProveedor(Proveedor p){
        ArrayList<Proveedor> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select p.*,tdi.tdi_abreviatura from proveedores p\n" +
                         "left join tipo_documento_identidad tdi on tdi.id_tipodoc=p.id_tipodoc\n" +
                         "where pro_nrodoc like '%" + p.getRuc() + "%' and pro_razsoc like '%" + p.getRazonSocial()+ "%' and pro_telefono like '%" + p.getTelefono()+ "%' and pro_direccion like '%" + p.getDireccion()+ "%'";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Proveedor obj;
            while(rs.next()){
                obj = new Proveedor();
                obj.setIdProveedor(rs.getInt("id_proveedor"));
                obj.setTdiAbreviatura(rs.getString("tdi_abreviatura"));
//                obj.setIdTipoDoc(rs.getInt("id_tipodoc"));
                obj.setRuc(rs.getString("pro_nrodoc"));
                obj.setRazonSocial(rs.getString("pro_razsoc"));
                obj.setTelefono(rs.getString("pro_telefono"));
                obj.setDireccion(rs.getString("pro_direccion"));
                obj.setEmail(rs.getString("pro_email"));
                obj.setPais(rs.getString("pro_pais"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
