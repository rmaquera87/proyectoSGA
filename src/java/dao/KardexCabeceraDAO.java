/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.KardexCabeceraDTO;
import entity.Almacen;
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
 * @author Joseph
 */
public class KardexCabeceraDAO {
    
    public int insertar(KardexCabeceraDTO obj){
        int salida = -1;
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            String sql = "insert into kardex_cabecera (id_almacen,id_tdo,id_motivo,kac_tdoref1,kac_docref1,id_proveedor,id_cliente,kac_fecha,kac_glosa,kac_estado,id_usuario,kac_fecreg)"
                    + "values(?,?,?,?,?,?,?,?,?,'A',?,now())";

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, obj.getIdAlmacen());
            pstm.setInt(2, obj.getIdTdo());
            pstm.setInt(3, obj.getIdMotivo());
            pstm.setString(4, obj.getKacTdoref1());
            pstm.setString(5, obj.getKacDocref1());
            pstm.setInt(6, obj.getIdProveedor());
            pstm.setInt(7, obj.getIdCliente());
            pstm.setString(8, obj.getKacFecha());
            pstm.setString(9, obj.getKacGlosa());
            pstm.setInt(10, obj.getIdUsuario());
            
            pstm.executeUpdate();

            String sql2 = "select max(id_kdxcab) as id_kdxcab from kardex_cabecera";
            PreparedStatement pstm2 = conn.prepareStatement(sql2);
            ResultSet rs2 = pstm2.executeQuery();
            rs2.next();
            salida =  rs2.getInt("id_kdxcab");
            
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    //metodo 2 listar
    public ArrayList<KardexCabeceraDTO> listaKardex(KardexCabeceraDTO k){
        ArrayList<KardexCabeceraDTO> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select kc.id_kdxcab,kc.kac_fecha, kc.id_almacen,a.alm_descripcion, kc.id_motivo,mm.mmo_descripcion, kc.id_proveedor,p.pro_razsoc, \n" +
            "kc.id_cliente,if(c.id_tipodoc=1,concat(c.cli_apellidos,' ',c.cli_nombres), c.cli_razon_social) as cli_descripcion\n" +
            "from kardex_cabecera kc\n" +
            "inner join almacenes a  on kc.id_almacen =a.id_almacen \n" +
            "inner join motivo_movimientos mm on kc.id_motivo =mm.id_motivo\n" +
            "left join proveedores p on kc.id_proveedor=p.id_proveedor\n" +
            "left join clientes c on kc.id_cliente=c.id_cliente \n" +
            "where 1=1 ";
            
            if (k.getIdAlmacen()  != 0) {
                sql += " and kc.id_almacen= " + k.getIdAlmacen();
            }
            if (k.getKacFecha() != null && k.getKacFecha() != "") {
                sql += " and kc.kac_fecha ='" + k.getKacFecha() + "'";
            }
            if (k.getIdMotivo() != 0) {
                sql += " and kc.id_motivo = "+k.getIdMotivo();
            }
            if (k.getIdProveedor() != 0) {
                sql += " and kc.id_proveedor=" + k.getIdProveedor();
            }
            if (k.getIdCliente() != 0) {
                sql += " and kc.id_cliente=" + k.getIdCliente();
            }
            sql += " and kc.id_tdo="+k.getIdTdo();
            sql +=" order by kc.id_kdxcab";
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            KardexCabeceraDTO obj;
            while(rs.next()){
                obj = new KardexCabeceraDTO();
                obj.setIdKdxcab(rs.getInt("id_kdxcab"));
                obj.setKacFecha(rs.getString("kac_fecha"));
                obj.setIdAlmacen(rs.getInt("id_almacen"));
                obj.setAlmDescripcion(rs.getString("alm_descripcion"));
                obj.setIdMotivo(rs.getInt("id_motivo"));
                obj.setMmoDescripcion(rs.getString("mmo_descripcion"));
                obj.setIdProveedor(rs.getInt("id_proveedor"));
                obj.setProRazsoc(rs.getString("pro_razsoc"));
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setCliDescripcion(rs.getString("cli_descripcion"));

                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public KardexCabeceraDTO buscaKardex(int id){
        KardexCabeceraDTO obj = null;
        try {
            Connection conn;
            PreparedStatement pstm;
            ResultSet rs;
            conn = MysqlDBConexion.getConexion();
            String sql = "select id_kdxcab,id_almacen,id_tdo,id_motivo,kac_tdoref1,kac_docref1,id_proveedor,id_cliente,DATE_FORMAT(kac_fecha, \"%d/%m/%Y\") as kac_fecha,kac_glosa,kac_estado,id_usuario,kac_fecreg\n" +
            "from kardex_cabecera where id_kdxcab=?";
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                obj = new KardexCabeceraDTO();
                obj.setIdKdxcab(rs.getInt("id_kdxcab"));
                obj.setIdAlmacen(rs.getInt("id_almacen"));
                obj.setIdMotivo(rs.getInt("id_motivo"));
                obj.setKacTdoref1(rs.getString("kac_tdoref1"));
                obj.setKacDocref1(rs.getString("kac_docref1"));
                obj.setIdProveedor(rs.getInt("id_proveedor"));
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setKacFecha(rs.getString("kac_fecha"));
                obj.setKacGlosa(rs.getString("kac_glosa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    
    public int actualizar(KardexCabeceraDTO obj){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "update kardex_cabecera set id_almacen=?,id_motivo=?,kac_tdoref1=?,kac_docref1=?,id_proveedor=?,id_cliente=?,kac_fecha=?,kac_glosa=?  where id_kdxcab=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, obj.getIdAlmacen());
            pstm.setInt(2, obj.getIdMotivo());
            pstm.setString(3, obj.getKacTdoref1());
            pstm.setString(4, obj.getKacDocref1());
            pstm.setInt(5, obj.getIdProveedor());
            pstm.setInt(6, obj.getIdCliente());
            pstm.setString(7, obj.getKacFecha());
            pstm.setString(8, obj.getKacGlosa());
            pstm.setInt(9, obj.getIdKdxcab());

            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public int eliminar(int id){
        int salida = -1;
        try {
            Connection conn;
            PreparedStatement pstm;
            conn = MysqlDBConexion.getConexion();
            String sql = "delete from kardex_cabecera where id_kdxcab=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            salida = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    
    /*
    //Metodo 3 actualizar

    
    //Metodo 4 buscar

    
    //Metodo 5 eliminar

    public List<Almacen> listaUbicaAlmacen(Almacen p){
        ArrayList<Almacen> data = new ArrayList<>();
        try {
            PreparedStatement pstm;
            Connection conn;
            conn = MysqlDBConexion.getConexion();
            ResultSet rs;
            String sql = "select * from almacenes where alm_descripcion like '%" + p.getDescripcion()+ "%' and alm_direccion like '%" + p.getDireccion()+ "%' ";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            Almacen obj;
            while(rs.next()){
                obj = new Almacen();
                obj.setIdAlmacen(rs.getInt("id_almacen"));
                obj.setDescripcion(rs.getString("alm_descripcion"));
                obj.setDireccion(rs.getString("alm_direccion"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KardexCabeceraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    */
}
