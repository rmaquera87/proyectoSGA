/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.TipoDocumento;
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
 * @author VAIO
 */
public class TipoDocumentoModel {
    public int insertarTipoDoc(TipoDocumento obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into tipo_documento values(null,?,?,null)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getTdo_descripcion());
            pstm.setString(2, obj.getTdo_abreviatura());
//            pstm.setInt(3, obj.getTdo_induso());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<TipoDocumento> listaTipoDoc(){
        ArrayList<TipoDocumento> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from tipo_documento";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            TipoDocumento obj;
            while(rs.next()){
                obj = new TipoDocumento();
                obj.setId_tipdoc(rs.getInt("id_tdo"));
                obj.setTdo_descripcion(rs.getString("tdo_descripcion"));
                obj.setTdo_abreviatura(rs.getString("tdo_abreviatura"));
//                obj.setTdo_induso(rs.getInt("tdo_uso"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaTipoDoc(TipoDocumento obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update tipo_documento set tdo_descripcion=?, tdo_abreviatura=? where id_tdo=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getTdo_descripcion());
            pstm.setString(2, obj.getTdo_abreviatura());
//            pstm.setInt(3, obj.getTdo_induso());
            pstm.setInt(3, obj.getId_tipdoc());


            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public TipoDocumento buscaTipoDoc(int id_tipdoc){
        TipoDocumento obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from tipo_documento where id_tdo=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_tipdoc);

            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new TipoDocumento();
                obj.setId_tipdoc(rs.getInt("id_tdo"));
                obj.setTdo_descripcion(rs.getString("tdo_descripcion"));
                obj.setTdo_abreviatura(rs.getString("tdo_abreviatura"));
//                obj.setTdo_induso(rs.getInt("tdo_induso"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaTipoDocId(int id_tipdoc){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from tipo_documento where id_tdo=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_tipdoc);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<TipoDocumento> listaUbicaTipoDocId(TipoDocumento p){
        ArrayList<TipoDocumento> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from tipo_documento where tdo_descripcion like '%" + p.getTdo_descripcion()+ "%' and tdo_abreviatura like '%" + p.getTdo_abreviatura()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            TipoDocumento obj;
            while(rs.next()){
                obj = new TipoDocumento();
                obj.setId_tipdoc(rs.getInt("id_tdo"));
                obj.setTdo_descripcion(rs.getString("tdo_descripcion"));
                obj.setTdo_abreviatura(rs.getString("tdo_abreviatura"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
