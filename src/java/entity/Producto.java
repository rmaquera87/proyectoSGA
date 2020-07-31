/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MELANY
 */
public class Producto {
    private int idProducto;
    private int producto;
    private String descripcion;
    private int undmed;
    private int marca;
    private int tipinv;
    private double costo;
    private double preciov;
    private int stkmin;
    private int stkmax;
    private double peso;
    private String estado;


    
    public int getIdProducto() {    
        return idProducto;
    }

    /*
    private int idProducto;
    private String descripcion;
    private String forma;
    private String material;
    private String tamanio;
    private String color;
    private Integer idClase;
    private String nomClase;
    public int getIdProducto() {
    return idProducto;
    }
    public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
    }
    public String getDescripcion() {
    return descripcion;
    }
    public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
    }
    public String getForma() {
    return forma;
    }
    public void setForma(String forma) {
    this.forma = forma;
    }
    public String getMaterial() {
    return material;
    }
    public void setMaterial(String material) {
    this.material = material;
    }
    public String getTamanio() {
    return tamanio;
    }
    public void setTamanio(String tamanio) {
    this.tamanio = tamanio;
    }
    public String getColor() {
    return color;
    }
    public void setColor(String color) {
    this.color = color;
    }
    public Integer getIdClase() {
    return idClase;
    }
    public void setIdClase(Integer idClase) {
    this.idClase = idClase;
    }
    public String getNomClase() {
    return nomClase;
    }
    public void setNomClase(String nomClase) {
    this.nomClase = nomClase;
    }
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUndmed() {
        return undmed;
    }

    public void setUndmed(int undmed) {
        this.undmed = undmed;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getTipinv() {
        return tipinv;
    }

    public void setTipinv(int tipinv) {
        this.tipinv = tipinv;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPreciov() {
        return preciov;
    }

    public void setPreciov(double preciov) {
        this.preciov = preciov;
    }

    public int getStkmin() {
        return stkmin;
    }

    public void setStkmin(int stkmin) {
        this.stkmin = stkmin;
    }

    public int getStkmax() {
        return stkmax;
    }

    public void setStkmax(int stkmax) {
        this.stkmax = stkmax;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
