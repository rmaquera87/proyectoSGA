/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class TipoDocumento {
    private int id_tipdoc;
    private String tdo_descripcion;
    private String tdo_abreviatura;
    private int tdo_induso;

    public int getId_tipdoc() {
        return id_tipdoc;
    }

    public void setId_tipdoc(int id_tipdoc) {
        this.id_tipdoc = id_tipdoc;
    }

    public String getTdo_descripcion() {
        return tdo_descripcion;
    }

    public void setTdo_descripcion(String tdo_descripcion) {
        this.tdo_descripcion = tdo_descripcion;
    }

    public String getTdo_abreviatura() {
        return tdo_abreviatura;
    }

    public void setTdo_abreviatura(String tdo_abreviatura) {
        this.tdo_abreviatura = tdo_abreviatura;
    }

    public int getTdo_induso() {
        return tdo_induso;
    }

    public void setTdo_induso(int tdo_induso) {
        this.tdo_induso = tdo_induso;
    }
    
    
}
