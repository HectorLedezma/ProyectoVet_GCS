package DTO;

import DAO.CrudPetOwner;
import java.util.Scanner;

public class Asistente extends Usuario{
    private int TipoJornada;
    private String HrInicio;

    public Asistente(int TipoJornada, String HrInicio, String rut, String nombre, String apellido, String mail, String pass, String fono, int tipo, int estado) {
        super(rut, nombre, apellido, mail, pass, fono, tipo, estado);
        this.TipoJornada = TipoJornada;
        this.HrInicio = HrInicio;
    }

    //menu para ingresar dueños
    public PetOwner IngresaDue(){
        PetOwner pt;
        Scanner Input = new Scanner(System.in);
        Varios x = new Varios();
        System.out.print("RUT del dueño: ");
        String rutd = Input.nextLine();
        while(!x.ValidaRUT(rutd)){
            System.out.println("RUT no valido");
            System.out.print("RUT del dueño: ");
            rutd = Input.nextLine();
        }
        CrudPetOwner cd = new CrudPetOwner();
        if((cd).ReadUno(rutd)[0] == null){
            System.out.print("Nombre del dueño: ");
            String nombre = Input.nextLine();
            System.out.print("Apellido del dueño: ");
            String apellido = Input.nextLine();
            System.out.print("Telefono 1 del Dueño: ");
            String fono1 = Input.nextLine();
            System.out.print("Telefono 2 del Dueño: ");
            String fono2 = Input.nextLine();
            pt = new PetOwner(rutd,nombre,apellido,fono1,fono2);
        }else{
            System.out.println("Ese dueño ya esta registrado en el sistema");
            pt = null;
        }
        
        //String rut = x.ValidaRUT(Input.nextLine());
        return pt;
    }
    
    //menu para ingresar mascotas
    public Mascota IngresaPet(String RD){
        Scanner ent = new Scanner(System.in);
        System.out.print("Nombre de la mascota: ");
        String nombre = ent.nextLine();
        int sexo;
        while(true){
            System.out.println("Sexo de la mascota: ");
            System.out.println("1) Macho");
            System.out.println("2) Hembra");
            sexo = ent.nextInt();
            ent.nextLine();
            if(sexo==2 || sexo==1){
                break;
            }else{
                System.out.println("Valor no valido");
            }
        }
        //String sexo = ent.nextLine();
        System.out.print("Especie de la mascota: ");
        String especie = ent.nextLine();
        System.out.print("Raza de la mascota: ");
        String raza = ent.nextLine();
        System.out.print("Codigo de chip de la mascota: ");
        String chip = ent.nextLine();
        return new Mascota(chip,nombre,sexo,especie,raza,RD,this.getRut());
    }
    
    
    public int getTipoJornada() {
        return TipoJornada;
    }

    public String getHrInicio() {
        return HrInicio;
    }
    
}
