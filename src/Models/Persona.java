/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Ruisu's
 */
public class Persona {
    
    private int id;
    private String nombre;
    private String apellido;
    private long numeroDocumento;
    private String correo;
    private Usuario usuario;
    
    private String tipoDocumento;
    private Character genero;
    private boolean isConfirmed = false;

    public Persona() {
    }

    public Persona(String nombre, String apellido, long numeroDocumento, String tipoDocumento, String correo, char genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.usuario = usuario;
        this.tipoDocumento = tipoDocumento;
        this.genero = genero;
    }

    public Persona(int id, String nombre, String apellido, long numeroDocumento, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
    }
    
    public Persona(String nombre, String apellido, long numeroDocumento, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }



    public boolean isIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
    
    
    
}
