package DAO;

import DTO.Asistente;
import DTO.Conexion;

public class CrudAsistente {
    public void create(Asistente as){
        CrudUser cu = new CrudUser();
        cu.Create(as);
        Conexion nu = new Conexion();
        String sql = "INSERT INTO `asistente`(`Rut`, `TypeJornad`, `HrEntrada`) "
                   + "VALUES ('"+as.getRut()+"',"
                   + "'"+as.getTipoJornada()+"',"
                   + "'"+as.getHrInicio()+"')";
        nu.ejecutaVoidQuery(sql);
        nu.CloseConexion();
    }
}
