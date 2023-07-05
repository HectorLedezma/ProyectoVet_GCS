package DTO;

public class PetOwner {
    private String rut;
    private String nombre;
    private String apellido;
    private String fono1;
    private String fono2;

    public PetOwner(String rut, String nombre, String apellido, String fono1, String fono2) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fono1 = fono1;
        this.fono2 = fono2;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFono1() {
        return fono1;
    }

    public String getFono2() {
        return fono2;
    }
    
}
