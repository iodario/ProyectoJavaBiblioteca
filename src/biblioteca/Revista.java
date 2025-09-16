package biblioteca;

public class Revista extends Material{
    //atributos de la subclase
    //no hay

    //constructor de la subclase
    public Revista ( String titulo, String autor, int anio){
        super(titulo, autor, anio, CategoriaMaterial.REVISTA);
    }

    //toString

    @Override
    public String toString() {
        return super.toString()  + " Revista -";
    }
}
