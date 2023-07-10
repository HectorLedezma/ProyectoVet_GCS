package DTO;

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
    public Mascota IngresaPet(String RD){
        Scanner ent = new Scanner(System.in);
        System.out.print("Nombre de la mascota: ");
        String nombre = ent.nextLine();
        int sexo;
        while(true){
            System.out.print("Sexo de la mascota: ");
            System.out.println("1) Macho");
            System.out.println("2) Hembra");
            sexo = ent.nextInt();
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
