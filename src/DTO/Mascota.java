package DTO;

public class Mascota {
    protected String NroChip;
    protected String Nombre;
    protected int Sexo;
    protected String Especie;
    protected String Raza;
    protected String RutDueño;
    protected String RutAs;
    
    public Mascota(String NroChip, String Nombre, int Sexo, String Especie, String Raza, String RutDueño,String RutAs){
        this.NroChip=NroChip;
        this.Nombre=Nombre;
        this.Sexo=Sexo;
        this.Especie=Especie;
        this.Raza=Raza;
        this.RutDueño=RutDueño;
        this.RutAs=RutAs;
    }
    
    public String getNroChip(){
        return NroChip;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public int getSexo(){
        return Sexo;
    }
    
    public String getEspecie(){
        return Especie;
    }
    
    public String getRaza(){
        return Raza;
    }
    
    public String getRutDueño(){
        return RutDueño;
    }

    public String getRutAs() {
        return RutAs;
    }
    
    
}
