package DAO;

import DTO.Conexion;
import DTO.PetOwner;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public String [] ReadUno(String Rut){
        String sql = "SELECT * FROM `dueño` WHERE dueño.Rut = '"+Rut+"'";
        String [] Datos = new String[5];
        try {
            Conexion nu = new Conexion();
            
            Datos[0] = nu.ejecutaQuery(sql).getString("Rut");
            Datos[1] = nu.ejecutaQuery(sql).getString("Nombre");
            Datos[2] = nu.ejecutaQuery(sql).getString("Apellido");
            Datos[3] = nu.ejecutaQuery(sql).getString("Fono1");
            Datos[4] = nu.ejecutaQuery(sql).getString("Fono2");
            nu.CloseConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Datos;
    }
    
}
