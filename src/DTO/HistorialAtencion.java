package DTO;


public class HistorialAtencion {
    private int id;
    private int id_pet;
    private String rutVet;

    public HistorialAtencion(int id, int id_pet, String rutVet) {
        this.id = id;
        this.id_pet = id_pet;
        this.rutVet = rutVet;
    }

    public int getId() {
        return id;
    }

    public int getId_pet() {
        return id_pet;
    }

    public String getRutVet() {
        return rutVet;
    }
    
}
