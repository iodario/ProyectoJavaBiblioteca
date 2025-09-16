package biblioteca;

public class Ebook extends Material implements LeibleOnline {
        //atributos de la subclase
        // no hay

        //constructor de la subclase
        public Ebook (String titulo, String autor, int anio){
            super(titulo, autor, anio, CategoriaMaterial.EBOOK);
        }

        //metodos abstractos
    @Override
    public void leer() {
        System.out.println("Leyendo eBook: " + getTitulo());
    }

    //to String
    @Override
    public String toString() {
        return super.toString()  + " Ebook leible online - ";
    }
}
