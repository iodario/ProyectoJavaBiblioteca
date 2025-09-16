package biblioteca;

public class Libro extends Material{
        //atributos de la subclase
        private GeneroLibro genero;   // invoca al Enum

        //constructor de la subclase
        public Libro(String titulo, String autor, int anio, GeneroLibro genero){
            super(titulo, autor, anio, CategoriaMaterial.LIBRO );   //invoca al constructor padre
            this.genero = genero;
        }

        //getters y setters de la subclase
    public GeneroLibro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLibro genero) {
        this.genero = genero;
    }

        //toString
    @Override
    public String toString() {
            return super.toString() + " Genero Libro:  "+genero;
    }


}
