package proyectovet;

import DAO.CrudAsistente;
import DAO.CrudMascota;
import DAO.CrudPetOwner;
import DAO.CrudUser;
//import DAO.CrudVeterinario;
import DTO.Asistente;
//import DTO.Conexion;
import DTO.Mascota;
import DTO.PetOwner;
import DTO.Usuario;
import DTO.Varios;
import DTO.Veterinario;
//import java.sql.Connection;
//import java.util.Arrays;
import java.util.Scanner;
public class ProyectoVet {

    
    public void Login(){
        Scanner Input = new Scanner(System.in);
        Varios X = new Varios();
        String rut = "";
        String pas;
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
            String [] usData;
            switch(tipo){
                case 1 ->{//menu Asistente
                    CrudAsistente as = new CrudAsistente();
                    usData = as.ReadUno(rut);
                    MenuAsistente(new Asistente(Integer.parseInt(usData[8]),usData[9],usData[0],usData[1],usData[2],usData[3],usData[4],usData[5],Integer.parseInt(usData[6]),Integer.parseInt(usData[7])));
                }
                case 2 ->{//menu Veterinario
                    //CrudVeterinario vt = new CrudVeterinario();
                    //usData = vt.ReadUno(rut);
                    //MenuVeterinario();
                }
                case 3 ->{
                    
                }
                case 4 ->{
                    MenuAdministrador();
                }
            }
        }else{
            System.out.println("Contraseña incorrecta");
        }
        
    }
    
    public void MenuAsistente(Asistente us){
        Scanner Input = new Scanner(System.in);
        CrudMascota cpt = new CrudMascota();
        CrudPetOwner cpo = new CrudPetOwner();
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
                Varios X = new Varios();
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
                
                Mascota pet;
                
                String [] DatoDue = new String[5];
                if(op4){//dueño nuevo
                    PetOwner PetO = us.IngresaDue();
                    if(PetO != null){
                        cpo.Create(PetO);
                        DatoDue = cpo.ReadUno(PetO.getRut());
                    }else{
                        op4 = false;
                    }
                }
                if(!op4){//dueño antiguo
                    System.out.print("Ingrese el Rut del dueño: ");
                    String drut = Input.nextLine();
                    //Input.nextLine();
                    while(!X.ValidaRUT(drut)){
                        System.out.println("Rut no valido");
                        System.out.print("Ingrese el Rut del dueño: ");
                        drut = Input.nextLine();
                        
                    }
                    DatoDue = cpo.ReadUno(drut);
                }
                System.out.println("Ingese los datos de la mascota.");
                pet = us.IngresaPet(DatoDue[0]);
                cpt.Create(pet);
            }case 2->{
                
            }
        }
    }
    
    public void MenuVeterinario(Veterinario us){
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
        while(true){
            System.out.println("1) Asistente");
            System.out.println("2) Veterinario");
            System.out.println("3) Practicante");
            System.out.println("4) Administrador");
            System.out.print("Ingrese el tipo de usuario: ");
            tipo = Input.nextInt();
            if(tipo<=4 && tipo >=1){
                break;
            }else{
                System.out.println("Valor no Valido");
            }
        }
        
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
            }
            case 2->{
            }
            case 3->{
            }
            case 4->{
                Usuario user = new Usuario(rut,nombre,apellido,correo,X.hashSHA256(pass),telefono,tipo,estado);
                CrudUser nus = new CrudUser();
                nus.Create(user);
            }
        }
    }
    
    public static void main(String[] args) {
        ProyectoVet PV = new ProyectoVet();
        PV.Login();
        //PV.UserManage();
        //Varios X = new Varios();
        //System.out.println(X.hashSHA256("Contraseña"));
        //Conexion con = new Conexion();
        //Scanner Input = new Scanner(System.in);
        //String rut = Input.nextLine();
        //CrudPetOwner du = new CrudPetOwner();
        //String r = du.ReadUno(rut)[0];
        //boolean e =r;
        //System.out.println(r == null);
        //System.out.println(X.ValidaRUT(rut));
        //CrudAsistente cu = new CrudAsistente();
        //System.out.println(Arrays.toString(cu.ReadUno(rut)));
        //PV.MenuAdministrador();
    }
    
    
    
}
