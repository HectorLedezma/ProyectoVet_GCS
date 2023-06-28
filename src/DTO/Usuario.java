package DTO;

public class Usuario {
    protected String rut;
    protected String nombre;
    protected String apellido;
    protected String mail;
    protected String pass;
    protected String fono;
    protected int tipo;
    protected int estado;

    public Usuario(String rut, String nombre, String apellido, String mail, String pass, String fono, int tipo, int estado) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.pass = pass;
        this.fono = fono;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    
    
    
}
