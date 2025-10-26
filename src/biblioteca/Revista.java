package biblioteca;

/**
 * Revista impresa que no es prestable para simplificar el ejemplo.
 * De esta forma demostramos que los servicios genéricos imponen límites de tipo.
 */
public class Revista extends Material {

    private final CategoriaMaterial categoria = CategoriaMaterial.REVISTA;

    public Revista(int id, String titulo, String autor, int anioPublicacion) {
        super(id, titulo, autor, anioPublicacion);
    }

    public CategoriaMaterial getCategoria() {
        return categoria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("[REVISTA] #%d %s (%d) - %s%n", id, titulo, anioPublicacion, autor);
    }

    @Override
    public String toString() {
        return "Revista{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }
}
