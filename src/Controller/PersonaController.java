/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.ConnectDB;
import DB.Fabric;
import Models.DAO.PersonaDao;
import Models.DAO.UsuarioDao;
import Models.Persona;
import Models.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruisu's
 */
public class PersonaController {
    
    //private Fabric fabric;
    private PersonaDao personaDao;
    private UsuarioDao usuarioDao;

    public PersonaController() {
        personaDao = new PersonaDao();
        usuarioDao = new UsuarioDao();
    }
    
    public boolean validarUsuario(Usuario usuario){
        for(Persona persona : personaDao.getPersonas()){
            if(persona != null 
                    && persona.getUsuario().getUsername().equals(usuario.getUsername())
                    && persona.getUsuario().getPassword().equals(usuario.getPassword())){
                return true;
            }
        }
        return false;
    }
    
    public Persona getUserLogin(Usuario usuario){
        for(Persona persona : personaDao.getPersonas()){
            if(persona != null 
                    && persona.getUsuario().getUsername().equals(usuario.getUsername())){
                return persona;
            }
        }
        return new Persona();
    }
    
    public List<Persona> getPersonas(){
        return personaDao.getPersonas();
    }
    
    public List<Persona> getSimilarPersons(String text){
        List<Persona> personas = new ArrayList<>();
        for(Persona persona : personaDao.getPersonas()){
            if(persona != null && persona.getNombre().toLowerCase().contains(text.toLowerCase())){
                personas.add(persona);
            }
        }
        if(personas.size() == 0){
            return (List) new ArrayList<>(List.of(new Persona(-999, "No hay", "Concidencias", 9999, "error")));
        }
        return personas;
    }
    
    public void addUser(Persona persona){
        if(persona.getCorreo().length() < 1 || persona.getCorreo().length() > 250 || 
                persona.getNombre().length() < 1 || persona.getNombre().length() > 50 || 
                persona.getNumeroDocumento() < 10000000 || persona.getNumeroDocumento() > 999999999  ){
            JOptionPane.showMessageDialog(null, "Valida los valores ingresados.");
        }
        Integer usuarioID = usuarioDao.crearUsuario(new Usuario(persona.getUsuario().getUsername(), persona.getUsuario().getPassword()));
        persona.getUsuario().setId(usuarioID);
        personaDao.crearPersona(persona);
    }
    
}
