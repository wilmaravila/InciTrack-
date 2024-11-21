/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import DB.ConnectDB;
import Models.Incidente;
import Models.Persona;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruisu's
 */
public class IncidenteDao {
    
    
    private Connection connection;

    public IncidenteDao() {
        ConnectDB db = ConnectDB.getInstance();
        this.connection = db.getConectionDB();
    }
    
    public void crearIncidente(Incidente incidente) {
        String sql = "INSERT INTO incidentes (tipo, descripcion, persona_id) VALUES (?, ?, ?)";
    
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, incidente.getTipo());
        statement.setString(2, incidente.getDescripcion());
        statement.setInt(3, incidente.getPersona().getId());
        statement.executeUpdate();
        System.out.println("Incidente insertado correctamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    public List<Incidente> getIncidentes() {
        List<Incidente> listaIncidentes = new ArrayList<>();
    String sql = "SELECT i.*, p.nombre, p.apellido FROM incidentes i JOIN personas p ON i.persona_id = p.id";
    
    try (PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            // Crear una instancia de Incidente
            Incidente incidente = new Incidente();
            incidente.setId(resultSet.getInt("id"));
            incidente.setTipo(resultSet.getString("tipo"));
            incidente.setDescripcion(resultSet.getString("descripcion"));
            incidente.setFechaReporte(resultSet.getTimestamp("fechaReporte"));

            // Crear una instancia de Persona asociada al incidente
            Persona persona = new Persona();
            persona.setId(resultSet.getInt("persona_id"));
            persona.setNombre(resultSet.getString("nombre"));
            persona.setApellido(resultSet.getString("apellido"));

            // Asociar la Persona al Incidente
            incidente.setPersona(persona);

            // Agregar el Incidente a la lista
            listaIncidentes.add(incidente);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaIncidentes;
    }
    
    public List<Incidente> getIncidentesByType(String tipo) {
        List<Incidente> listaIncidentes = new ArrayList<>();
    String sql = "SELECT i.*, p.nombre, p.apellido FROM incidentes i JOIN personas p ON i.persona_id = p.id where i.tipo = '"+tipo+"'";
        System.out.println(sql);
    
    try (PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            // Crear una instancia de Incidente
            Incidente incidente = new Incidente();
            incidente.setId(resultSet.getInt("id"));
            incidente.setTipo(resultSet.getString("tipo"));
            incidente.setDescripcion(resultSet.getString("descripcion"));

            // Crear una instancia de Persona asociada al incidente
            Persona persona = new Persona();
            persona.setId(resultSet.getInt("persona_id"));
            persona.setNombre(resultSet.getString("nombre"));
            persona.setApellido(resultSet.getString("apellido"));

            // Asociar la Persona al Incidente
            incidente.setPersona(persona);

            // Agregar el Incidente a la lista
            listaIncidentes.add(incidente);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaIncidentes;
    }
    
    public List<Incidente> getIncidentesByDate(int mes) {
        List<Incidente> listaIncidentes = new ArrayList<>();
    String sql = "SELECT i.*, p.nombre, p.apellido FROM incidentes i JOIN personas p ON i.persona_id = p.id WHERE i.fechaReporte >= CURDATE() - INTERVAL "+mes+" MONTH;";
        System.out.println(sql);
    
    try (PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            // Crear una instancia de Incidente
            Incidente incidente = new Incidente();
            incidente.setId(resultSet.getInt("id"));
            incidente.setTipo(resultSet.getString("tipo"));
            incidente.setDescripcion(resultSet.getString("descripcion"));

            // Crear una instancia de Persona asociada al incidente
            Persona persona = new Persona();
            persona.setId(resultSet.getInt("persona_id"));
            persona.setNombre(resultSet.getString("nombre"));
            persona.setApellido(resultSet.getString("apellido"));

            // Asociar la Persona al Incidente
            incidente.setPersona(persona);

            // Agregar el Incidente a la lista
            listaIncidentes.add(incidente);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaIncidentes;
    }

    
}
