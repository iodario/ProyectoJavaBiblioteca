package biblioteca;

//clase abstracta material
public abstract class Material implements Comparable<Material> {
    private static int contador = 1; // genera IDs únicos y consecutivos
    private final int id;            // inmutable una vez asignado
    private String titulo;  // Título del material
    private String autor;                // Autor del material
    private int anioPublicacion;         // Año de publicación
    private CategoriaMaterial categoria; // Categoría del material
    private EstadoPrestamo estado;       // Estado actual

    //constructor material
    public Material ( String titulo, String autor, int anioPublicacion, CategoriaMaterial categoria ){
        this.id = contador++; // autoincremental , se genera solo
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.categoria= categoria;
        this.estado= EstadoPrestamo.DISPONIBLE;   //por default comienza siendo disponible
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public CategoriaMaterial getCategoria() {
        return categoria;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }


    //metodos

    //Devuelve true unicamente cuando el atributo estado del objeto Material es igual a EstadoPrestamo.DISPONIBLE.
    public boolean estaDisponible(){
                return estado == EstadoPrestamo.DISPONIBLE;
    }

    //Devuelve true si está prestado, false si está disponible.
    public boolean estaPrestado() {
        return estado == EstadoPrestamo.PRESTADO;
    }

    public void prestar(){
        if(estaDisponible()){
            estado = EstadoPrestamo.PRESTADO;
        }else{
            System.out.println("no esta disponible");
        }
    }

    public void devolver() {
        if (!estaDisponible()) {
            setEstado(EstadoPrestamo.DISPONIBLE);
        }
    }

    /** Ordenar por titulo */
    @Override
    public int compareTo(Material otro) {
        String titulo = this.titulo;
        String otroTitulo = otro.titulo;
        return titulo.compareToIgnoreCase(otroTitulo);
    }
    // compareTo devuelve un int:
//   < 0  → this va ANTES (es "menor" que el objeto comparado)
//   = 0  → Son IGUALES para efectos de ordenación
//   > 0  → this va DESPUÉS (es "mayor" que el objeto comparado)


    @Override
    public String toString() {
        // %d = entero, %-30s = string alineado a la izquierda en 30 caracteres
        return String.format(
                "#%-3d | %-30s | %-20s | %4d | %-10s | %-11s ",
                id,
                titulo,
                autor,
                anioPublicacion,
                categoria,
                (estado == EstadoPrestamo.DISPONIBLE ? "DISPONIBLE" : "PRESTADO")

        );
    }



}

