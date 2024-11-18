/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ruisu's
 */
public class ConnectDB {
    
    private static ConnectDB instance;
    
    private Connection connectionSQL;
    
    private ConnectDB(){
        String host = "localhost";
        String puerto = "3306";
        String nameDB = "InciTrack ";
        
        String usuario = "InciTrack ";
        String password = "Fw200310.";
        
        String driver = "com.mysql.cj.jdbc.Driver";
        
        String databaseURL = "jdbc:mysql://"+host+":"+puerto+"/"+nameDB+"?useSSL=false";
        
        try{
            Class.forName(driver);
            this.connectionSQL = DriverManager.getConnection(databaseURL, usuario, password);
            System.out.println("base de datos OK");
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();  // Crear la instancia si no existe
        }
        return instance;
    }
    
    public Connection getConectionDB(){
        return this.connectionSQL;
    }
    
    
}
