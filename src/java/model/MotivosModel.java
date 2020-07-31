/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.MotivoMovimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class MotivosModel {
    public int insertarMotivo(MotivoMovimientos obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into motivo_movimientos values(null,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getMmo_descripcion());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MotivosModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<MotivoMovimientos> listaMotivo(){
        ArrayList<MotivoMovimientos> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from motivo_movimientos";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            MotivoMovimientos obj;
            while(rs.next()){
                obj = new MotivoMovimientos();
                obj.setId_motivo(rs.getInt("id_motivo"));
                obj.setMmo_descripcion(rs.getString("mmo_descripcion"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MotivosModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaMotivo(MotivoMovimientos obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update motivo_movimientos set mmo_descripcion=? where id_motivo=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getMmo_descripcion());
            pstm.setInt(2, obj.getId_motivo());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MotivosModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public MotivoMovimientos buscaMotivo(int id_motivo){
        MotivoMovimientos obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from motivo_movimientos where id_motivo=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_motivo);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new MotivoMovimientos();
                obj.setId_motivo(rs.getInt("id_motivo"));
                obj.setMmo_descripcion(rs.getString("mmo_descripcion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MotivosModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaMotivo(int id_motivo){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from motivo_movimientos where id_motivo=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_motivo);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MotivosModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<MotivoMovimientos> listaUbicaMotivo(MotivoMovimientos p){
        ArrayList<MotivoMovimientos> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from motivo_movimientos where mmo_descripcion like '%" + p.getMmo_descripcion()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            MotivoMovimientos obj;
            while(rs.next()){
                obj = new MotivoMovimientos();
                obj.setId_motivo(rs.getInt("id_motivo"));
                obj.setMmo_descripcion(rs.getString("mmo_descripcion"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MotivosModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
