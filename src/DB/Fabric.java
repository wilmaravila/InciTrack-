/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Models.Persona;
import Models.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruisu's
 */
public class Fabric {
    
    private List<Persona> personas;

    public Fabric() {
        personas = new ArrayList<>(); //Cambiar segun la cantidad de información que se vaya a colocar.
        this.initializer();
    }
    
    public void initializer(){
        Persona persona1 = new Persona(0, "Ruisu", "Euri", 9999999, "Ru@gmai.com");
        persona1.setUsuario(new Usuario(0, persona1.getNombre()+persona1.getApellido(), "123456" ));
        
        Persona persona2 = new Persona(1, "Mizuki", "Aki", 9999991, "Mi@gmai.com");
        persona2.setUsuario(new Usuario(1, persona1.getNombre()+persona1.getApellido(), "654321" ));
        
        Persona persona3 = new Persona(3, "Hana", "Sakura", 9999993, "hana@hotmail.com");
        persona3.setUsuario(new Usuario(3, persona3.getNombre() + persona3.getApellido(), "abcdef"));

        Persona persona4 = new Persona(4, "Kaito", "Takahashi", 9999994, "kaito@live.com");
        persona4.setUsuario(new Usuario(4, persona4.getNombre() + persona4.getApellido(), "qwerty"));

        Persona persona5 = new Persona(5, "Rina", "Kuro", 9999995, "rina@outlook.com");
        persona5.setUsuario(new Usuario(5, persona5.getNombre() + persona5.getApellido(), "zxcvbn"));

        Persona persona6 = new Persona(6, "Ren", "Kenshi", 9999996, "ren@aol.com");
        persona6.setUsuario(new Usuario(6, persona6.getNombre() + persona6.getApellido(), "asdfgh"));

        Persona persona7 = new Persona(7, "Yuki", "Shiro", 9999997, "yuki@icloud.com");
        persona7.setUsuario(new Usuario(7, persona7.getNombre() + persona7.getApellido(), "ghjklm"));

        Persona persona8 = new Persona(8, "Ami", "Nakamura", 9999998, "ami@gmail.com");
        persona8.setUsuario(new Usuario(8, persona8.getNombre() + persona8.getApellido(), "mnopqr"));
        
        this.personas.add(persona1);
        this.personas.add(persona2);
        this.personas.add(persona3);
        this.personas.add(persona4);
        this.personas.add(persona5);
        this.personas.add(persona6);
        this.personas.add(persona7);
        this.personas.add(persona8);
        
        
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    
    
    
    
    
}
