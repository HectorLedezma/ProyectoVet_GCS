package DAO;

import DTO.Conexion;
import DTO.Usuario;

public class CrudUser {
    
    
    public void Create(Usuario usu){
        Conexion nu = new Conexion();
        nu.ejecutaQuery(
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
    
    public void ReadTodo(Usuario usu){
        String sql = "SELECT * FROM `ususario` WHERE ususario.Rut = "+usu.getRut();
        Conexion nu = new Conexion();
        nu.ejecutaQuery(sql);
        nu.CloseConexion();
    }
    
    public void Update(){
        
    }
    
    public void Delete(){
        
    }
}
