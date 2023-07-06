package DAO;

import DTO.Asistente;
import DTO.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudAsistente {
    
    private String jornada(String tj){
        if(tj.equals("1")){
            tj = "Full-time";
        }else{
            tj = "Part-time";
        }
        return tj;
    }
    
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
    
    public String [] ReadUno(String Rut){
        String [] Datos = new String[10];
        String sql = "SELECT * FROM `asistente`, `ususario` WHERE asistente.Rut = '"+Rut+"' AND asistente.Rut=ususario.Rut;";
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
            Datos[8] = nu.ejecutaQuery(sql).getString("TypeJornad");
            Datos[9] = nu.ejecutaQuery(sql).getString("HrEntrada");
            nu.CloseConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Datos;
    }
    
    
}
