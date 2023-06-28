package proyectovet;

import DTO.Conexion;
import DTO.Usuario;
import DTO.Varios;
import java.sql.Connection;
import java.util.Scanner;
public class ProyectoVet {

    public void UserManage(){
        System.out.println("=================================================");
        System.out.println("================Gestion de Ususario==============");
        System.out.println("=================================================");
        System.out.println("1) Ingresar");
        System.out.println("2) Ver uno");
        System.out.println("3) Ver Todo");
        
        Scanner Input = new Scanner(System.in);
        
        int op = Input.nextInt();
        Varios X = new Varios();
        switch(op){
            case 1->{
                String rut = Input.nextLine();
                while(!X.ValidaRUT(rut)){
                    System.out.println("Rut invalido");
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        
    }
    
    
    
}
