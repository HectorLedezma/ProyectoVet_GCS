package DTO;

public class Mascota {
    protected int NroChip;
    protected String Nombre;
    protected String Sexo;
    protected String Especie;
    protected String Raza;
    protected String RutDueño;
    protected int Estado;
    
    public Mascota(int NroChip, String Nombre, String Sexo, String Especie, String Raza, String RutDueño, int Estado){
        this.NroChip=NroChip;
        this.Nombre=Nombre;
        this.Sexo=Sexo;
        this.Especie=Especie;
        this.Raza=Raza;
        this.RutDueño=RutDueño;
        this.Estado= Estado;
    }
    
    public int getNroChip(){
        return NroChip;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public String getSexo(){
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
    
    public int getEstado(){
        return Estado;
    }
}
