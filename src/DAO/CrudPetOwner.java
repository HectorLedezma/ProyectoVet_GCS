package DAO;

import DTO.Conexion;
import DTO.PetOwner;

public class CrudPetOwner {
    public void Create(PetOwner due){
        Conexion nu = new Conexion();
        String sql = "INSERT INTO `dueño`("
                    + "`Rut`, "
                    + "`Nombre`, "
                    + "`Apellido`, "
                    + "`Fono1`, "
                    + "`Fono2`"
                + ") "
                + "VALUES ("
                    + "'"+due.getRut()+"',"
                    + "'"+due.getNombre()+"',"
                    + "'"+due.getApellido()+"',"
                    + "'"+due.getFono1()+"',"
                    + "'"+due.getFono2()+"'"
                + ");";
        
        nu.ejecutaVoidQuery(sql);
        nu.CloseConexion();
    }
}
