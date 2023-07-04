package DAO;

import DTO.Conexion;
import DTO.HistorialAtencion;

public class CrudHistorial {
    public void Create(HistorialAtencion ha){
        Conexion nu = new Conexion();
        String SQL =  "historialatencion`(`ID_historial`, `ID_Mascota`, `RutVeterinario`) "
                + "VALUES ("+ha.getId()+","+ha.getId_pet()+",'"+ha.getRutVet()+"');";
        nu.ejecutaVoidQuery(SQL);
        nu.CloseConexion();
    }
}
