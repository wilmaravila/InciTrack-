/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;

/**
 *
 * @author Ruisu's
 */
public class Incidente {
    
    private int id;
    private String tipo;
    private String descripcion;
    private Persona persona;
    private Timestamp fechaReporte;

    public Incidente(int id, String tipo, String descripcion, Persona persona, Timestamp fechaReporte) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.persona = persona;
        this.fechaReporte = fechaReporte;
    }

    public Incidente(String tipo, String descripcion, Persona persona) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.persona = persona;
        this.fechaReporte = fechaReporte;
    }

    public Incidente() {
    }

    public Timestamp getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Timestamp fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
