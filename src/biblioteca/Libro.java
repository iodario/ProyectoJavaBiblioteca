package biblioteca;

import java.time.LocalDate;

/**
 * Libro físico que además puede ser prestado, por eso implementa {@link Prestable}.
 * Al extender Material reutilizamos los campos comunes y dejamos que los servicios
 * genéricos trabajen con la jerarquía.
 */
public class Libro extends Material implements Prestable {

    private final GeneroLibro genero;
    private final CategoriaMaterial categoria = CategoriaMaterial.LIBRO;
    private EstadoPrestamo estado = EstadoPrestamo.DISPONIBLE;
    private LocalDate fechaVencimiento;

    /**
     * Crea un libro con un género específico.
     */
    public Libro(int id, String titulo, String autor, int anioPublicacion, GeneroLibro genero) {
        super(id, titulo, autor, anioPublicacion);
        this.genero = genero;
    }

    public GeneroLibro getGenero() {
        return genero;
    }

    public CategoriaMaterial getCategoria() {
        return categoria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("[LIBRO] #%d %s (%d) - %s [%s]%n", id, titulo, anioPublicacion, autor, genero);
    }

    @Override
    public void prestar(LocalDate hasta) {
        if (estado == EstadoPrestamo.PRESTADO) {
            throw new IllegalStateException("El libro ya está prestado");
        }
        estado = EstadoPrestamo.PRESTADO;
        fechaVencimiento = hasta;
    }

    @Override
    public void devolver() {
        estado = EstadoPrestamo.DISPONIBLE;
        fechaVencimiento = null;
    }

    @Override
    public EstadoPrestamo getEstado() {
        return estado;
    }

    @Override
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", genero=" + genero +
                ", estado=" + estado +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
