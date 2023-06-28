package DTO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    private String database = "ProyectoVet";

    // Host
    private String hostname = "localhost";

    // Puerto
    private String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    private String username = "root";

    // Clave de usuario
    private String password = "";
    
    private Connection con;
    
    public Conexion() {
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            //System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public ResultSet ejecutaQuery(String sql){
        //Connection cn = new Conexion();
        Statement st;
        ResultSet rs = null;
        
        try {
            st = this.con.createStatement();
            rs = st.executeQuery(sql);
            
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public void CloseConexion(){
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
