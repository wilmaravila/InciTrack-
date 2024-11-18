/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import DB.ConnectDB;
import Models.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ruisu's
 */
public class UsuarioDao {
    
    private Connection connection;

    public UsuarioDao() {
        ConnectDB db = ConnectDB.getInstance();
        this.connection = db.getConectionDB();
    }

    public Integer crearUsuario(Usuario usuario) {
         String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
    
    try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, usuario.getUsername());
        statement.setString(2, usuario.getPassword());
        
        // Ejecutar la inserción
        int affectedRows = statement.executeUpdate();
        
        // Verificar si se insertó al menos una fila
        if (affectedRows > 0) {
            // Obtener el ID generado
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del usuario insertado.");
                }
            }
        } else {
            throw new SQLException("No se pudo insertar el usuario, no se afectaron filas.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return -1; // Devuelve un valor que indique error
    }
    }
    
    
    
}
