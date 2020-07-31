/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.TipoDocId;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class TipoDocIdModel {
     public int insertarAlmacen(TipoDocId obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into tipo_documento_identidad values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getTdi_descripcion());
            pstm.setString(2, obj.getTdi_abreviatura());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocIdModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<TipoDocId> listaTipoDocId(){
        ArrayList<TipoDocId> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from tipo_documento_identidad";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            TipoDocId obj;
            while(rs.next()){
                obj = new TipoDocId();
                obj.setId_tipodoc(rs.getInt("id_tipodoc"));
                obj.setTdi_descripcion(rs.getString("tdi_descripcion"));
                obj.setTdi_abreviatura(rs.getString("tdi_abreviatura"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocIdModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaTipoDocId(TipoDocId obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update tipo_documento_identidad set tdi_descripcion=?, tdi_abreviatura=? where id_tipodoc=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getTdi_descripcion());
            pstm.setString(2, obj.getTdi_abreviatura());
            pstm.setInt(3, obj.getId_tipodoc());


            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocIdModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public TipoDocId buscaTipoDocId(int id_tipodoc){
        TipoDocId obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from tipo_documento_identidad where id_tipodoc=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_tipodoc);

            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new TipoDocId();
                obj.setId_tipodoc(rs.getInt("id_tipodoc"));
                obj.setTdi_descripcion(rs.getString("tdi_descripcion"));
                obj.setTdi_abreviatura(rs.getString("tdi_abreviatura"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocIdModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaTipoDocId(int id_tipodoc){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from tipo_documento_identidad where id_tipodoc=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_tipodoc);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocIdModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<TipoDocId> listaUbicaTipoDocId(TipoDocId p){
        ArrayList<TipoDocId> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from tipo_documento_identidad where tdi_descripcion like '%" + p.getTdi_descripcion()+ "%' and tdi_abreviatura like '%" + p.getTdi_abreviatura()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            TipoDocId obj;
            while(rs.next()){
                obj = new TipoDocId();
                obj.setId_tipodoc(rs.getInt("id_tipodoc"));
                obj.setTdi_descripcion(rs.getString("tdi_descripcion"));
                obj.setTdi_abreviatura(rs.getString("tdi_abreviatura"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocIdModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
