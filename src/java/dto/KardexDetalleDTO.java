/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author DAYIRO
 */
public class KardexDetalleDTO {
private int idKdxdet;
private int idKdxcab;
private int kacNummov;
private int kadItem;
private int idProducto;
private String prdDescripcion;
private int kadCantidad;
private double kadCosto;
private double kadPrecio;
private int idUsuario;
private String kadFecreg;

    public int getIdKdxdet() {
        return idKdxdet;
    }

    public void setIdKdxdet(int idKdxdet) {
        this.idKdxdet = idKdxdet;
    }

    public int getIdKdxcab() {
        return idKdxcab;
    }

    public void setIdKdxcab(int idKdxcab) {
        this.idKdxcab = idKdxcab;
    }

    public int getKacNummov() {
        return kacNummov;
    }

    public void setKacNummov(int kacNummov) {
        this.kacNummov = kacNummov;
    }

    public int getKadItem() {
        return kadItem;
    }

    public void setKadItem(int kadItem) {
        this.kadItem = kadItem;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getPrdDescripcion() {
        return prdDescripcion;
    }

    public void setPrdDescripcion(String prdDescripcion) {
        this.prdDescripcion = prdDescripcion;
    }

    public int getKadCantidad() {
        return kadCantidad;
    }

    public void setKadCantidad(int kadCantidad) {
        this.kadCantidad = kadCantidad;
    }

    public double getKadCosto() {
        return kadCosto;
    }

    public void setKadCosto(double kadCosto) {
        this.kadCosto = kadCosto;
    }

    public double getKadPrecio() {
        return kadPrecio;
    }

    public void setKadPrecio(double kadPrecio) {
        this.kadPrecio = kadPrecio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getKadFecreg() {
        return kadFecreg;
    }

    public void setKadFecreg(String kadFecreg) {
        this.kadFecreg = kadFecreg;
    }
    
}
