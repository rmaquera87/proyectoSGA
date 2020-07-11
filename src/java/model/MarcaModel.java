package model;

import entity.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

public class MarcaModel {
    public int insertarAlmacen(Marca obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into marca values(null,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getMrc_descripcion());
 //           pstm.setString(2, obj.getDireccion());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<Marca> listaMarca(){
        ArrayList<Marca> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from marca";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Marca obj;
            while(rs.next()){
                obj = new Marca();
                obj.setId_marca(rs.getInt("id_marca"));
                obj.setMrc_descripcion(rs.getString("mrc_descripcion"));
//                obj.setDireccion(rs.getString("direccion"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //Metodo 3 actualizar
    public int actualizaAlmacen(Marca obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update marca set mrc_descripcion=? where id_marca=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getMrc_descripcion());
            pstm.setInt(2, obj.getId_marca());
 //           pstm.setString(2, obj.getDireccion());
 //           pstm.setInt(3, obj.getIdAlmacen());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //Metodo 4 buscar
    public Marca buscaMarca(int id_marca){
        Marca obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select * from marca where id_marca=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_marca);
//            pstm.setInt(1, idAlmacen);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new Marca();
                obj.setId_marca(rs.getInt("id_marca"));
                obj.setMrc_descripcion(rs.getString("mrc_descripcion"));
//                obj.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    //Metodo 5 eliminar
    public int eliminaMarca(int id_marca){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from marca where id_marca=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_marca);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public List<Marca> listaUbicaMarca(Marca p){
        ArrayList<Marca> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from marca where mrc_descripcion like '%" + p.getMrc_descripcion()+ "%' ";// and direccion like '%" + p.getDireccion()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Marca obj;
            while(rs.next()){
                obj = new Marca();
                obj.setId_marca(rs.getInt("id_marca"));
                obj.setMrc_descripcion(rs.getString("mrc_descripcion"));
  //              obj.setDireccion(rs.getString("direccion"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
