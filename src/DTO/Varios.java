package DTO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Varios {
    
    public String hashMD5(String pass){
        String newPass = "";
        try {
            // Crear una instancia de MessageDigest con el algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Convertir la cadena a bytes
            byte[] cadenaBytes = pass.getBytes();
            
            // Calcular el resumen (digest) de los bytes utilizando MD5
            byte[] resumen = md.digest(cadenaBytes);
            
            // Convertir el resumen a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : resumen) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Imprimir el resultado (cadena encriptada en MD5)
            newPass =  hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newPass;
    }
    
    public String hashSHA256(String pass){
        String newPass = "";
        try {
            // Crear una instancia de MessageDigest con el algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Convertir la cadena a bytes
            byte[] cadenaBytes = pass.getBytes();
            
            // Calcular el resumen (digest) de los bytes utilizando MD5
            byte[] resumen = md.digest(cadenaBytes);
            
            // Convertir el resumen a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : resumen) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Imprimir el resultado (cadena encriptada en MD5)
            newPass =  hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newPass;
    }
    
    public String fechaESP(){
        LocalDate date = LocalDate.now();
        String fecha = ""+date;
        return fecha;
    }
    
    public String fechaBD(){
        LocalDate date = LocalDate.now();
        int [] d = {
            date.getDayOfMonth(),
            date.getMonthValue(),
            date.getYear()
        };
        String fecha = d[0]+"-"+d[1]+"-"+d[2];
        return fecha;
    }
    
    public String hora(){
        LocalTime time = LocalTime.now();
        int hrs = time.getHour();
        int min = time.getMinute();
        int sec = time.getSecond();
        String hora = hrs+":"+min+":"+sec;
        return hora;
    }
    
    public boolean ValidaRUT(String rut){
        //System.out.println("Rut de entrada: "+rut);
        boolean ok = false;
        String sinSim = rut.replaceAll("[^0-9kK]", "");
        //System.out.println("Rut de sin simbolos: "+sinSim);
        String sinDV = sinSim.substring(0, sinSim.length() - 1);
        //System.out.println("Rut de sin DV: "+sinDV);
        String TUR = "";
        for(int i = sinDV.length()-1; i>=0; i--){
            //System.out.println(sinSim.length()-1);
            //System.out.println(i);
            TUR = TUR + sinDV.charAt(i);
        }
        //System.out.println("Rut invertido: "+TUR);
        int multi = 2;
        int suma = 0;
        for(int i = 0; i<TUR.length();i++){
            if(multi > 7){
                multi = 2;
            }
            suma = suma + (Integer.parseInt(""+TUR.charAt(i))*multi);
            multi = multi + 1;
        }
        int dv = 11-(suma%11);
        String dvu = ""+sinSim.charAt(sinSim.length()-1);
        //System.out.println(TUR);
        String dvr = "";
        if(dv==11){
            dvr = "0";
        }
        if(dv==10){
            dvr = "k";
        }
        
        ok = dvr.equals(dvu);
        
        return ok;
    }
}
