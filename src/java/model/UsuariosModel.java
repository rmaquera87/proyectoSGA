/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MysqlDBConexion;

/**
 *
 * @author DAYIRO
 */
public class UsuariosModel {

    public Usuarios obtenerUsuario(Usuarios u) {
        Usuarios userResult=null;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "select id_usuario, usu_username, usu_nombre, usu_apellidos, id_perfil, usu_estado "
                    + "from usuarios where usu_username=? and usu_password=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, u.getUsuUsername());
            pstm.setString(2, u.getUsuPassword());
            ResultSet rs;
            rs = pstm.executeQuery();

            if (rs.next()) {
                userResult = new Usuarios();
                userResult.setIdUsuario(rs.getInt("id_usuario"));
                userResult.setUsuUsername(rs.getString("usu_username"));
                userResult.setUsuNombre(rs.getString("usu_nombre"));
                userResult.setUsuApellidos(rs.getString("usu_apellidos"));
                userResult.setIdPerfil(rs.getInt("id_perfil"));
                userResult.setUsuEstado(rs.getString("usu_estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userResult;
    }

}
