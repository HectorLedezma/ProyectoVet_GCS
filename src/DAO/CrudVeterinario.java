package DAO;

import DTO.Conexion;
import DTO.Usuario;

public class CrudVeterinario {
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
    
}
