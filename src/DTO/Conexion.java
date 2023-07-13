package DTO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private String database = "ProyectoVet";
    private String hostname = "localhost";
    private String port = "3306";
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    private String username = "root";
    private String password = "";
    private Connection con;
    
    public Conexion() {
        
        try {
            con = DriverManager.getConnection(url, username, password);
            //System.out.println("Conectado");
        } catch (SQLException e) {
        }
        
    }
    
    public ResultSet ejecutaQuery(String sql){
        Statement st;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                rs.getString(0);
            }
        } catch (SQLException e) {
        }
        return rs;
    }
    
    public void ejecutaVoidQuery(String sql){
        //Connection cn = new Conexion();
        Statement st;
        
        try {
            //System.out.println("Consulta: "+sql);
            st = con.createStatement();
            st.execute(sql);
            
            //System.out.println("Operacion realizada con exito");
        } catch (SQLException e) {
            String mensaje = e.getMessage();
            if(e.getMessage().equals("Cannot add or update a child row: a foreign key constraint fails (`proyectovet`.`mascota`, CONSTRAINT `Mascota_ibfk_2` FOREIGN KEY (`RutDueño`) REFERENCES `dueño` (`Rut`) ON DELETE CASCADE ON UPDATE CASCADE)")){
                mensaje = "El Rut del dueño ingresado no existe";
            }
            System.out.println("Error :"+mensaje);
        }
    }
    
    public void CloseConexion(){
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
