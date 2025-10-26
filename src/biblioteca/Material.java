package biblioteca;

import java.util.Objects;

/**
 * Representa un material genérico dentro de la biblioteca.
 * Sirve como base para que los repositorios parametrizados con Material funcionen
 * con cualquier subtipo concreto.
 */
public abstract class Material {
    /** Identificador único del material. */
    protected int id;
    /** Título del material que verán las personas usuarias. */
    protected String titulo;
    /** Autoría principal del material. */
    protected String autor;
    /** Año de publicación para ordenar cronológicamente. */
    protected int anioPublicacion;

    /**
     * Crea un material con sus datos básicos.
     *
     * @param id identificador único del material.
     * @param titulo título descriptivo.
     * @param autor autor o autora principal.
     * @param anioPublicacion año en que se publicó.
     */
    protected Material(int id, String titulo, String autor, int anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Muestra los detalles específicos del material.
     * Las subclases completan esta operación para añadir información propia.
     */
    public abstract void mostrarDetalles();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Material material)) {
            return false;
        }
        return id == material.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
