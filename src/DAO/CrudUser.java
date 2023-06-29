package DAO;

import DTO.Conexion;
import DTO.Usuario;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudUser {
    
    
    public void Create(Usuario usu){
        Conexion nu = new Conexion();
        nu.ejecutaVoidQuery(
                "INSERT INTO `ususario`(`Rut`, `Nombre`, `Apellido`, `Correo`, `Contraseña`, `Telefono`, `TypeUsuer`, `Estado`) "
                + "VALUES ('"+usu.getRut()+"',"
                        + "'"+usu.getNombre()+"',"
                        + "'"+usu.getApellido()+"',"
                        + "'"+usu.getMail()+"',"
                        + "'"+usu.getPass()+"',"
                        + "'"+usu.getFono()+"',"
                        + "'"+usu.getTipo()+"',"
                        + "'"+usu.getEstado()+"')"
        );
        nu.CloseConexion();
    }
    
    public String [] ReadUno(String Rut){
        String sql = "SELECT * FROM `ususario` WHERE ususario.Rut = '"+Rut+"'";
        String [] Datos = new String[8];
        try {
            Conexion nu = new Conexion();
            
            Datos[0] = nu.ejecutaQuery(sql).getString("Rut");
            Datos[1] = nu.ejecutaQuery(sql).getString("Nombre");
            Datos[2] = nu.ejecutaQuery(sql).getString("Apellido");
            Datos[3] = nu.ejecutaQuery(sql).getString("Correo");
            Datos[4] = nu.ejecutaQuery(sql).getString("Contraseña");
            Datos[5] = nu.ejecutaQuery(sql).getString("Telefono");
            Datos[6] = nu.ejecutaQuery(sql).getString("TypeUsuer");
            Datos[7] = nu.ejecutaQuery(sql).getString("Estado");
            
            nu.CloseConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Datos;
    }
    
    public void ReadTodo(Usuario usu){
        String sql = "SELECT * FROM `ususario`";
        Conexion nu = new Conexion();
        nu.ejecutaQuery(sql);
        nu.CloseConexion();
    }
    
    public void Update(){
        
    }
    
    public void Delete(){
        
    }
}
