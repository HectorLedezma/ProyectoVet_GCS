package DAO;

import DTO.Conexion;
import DTO.Mascota;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudMascota {
    
    public void Create(Mascota masc){
        Conexion nu = new Conexion();
        nu.ejecutaVoidQuery(
                  "INSERT INTO `mascota`(`NroChip`, `Nombre`, `Sexo`, `Especie`, `Raza`, `RutDueño`,`RutAsistente`, `Estado`)"
                + "VALUES ('"+masc.getNroChip()+"',"
                        + "'"+masc.getNombre()+"',"
                        + ""+masc.getSexo()+","
                        + "'"+masc.getEspecie()+"',"
                        + "'"+masc.getRaza()+"',"
                        + "'"+masc.getRutDueño()+"',"
                        + "'"+masc.getRutAs()+"')"
        );
        nu.CloseConexion();
    }
    
    public String [] ReadUno(String Nro){
        String sql = "SELECT * FROM `mascota` WHERE mascota.ID_Ficha = '"+Nro+"'";
        String [] Datos = new String[9];
        try {
            Conexion nu = new Conexion();
            
            Datos[0] = nu.ejecutaQuery(sql).getString("ID_Ficha");
            Datos[1] = nu.ejecutaQuery(sql).getString("NroChip");
            Datos[2] = nu.ejecutaQuery(sql).getString("Nombre");
            Datos[3] = nu.ejecutaQuery(sql).getString("Sexo");
            Datos[4] = nu.ejecutaQuery(sql).getString("Especie");
            Datos[5] = nu.ejecutaQuery(sql).getString("Raza");
            Datos[6] = nu.ejecutaQuery(sql).getString("RutDueño");
            Datos[7] = nu.ejecutaQuery(sql).getString("RutAsistente");
            Datos[8] = nu.ejecutaQuery(sql).getString("Estado");
            
            nu.CloseConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CrudMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Datos;
    }
    public void ReadTodo(Mascota masc){
        String sql = "SELECT * FROM `mascota`";
        Conexion nu = new Conexion();
        nu.ejecutaQuery(sql);
        nu.CloseConexion();
    }    
    public void Update(String NroChip){
        
        
    }
    
    public void Delete(String NroChip){
        String sql ="DELETE FROM `mascota` WHERE mascota.NroChip = '"+NroChip+"'";
        Conexion nu = new Conexion();
        nu.ejecutaQuery(sql);
        nu.CloseConexion();
    }
}
