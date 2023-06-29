package DTO;

import java.util.Date;

public class Veterinario extends Usuario{
    private String titulo;
    private Date Inicio;

    public Veterinario(String titulo, Date Inicio, String rut, String nombre, String apellido, String mail, String pass, String fono, int tipo, int estado) {
        super(rut, nombre, apellido, mail, pass, fono, tipo, estado);
        this.titulo = titulo;
        this.Inicio = Inicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getInicio() {
        return Inicio;
    }
    
    
}
