/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Moneda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class MonedaModel {
    public int insertarMoneda(Moneda obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into moneda values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getTmo_descripcion());
            pstm.setString(2, obj.getTmo_simbolo());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonedaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<Moneda> listaMoneda(){
        ArrayList<Moneda> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from moneda";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Moneda obj;
            while(rs.next()){
                obj = new Moneda();
                obj.setId_moneda(rs.getInt("id_moneda"));
                obj.setTmo_descripcion(rs.getString("tmo_descripcion"));
                obj.setTmo_simbolo(rs.getString("tmo_simbolo"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonedaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaMoneda(Moneda obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update moneda set tmo_descripcion=?, tmo_simbolo=? where id_moneda=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getTmo_descripcion());
            pstm.setString(2, obj.getTmo_simbolo());
            pstm.setInt(3, obj.getId_moneda());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonedaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public Moneda buscaMoneda(int id_moneda){
        Moneda obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from moneda where id_moneda=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_moneda);

            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new Moneda();
                obj.setId_moneda(rs.getInt("id_moneda"));
                obj.setTmo_descripcion(rs.getString("tmo_descripcion"));
                obj.setTmo_simbolo(rs.getString("tmo_simbolo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonedaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaMoneda(int id_moneda){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from moneda where id_moneda=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_moneda);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonedaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<Moneda> listaUbicaMoneda(Moneda p){
        ArrayList<Moneda> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from moneda where tmo_descripcion like '%" + p.getTmo_descripcion()+ "%' and tmo_simbolo like '%" + p.getTmo_simbolo()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Moneda obj;
            while(rs.next()){
                obj = new Moneda();
                obj.setId_moneda(rs.getInt("id_moneda"));
                obj.setTmo_descripcion(rs.getString("tmo_descripcion"));
                obj.setTmo_simbolo(rs.getString("tmo_simbolo"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonedaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
