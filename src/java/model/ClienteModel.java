/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class ClienteModel {
    //Metodo insertar
    public int insertarCliente(Cliente obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into clientes values(null,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, obj.getId_tipodoc());
            pstm.setString(2, obj.getCli_nrodoc());
            pstm.setString(3, obj.getCli_nombres());
            pstm.setString(4, obj.getCli_apellidos());
            pstm.setString(5, obj.getCli_rzasoc());
            pstm.setString(6, obj.getCli_direccion());
            pstm.setString(7, obj.getCli_telefono());
            pstm.setString(8, obj.getCli_email());
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<Cliente> listaCliente(){
        ArrayList<Cliente> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select cl.*,tdi.tdi_abreviatura from clientes cl\n" +
                         "left join tipo_documento_identidad tdi on tdi.id_tipodoc=cl.id_tipodoc";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Cliente obj;
            while(rs.next()){
                obj = new Cliente();
                obj.setId_cliente(rs.getInt("id_cliente"));
//                obj.setId_tipodoc(rs.getInt("id_tipodoc"));
                obj.setTdiAbrreviatura(rs.getString("tdi_abreviatura"));
                obj.setCli_nrodoc(rs.getString("cli_nrodoc"));
                obj.setCli_nombres(rs.getString("cli_nombres"));
                obj.setCli_apellidos(rs.getString("cli_apellidos"));
                obj.setCli_rzasoc(rs.getString("cli_razon_social"));
                obj.setCli_direccion(rs.getString("cli_direccion"));
                obj.setCli_telefono(rs.getString("cli_telefono"));
                obj.setCli_email(rs.getString("cli_email"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(data);
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaCliente(Cliente obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update clientes set cli_nrodoc=?,cli_nombres=?,cli_apellidos=?,cli_razon_social=?,cli_direccion=?,cli_telefono=?,cli_email=? where id_cliente=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getCli_nrodoc());
            pstm.setString(2, obj.getCli_nombres());
            pstm.setString(3, obj.getCli_apellidos());
            pstm.setString(4, obj.getCli_rzasoc());
            pstm.setString(5, obj.getCli_direccion());
            pstm.setString(6, obj.getCli_telefono());
            pstm.setString(7, obj.getCli_email());
            pstm.setInt(8, obj.getId_cliente());
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public Cliente buscaCliente(int id_Cliente){
        Cliente obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from clientes where id_cliente=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_Cliente);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new Cliente();
                obj.setId_cliente(rs.getInt("id_cliente"));
                obj.setId_tipodoc(rs.getInt("id_tipodoc"));               
                obj.setCli_nrodoc(rs.getString("cli_nrodoc"));
                obj.setCli_nombres(rs.getString("cli_nombres"));
                obj.setCli_apellidos(rs.getString("cli_apellidos"));
                obj.setCli_rzasoc(rs.getString("cli_razon_social"));
                obj.setCli_direccion(rs.getString("cli_direccion"));
                obj.setCli_telefono(rs.getString("cli_telefono"));
                obj.setCli_email(rs.getString("cli_email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaCliente(int id_cliente){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from clientes where id_cliente=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_cliente);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<Cliente> listaUbicaCliente(Cliente p){
        ArrayList<Cliente> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select cl.*,tdi.tdi_abreviatura from clientes cl\n" +
                         "left join tipo_documento_identidad tdi on tdi.id_tipodoc=cl.id_tipodoc \n" 
                    + "where cli_nrodoc like '%" + p.getCli_nrodoc()+ "%' and cli_nombres like '%" 
                    + p.getCli_nombres()+ "%' and cli_apellidos like '%" + p.getCli_apellidos()+"%' and cli_razon_social like '%" 
                    + p.getCli_rzasoc()+"%' and cli_direccion like '%" + p.getCli_direccion()+"%' and cli_telefono like '%" 
                    + p.getCli_telefono()+"%'";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
//+ p.getCli_telefono()+"%' and cli_email like '%" + p.getCli_email()+ "%'";            
            Cliente obj;
            while(rs.next()){
                obj = new Cliente();
                obj.setId_cliente(rs.getInt("id_cliente"));
//                obj.setId_tipodoc(rs.getInt("id_tipodoc"));
                obj.setTdiAbrreviatura(rs.getString("tdi_abreviatura"));
                obj.setCli_nrodoc(rs.getString("cli_nrodoc"));
                obj.setCli_nombres(rs.getString("cli_nombres"));
                obj.setCli_apellidos(rs.getString("cli_apellidos"));
                obj.setCli_rzasoc(rs.getString("cli_razon_social"));
                obj.setCli_direccion(rs.getString("cli_direccion"));
                obj.setCli_telefono(rs.getString("cli_telefono"));
                obj.setCli_email(rs.getString("cli_email"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
