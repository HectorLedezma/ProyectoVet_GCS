package DTO;

import java.util.Date;

        
public class Atencion {
    private int id;
    private int historial_id;
    private Date fecha;
    private String hora;
    private float peso;
    private int edad;
    private String diagnostico;
    private String receta;

    public Atencion(int id, int historial_id, Date fecha, String hora, float peso, int edad, String diagnostico, String receta) {
        this.id = id;
        this.historial_id = historial_id;
        this.fecha = fecha;
        this.hora = hora;
        this.peso = peso;
        this.edad = edad;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    public int getId() {
        return id;
    }

    public int getHistorial_id() {
        return historial_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public float getPeso() {
        return peso;
    }

    public int getEdad() {
        return edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getReceta() {
        return receta;
    }
    
    
}
