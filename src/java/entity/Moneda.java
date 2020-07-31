/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Moneda {
    private int id_moneda;
    private String tmo_descripcion;
    private String tmo_simbolo;

    public int getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public String getTmo_descripcion() {
        return tmo_descripcion;
    }

    public void setTmo_descripcion(String tmo_descripcion) {
        this.tmo_descripcion = tmo_descripcion;
    }

    public String getTmo_simbolo() {
        return tmo_simbolo;
    }

    public void setTmo_simbolo(String tmo_simbolo) {
        this.tmo_simbolo = tmo_simbolo;
    }
    
}
