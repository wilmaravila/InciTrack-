/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import DB.ConnectDB;
import Models.Persona;
import Models.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruisu's
 */
public class PersonaDao {

    private Connection connection;

    public PersonaDao() {
        ConnectDB db = ConnectDB.getInstance();
        this.connection = db.getConectionDB();
    }
    
    public void crearPersona(Persona persona) {
        String sql = "INSERT INTO personas (nombre, apellido, numeroDocumento, correo, usuario_id, tipoDocumento) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, String.valueOf(persona.getNumeroDocumento()));
            statement.setString(4, persona.getCorreo());
            statement.setInt(5, persona.getUsuario().getId());
            statement.setString(6, persona.getTipoDocumento());
            statement.executeUpdate();
            System.out.println("Persona insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = new ArrayList<>();
        String sql = "SELECT p.*, u.username, u.password FROM personas p JOIN usuarios u ON p.usuario_id = u.id";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Persona persona = new Persona();
                
                persona.setId(resultSet.getInt("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setNumeroDocumento(resultSet.getLong("numeroDocumento"));
                persona.setCorreo(resultSet.getString("correo"));
                persona.setTipoDocumento(resultSet.getString("tipoDocumento"));
                Usuario usuario = new Usuario(resultSet.getString("username"), resultSet.getString("password"));
                
                persona.setUsuario(usuario);
                
                listaPersonas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPersonas;
    }

}
