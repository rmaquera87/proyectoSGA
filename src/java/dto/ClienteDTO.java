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
public class ClienteDTO {
    
private int idCliente;
private int idTipodoc;
private String cliNrodoc;
private String cliNombres;
private String cliApellidos; 
private String cliRazonSocial;
private String cliDireccion;
private String cliTelefono;
private String cliEmail;

private String descripcion;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipodoc() {
        return idTipodoc;
    }

    public void setIdTipodoc(int idTipodoc) {
        this.idTipodoc = idTipodoc;
    }

    public String getCliNrodoc() {
        return cliNrodoc;
    }

    public void setCliNrodoc(String cliNrodoc) {
        this.cliNrodoc = cliNrodoc;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliRazonSocial() {
        return cliRazonSocial;
    }

    public void setCliRazonSocial(String cliRazonSocial) {
        this.cliRazonSocial = cliRazonSocial;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
