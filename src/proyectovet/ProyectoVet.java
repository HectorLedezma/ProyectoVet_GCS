package proyectovet;

import DAO.CrudAsistente;
import DAO.CrudUser;
import DTO.Asistente;
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
        System.out.print("Ingrese una opcion: ");
        int op = Input.nextInt();
        
        switch(op){
            case 1->{
                IngresaUsu();
            }
        }
    }
    
    public void IngresaUsu(){
        String rut;
        String nombre;
        String apellido;
        String correo;
        String pass;
        String telefono;
        int tipo;
        int estado;
        
        Varios X = new Varios();
        Scanner Input = new Scanner(System.in);
        System.out.print("Ingrese un RUT: ");
        rut = Input.next();
        while(!X.ValidaRUT(rut)){
            System.out.println("RUT invalido");
            System.out.print("Ingrese un RUT de nuevo: ");
            rut = Input.next();
        }
        System.out.print("Ingrese el nombre: ");
        nombre = Input.next();
        System.out.print("Ingrese el apellido: ");
        apellido = Input.next();
        System.out.print("Ingrese el correo: ");
        correo = Input.next();
        System.out.print("Ingrese la contraseña: ");
        pass = Input.next();
        System.out.print("Ingrese el numero de telefono: ");
        telefono = Input.next();
        while(true){
            System.out.println("1) Activo");
            System.out.println("2) Inactivo");
            System.out.print("Ingrese el el estado del ususario: ");
            estado = Input.nextInt();
            if(estado > 0 && estado <= 2){
                break;
            }else{
                System.out.println("valor ingresado no valido");
            }
        }
        System.out.println("1) Asistente");
        System.out.println("2) Veterinario");
        System.out.println("3) Practicante");
        System.out.println("4) Administrador");
        System.out.print("Ingrese el tipo de usuario: ");
        tipo = Input.nextInt();
        while(true){
            switch(tipo){
                case 1->{
                    int tJor;
                    String HrIni;
                    while(true){
                        System.out.println("1) Full-time");
                        System.out.println("2) Part-time");
                        System.out.print("Ingrese el tipo de jornada: ");
                        tJor = Input.nextInt();
                        if(tJor > 0 && tJor <= 2){
                            break;
                        }else{
                            System.out.println("valor ingresado no valido");
                        }
                    }
                    System.out.println("Ingrese el horario de entrada: ");
                    System.out.print("Hora: ");
                    int hr = Input.nextInt();
                    System.out.print("Minutos: ");
                    int min = Input.nextInt();
                    HrIni = hr+":"+min+":"+"00";
                    Asistente as = new Asistente(tJor,HrIni,rut,nombre,apellido,correo,X.hashSHA256(pass),telefono,tipo,estado);
                    CrudAsistente nas = new CrudAsistente();
                    nas.create(as);
                    break;
                }
                case 2->{
                    break;
                }
                case 3->{
                    break;
                }
                case 4->{
                    Usuario user = new Usuario(rut,nombre,apellido,correo,X.hashSHA256(pass),telefono,tipo,estado);
                    CrudUser nus = new CrudUser();
                    nus.Create(user);
                    break;
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        ProyectoVet PV = new ProyectoVet();
        PV.UserManage();
        //Varios X = new Varios();
        //System.out.println(X.hashSHA256("Contraseña"));
        
    }
    
    
    
}
