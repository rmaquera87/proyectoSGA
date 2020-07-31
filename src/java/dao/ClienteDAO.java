/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ClienteDTO;
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
public class ClienteDAO {
    
        public ArrayList<ClienteDTO> listar(){
            
        ArrayList<ClienteDTO> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select id_cliente,if(id_tipodoc=1,concat(cli_apellidos,' ',cli_nombres), cli_razon_social) as descripcion from clientes";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            ClienteDTO obj;
            while(rs.next()){
                obj = new ClienteDTO();
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setDescripcion(rs.getString("descripcion"));


                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
}
