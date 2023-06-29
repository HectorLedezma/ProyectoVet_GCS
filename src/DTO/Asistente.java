package DTO;

public class Asistente extends Usuario{
    private int TipoJornada;
    private String HrInicio;

    public Asistente(int TipoJornada, String HrInicio, String rut, String nombre, String apellido, String mail, String pass, String fono, int tipo, int estado) {
        super(rut, nombre, apellido, mail, pass, fono, tipo, estado);
        this.TipoJornada = TipoJornada;
        this.HrInicio = HrInicio;
    }

    public int getTipoJornada() {
        return TipoJornada;
    }

    public String getHrInicio() {
        return HrInicio;
    }
    
}
