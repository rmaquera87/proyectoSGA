/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MotivoMovimientoDTO;
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
public class MotivoMovimientoDAO {
    
        public ArrayList<MotivoMovimientoDTO> listarMotivo(){
            
        ArrayList<MotivoMovimientoDTO> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from motivo_movimientos";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            MotivoMovimientoDTO obj;
            while(rs.next()){
                obj = new MotivoMovimientoDTO();
                obj.setIdMotivo(rs.getInt("id_motivo"));
                obj.setMmoDescripcion(rs.getString("mmo_descripcion"));


                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
}
