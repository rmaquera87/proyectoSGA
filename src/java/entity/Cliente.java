/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Cliente {
    private int id_cliente;
    private int id_tipodoc;
    private String cli_nrodoc;
    private String cli_nombres;
    private String cli_apellidos;
    private String cli_rzasoc;
    private String cli_direccion;
    private String cli_telefono;
    private String cli_email;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_tipodoc() {
        return id_tipodoc;
    }

    public void setId_tipodoc(int id_tipodoc) {
        this.id_tipodoc = id_tipodoc;
    }

    public String getCli_nrodoc() {
        return cli_nrodoc;
    }

    public void setCli_nrodoc(String cli_nrodoc) {
        this.cli_nrodoc = cli_nrodoc;
    }

    public String getCli_nombres() {
        return cli_nombres;
    }

    public void setCli_nombres(String cli_nombres) {
        this.cli_nombres = cli_nombres;
    }

    public String getCli_apellidos() {
        return cli_apellidos;
    }

    public void setCli_apellidos(String cli_apellidos) {
        this.cli_apellidos = cli_apellidos;
    }

    public String getCli_rzasoc() {
        return cli_rzasoc;
    }

    public void setCli_rzasoc(String cli_rzasoc) {
        this.cli_rzasoc = cli_rzasoc;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public String getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }
    
    
}
