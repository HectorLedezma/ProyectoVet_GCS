package proyectovet;

import DAO.CrudAsistente;
import DAO.CrudPetOwner;
import DAO.CrudUser;
import DTO.Asistente;
import DTO.Conexion;
import DTO.Mascota;
import DTO.PetOwner;
import DTO.Usuario;
import DTO.Varios;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;
public class ProyectoVet {

    
    public void Login(){
        Scanner Input = new Scanner(System.in);
        Varios X = new Varios();
        String rut = "";
        String pas = "";
        String [] user;
        CrudUser check = new CrudUser();
        System.out.println("==================================================");
        System.out.println("===========Veterinaria de Dr. Eutanasia===========");
        System.out.println("==================================================\n");
        while(true){
            System.out.println("Ingrese su rut:");
            rut = Input.nextLine();
            if(X.ValidaRUT(rut)){
                break;
            }else{
                System.out.println("RUT no valido");
            }
        }
        System.out.println("Ingrese su contraseña:");
        pas = Input.nextLine();
        pas = X.hashSHA256(pas);
        user = check.ReadUno(rut);
        String contra = user[4];
        if(pas.equals(contra)){
            int tipo = Integer.parseInt(user[6]);
            switch(tipo){
                case 1 ->{
                    CrudAsistente as = new CrudAsistente();
                    String [] asData = as.ReadUno(rut);
                    MenuAsistente(new Asistente(Integer.parseInt(asData[8]),asData[9],asData[0],asData[1],asData[2],asData[3],asData[4],asData[5],Integer.parseInt(asData[6]),Integer.parseInt(asData[7])));
                }
                case 2 ->{
                    MenuVeterinario();
                }
                case 3 ->{
                    
                }
                case 4 ->{
                    MenuAdministrador();
                }
            }
        }
        
    }
    
    public void MenuAsistente(Asistente us){
        Scanner Input = new Scanner(System.in);
        System.out.println("Bienvenido "+us.getNombre());
        System.out.println("Por favor ingrse una opcion: ");
        int op2;
        while(true){
            System.out.println("1) crear ficha de mascota");
            System.out.println("2) ver ficha de mascota");
            int op1 = Input.nextInt();
            if(op1 > 0 && op1 <=2){
                op2 = op1;
                break;
            }else{
                System.out.println("Opcion no valida");
                System.out.println("Por favor ingrse una opcion valida: ");
            }
        }
        switch(op2){
            case 1->{
                boolean op4 = false;
                while(true){
                    System.out.println("Nuevo dueño?");
                    System.out.println("1)SI   //   2)NO");
                    int op3 = Input.nextInt();
                    if(op3 > 0 && op3 <=2){
                        if(op3 == 1){
                            op4 = true;
                        }
                        break;
                    }else{
                        System.out.println("Opcion no valida");
                    }
                }
                PetOwner PetO;
                CrudPetOwner cpo = new CrudPetOwner();
                String [] DatoDue;
                Varios X = new Varios();
                if(op4){//dueño nuevo
                    PetO = IngresaDue();
                    cpo.Create(PetO);
                    DatoDue = cpo.ReadUno(PetO.getRut());
                }else{//dueño antiguo
                    System.out.print("Ingrese el Rut del dueño: ");
                    String drut = Input.nextLine();
                    while(!X.ValidaRUT(drut)){
                        System.out.println("Rut no valido");
                        System.out.print("Ingrese el Rut del dueño: ");
                        drut = Input.nextLine();
                    }
                    DatoDue = cpo.ReadUno(drut);
                    Mascota pet;
                }
                
                
                System.out.println("Ingese datos del dueño de la mascota.");
                
            }case 2->{
                
            }
        }
    }
    
    public void MenuVeterinario(){
        System.out.println("Menu de ");
    }
    
    public void MenuAdministrador(){
        System.out.println("=================================================");
        System.out.println("================Gestion de Ususario==============");
        System.out.println("=================================================");
        System.out.println("1) Ingresar usuario");
        System.out.println("2) Ver un usuario");
        System.out.println("3) Ver todos los usuarios");
        
        Scanner Input = new Scanner(System.in);
        System.out.print("Ingrese una opcion: ");
        int op = Input.nextInt();
        
        switch(op){
            case 1->{
                IngresaUsu();
            }
        }
    }
    //menu para ingresar usuarios
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
                    String HrIni = "";
                    while(true){
                        System.out.println("1) Full-time");
                        System.out.println("2) Part-time");
                        System.out.print("Ingrese el tipo de jornada: ");
                        tJor = Input.nextInt();
                        if(tJor > 0 && tJor <= 2){
                            if (tJor == 2){
                                System.out.println("Ingrese el horario de entrada: ");
                                int hr;
                                while(true){
                                    System.out.print("Hora: ");
                                    hr = Input.nextInt();
                                    if(hr <= 18 && hr >= 9){
                                        break;
                                    }else{
                                        System.out.println("Hora incorrecta");
                                        System.out.println("La hora de llegada debe ser de entre 9 hrs. a 18 hrs.");
                                    }
                                }
                                int min;
                                while(true){
                                    System.out.print("Minutos: ");
                                    min = Input.nextInt();
                                    if(min < 60 && min >= 0){
                                        break;
                                    }else{
                                        System.out.println("Minuto no valido");
                                        System.out.println("Los minutos deben estar entre 0 a 59");
                                    }
                                }
                                HrIni = hr+":"+min+":"+"00";
                            }else{
                                HrIni = "9:00:00";
                            }
                            break;
                        }else{
                            System.out.println("valor ingresado no valido");
                        }
                    }
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
    
    //menu para ingresar dueños
    public PetOwner IngresaDue(){
        Scanner Input = new Scanner(System.in);
        Varios x = new Varios();
        System.out.print("Nombre del dueño: ");
        String nombre = Input.nextLine();
        System.out.print("Apellido del dueño: ");
        String apellido = Input.nextLine();
        System.out.print("RUT del dueño: ");
        String rut = Input.nextLine();
        while(!x.ValidaRUT(rut)){
            System.out.println("RUT no valido");
            System.out.print("RUT del dueño: ");
            rut = Input.nextLine();
        }
        System.out.print("Telefono 1 del Dueño: ");
        String fono1 = Input.nextLine();
        System.out.print("Telefono 2 del Dueño: ");
        String fono2 = Input.nextLine();
        
        //String rut = x.ValidaRUT(Input.nextLine());
        return new PetOwner(rut,nombre,apellido,fono1,fono2);
    }
    
    //menu para ingresar mascotas
    public void IngresaPet(){
        
    }
    
    public static void main(String[] args) {
        //ProyectoVet PV = new ProyectoVet();
        //PV.Login();
        //PV.UserManage();
        //Varios X = new Varios();
        //System.out.println(X.hashSHA256("Contraseña"));
        //Conexion con = new Conexion();
        Scanner Input = new Scanner(System.in);
        String rut = Input.nextLine();
        CrudAsistente cu = new CrudAsistente();
        System.out.println(Arrays.toString(cu.ReadUno(rut)));
    }
    
    
    
}
