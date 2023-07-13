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
import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println("=======================Login======================");
        while(true){
            while(true){
                System.out.println("Ingrese el rut de usuario:");
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
        
        
    }
    
    public void MenuAsistente(Asistente us){
        boolean exit = false;
        while(!exit){
            System.out.println("=================================================");
            System.out.println("=====Menu Asisitente: "+us.getNombre()+"=====");
            System.out.println("=================================================");
            Scanner Input = new Scanner(System.in);
            Varios X = new Varios();
            CrudMascota cpt = new CrudMascota();
            CrudPetOwner cpo = new CrudPetOwner();
            //System.out.println("Bienvenido "+us.getNombre());
            System.out.println("Por favor ingrse una opcion: ");
            int op2;
            while(true){
                System.out.println("1) crear ficha de mascota");
                System.out.println("2) ver ficha de mascota");
                System.out.println("3) Salir");
                int op1 = Input.nextInt();
                if(op1 > 0 && op1 <=3){
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
                    Mascota pet;

                    String [] DatoDue = new String[5];
                    while(true){
                        while(true){
                            System.out.println("Nuevo dueño?");
                            System.out.println("1)SI   //   2)NO");
                            String op3 = Input.next();
                            if(op3.equals("1") || op3.equals("2")){
                                op4 = op3.equals("1");
                                break;
                            }else{
                                System.out.println("Opcion no valida");
                            }
                        }

                        

                        if(op4){//dueño nuevo
                            PetOwner PetO = us.IngresaDue();
                            if(PetO != null){
                                cpo.Create(PetO);
                                DatoDue = cpo.ReadUno(PetO.getRut());
                            }else{
                                //el dueño existe 
                                System.out.println("Intentar otra vez:\n 1->SI\n 2->NO");
                                String again = Input.next();
                                //si = ingresar dueño no existente
                                //no = ingresar dueño existente
                                if(again.equals("1") && again.equals("2")){
                                    if(again.equals("2")){
                                        op4 = false;
                                        break;
                                    }else{
                                        op4 = true;
                                    }
                                    //break;
                                }else{
                                    System.out.println("Opcion no valida");
                                }
                                
                            }
                        }else{
                            break;
                        }
                        
                    }
                    if(!op4){//dueño antiguo
                        String drut;
                        //Input.nextLine();
                        while(true){
                            System.out.print("Ingrese el Rut del dueño: ");
                            drut = Input.next();
                            if(X.ValidaRUT(drut)){
                                break;
                            }else{
                                System.out.println("Rut no valido");
                            }
                        }
                        DatoDue = cpo.ReadUno(drut);
                    }
                    
                    System.out.println("Ingese los datos de la mascota.");
                    pet = us.IngresaPet(DatoDue[0]);
                    //
                    System.out.println("Nombre: "+pet.getNombre());
                    System.out.println("Rut Dueño: "+pet.getRutDueño());
                    //
                    cpt.Create(pet);
                }case 2->{
                    String dueRUT;
                    while(true){
                        System.out.println("Ingrese rut del dueño: ");
                        dueRUT = Input.next();
                        if(X.ValidaRUT(dueRUT)){
                            if(cpo.ReadUno(dueRUT)[0] == null){
                                System.out.println("ese dueño no existe");
                            }else{
                                //System.out.println("Dueño "+dueñoData[1]+" "+dueñoData[2]);
                                break;
                            }
                        }else{
                            System.out.println("RUT no valido");
                        }
                    }
                    ArrayList <String []> tabla=cpt.buscaXDueño(dueRUT);
                    while(true){
                        System.out.println("Mascotas de "+cpo.ReadUno(dueRUT)[1]+":");
                        System.out.println("Seleciona la mascota para ver la ficha: ");
                        for(int i = 0; i<tabla.size();i++){
                            System.out.println((i+1)+"- "+tabla.get(i)[2]);
                        }
                        int SelPet = Input.nextInt();
                        if(SelPet>=1&&SelPet<=tabla.size()){
                            String estado;
                            String sexo;
                            if(tabla.get(SelPet-1)[3].equals("1")){
                                sexo = "Macho";
                            }else{
                                sexo = "Hembra";
                            }
                            if(tabla.get(SelPet-1)[9].equals("1")){
                                estado = "Ok";
                            }else{
                                estado = "Inactivo";
                            }
                            System.out.println("Ficha: N°"+tabla.get(SelPet-1)[0]);
                            System.out.println("Nombre de la Mascota: "+tabla.get(SelPet-1)[2]);
                            System.out.println("Codigo Chip: "+tabla.get(SelPet-1)[1]);
                            System.out.println("Especie: "+tabla.get(SelPet-1)[4]);
                            System.out.println("Raza: "+tabla.get(SelPet-1)[5]);
                            System.out.println("Sexo: "+sexo);
                            System.out.println("Estado de la Mascota: "+estado);
                            System.out.println("Nombre del dueño: "+tabla.get(SelPet-1)[11]+" "+tabla.get(SelPet-1)[12]);
                            System.out.println("Rut del dueño: "+tabla.get(SelPet-1)[10]);
                            System.out.println("1er contacto con el dueño: "+tabla.get(SelPet-1)[13]);
                            System.out.println("2do contacto con el dueño: "+tabla.get(SelPet-1)[14]);
                            System.out.println("\n");
                            System.out.println("Continuar:\n 1->SI\n 2->NO");
                            int cont = Input.nextInt();
                            if(cont >= 1 && cont <=2){
                                if(cont == 2){
                                    break;
                                }
                            }else{
                                System.out.println("Opcion no valida");
                            }
                        }else{
                            System.out.println("Opcion no valida");
                        }
                    }
                    
                    
                    
                    
                    
                }case 3->{
                    exit = true;
                }
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
        System.out.println("4) Salir");
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
        //PV.MenuAdministrador();
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
