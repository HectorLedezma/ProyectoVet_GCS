package DAO;

import DTO.Conexion;
import java.sql.ResultSet;
import DTO.Mascota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudMascota {
    
    public void Create(Mascota masc){
        try{
            Conexion nu = new Conexion();
            nu.ejecutaVoidQuery(
                      "INSERT INTO `mascota`(`NroChip`, `NombrePet`, `Sexo`, `Especie`, `Raza`, `RutDueño`,`RutAsistente`)"
                    + "VALUES ('"+masc.getNroChip()+"',"
                            + "'"+masc.getNombre()+"',"
                            + ""+masc.getSexo()+","
                            + "'"+masc.getEspecie()+"',"
                            + "'"+masc.getRaza()+"',"
                            + "'"+masc.getRutDueño()+"',"
                            + "'"+masc.getRutAs()+"')"
            );
            nu.CloseConexion();
        } catch (Exception ex) {
            Logger.getLogger(CrudMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String [] ReadUno(String Nro){
        String sql = "SELECT * FROM `mascota` WHERE mascota.ID_Ficha = '"+Nro+"'";
        String [] Datos = new String[9];
        try {
            Conexion nu = new Conexion();
            
                Datos[0] = nu.ejecutaQuery(sql).getString("ID_Ficha");
                Datos[1] = nu.ejecutaQuery(sql).getString("NroChip");
                Datos[2] = nu.ejecutaQuery(sql).getString("NombrePet");
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
    
    public ArrayList <String []> buscaXDueño(String rd){
        String sql =  "SELECT * "
                    + "FROM "
                        + "`mascota`,`dueño` "
                    + "WHERE "
                        + "mascota.RutDueño='"+rd+"' AND mascota.RutDueño = dueño.Rut;";
        
        ArrayList <String []> tabla = new ArrayList<>();
        
        try{
            Conexion nu = new Conexion();
            ResultSet res = nu.ejecutaQuery(sql);
            do{
                String [] colum = new String[15];
                for(int i = 0; i<15;i++){
                    //System.out.println("columna: "+i);
                    colum[i] = res.getString(i+1);
                }
                //System.out.println((j)+""+Arrays.toString(colum));
                tabla.add(colum);
            }while(res.next());
        }catch (SQLException ex) {
            System.out.println(ex);
        }
        return tabla;
    }
}
