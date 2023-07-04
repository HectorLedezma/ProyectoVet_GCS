package DAO;

import DTO.Atencion;
import DTO.Conexion;

public class Crud_Atencion {
    public void Create(Atencion at){
        Conexion nu = new Conexion();
        String SQL =  "INSERT INTO `atencion`("
                        + "`ID_atencion`, "//1
                        + "`ID_historial`, "//2
                        + "`Fecha`, "//3
                        + "`Hora`, "//4
                        + "`Peso_mascota`,"//5
                        + " `Edad`, "//6
                        + "`Diagnostico`, "//7
                        + "`Reseta`"//8
                    + ") "
                    + "VALUES ("
                        + at.getId()+","//1
                        + at.getHistorial_id()+","//2
                        + "'"+at.getFecha()+"',"//3
                        + "'"+at.getHora()+"',"//4
                        + "'"+at.getPeso()+"',"//5
                        + "'"+at.getEdad()+"',"//6
                        + "'"+at.getDiagnostico()+"',"//7
                        + "'"+at.getReceta()+"'"//8
                    + ");";
    }
}
