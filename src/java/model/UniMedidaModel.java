/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.UniMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class UniMedidaModel {
     public int insertarUme(UniMedida obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into unidad_medida values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getUme_descripcion());
            pstm.setString(2, obj.getUme_abreviatura());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniMedidaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<UniMedida> listaUme(){
        ArrayList<UniMedida> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from unidad_medida";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            UniMedida obj;
            while(rs.next()){
                obj = new UniMedida();
                obj.setId_undmed(rs.getInt("id_undmed"));
                obj.setUme_descripcion(rs.getString("ume_descripcion"));
                obj.setUme_abreviatura(rs.getString("ume_abreviatura"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniMedidaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaUme(UniMedida obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update unidad_medida set ume_descripcion=?, ume_abreviatura=? where id_undmed=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getUme_descripcion());
            pstm.setString(2, obj.getUme_abreviatura());
            pstm.setInt(3, obj.getId_undmed());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniMedidaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public UniMedida buscaUme(int id_undmed){
        UniMedida obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from unidad_medida where id_undmed=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_undmed);
//            pstm.setInt(1, idAlmacen);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new UniMedida();
                obj.setId_undmed(rs.getInt("id_undmed"));
                obj.setUme_descripcion(rs.getString("ume_descripcion"));
                obj.setUme_abreviatura(rs.getString("ume_abreviatura"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniMedidaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaUme(int id_undmed){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from unidad_medida where id_undmed=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_undmed);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniMedidaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<UniMedida> listaUbicaUme(UniMedida p){
        ArrayList<UniMedida> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from unidad_medida where ume_descripcion like '%" + p.getUme_descripcion()+ "%' and ume_abreviatura like '%" + p.getUme_abreviatura()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            UniMedida obj;
            while(rs.next()){
                obj = new UniMedida();
                obj.setId_undmed(rs.getInt("id_undmed"));
                obj.setUme_descripcion(rs.getString("ume_descripcion"));
                obj.setUme_abreviatura(rs.getString("ume_abreviatura"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniMedidaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
