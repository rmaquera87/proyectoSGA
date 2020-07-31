/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author VAIO
 */
public class UniMedida {
    private int id_undmed;
    private String ume_descripcion;
    private String ume_abreviatura;

    public int getId_undmed() {
        return id_undmed;
    }

    public void setId_undmed(int id_undmed) {
        this.id_undmed = id_undmed;
    }

    public String getUme_descripcion() {
        return ume_descripcion;
    }

    public void setUme_descripcion(String ume_descripcion) {
        this.ume_descripcion = ume_descripcion;
    }

    public String getUme_abreviatura() {
        return ume_abreviatura;
    }

    public void setUme_abreviatura(String ume_abreviatura) {
        this.ume_abreviatura = ume_abreviatura;
    }
 
}
