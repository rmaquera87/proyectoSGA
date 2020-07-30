/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.KardexDetalleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

/**
 *
 * @author DAYIRO
 */
public class KardexDetalleDAO {
    
    public int insertarParteIngDet(KardexDetalleDTO obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into kardex_detalle (id_kdxcab,id_producto,kad_cantidad,id_usuario,kad_fecreg)"
                    + "values(?,?,?,?,now())";

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, obj.getIdKdxcab());
            pstm.setInt(2, obj.getIdProducto());
            pstm.setInt(3, obj.getKadCantidad());
            pstm.setInt(4, obj.getIdUsuario());


            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public ArrayList<KardexDetalleDTO> listaKardexDetalle(int id){
        ArrayList<KardexDetalleDTO> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select kd.kad_item, kd.id_producto,p.prd_descripcion, kd.kad_cantidad\n" +
                        "from kardex_detalle kd\n" +
                        "inner join productos p on kd.id_producto=p.id_producto \n" +
                        "where id_kdxcab=? order by kad_item asc";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            KardexDetalleDTO obj;
            while(rs.next()){
                obj = new KardexDetalleDTO();
                obj.setKadItem(rs.getInt("kad_item"));
                obj.setIdProducto(rs.getInt("id_producto"));
                obj.setPrdDescripcion(rs.getString("prd_descripcion"));
                obj.setKadCantidad(rs.getInt("kad_cantidad"));
              
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
        
    public int eliminar(int id){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from kardex_detalle where id_kdxcab=?";

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);


            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
