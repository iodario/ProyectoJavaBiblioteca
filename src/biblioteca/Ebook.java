package biblioteca;

/**
 * Representa un libro digital que se puede leer en línea.
 * Implementa {@link LeibleOnline} para que el servicio genérico de lectura obtenga URLs.
 */
public class Ebook extends Material implements LeibleOnline {

    private final CategoriaMaterial categoria = CategoriaMaterial.EBOOK;
    private final String urlLectura;

    public Ebook(int id, String titulo, String autor, int anioPublicacion, String urlLectura) {
        super(id, titulo, autor, anioPublicacion);
        this.urlLectura = urlLectura;
    }

    public CategoriaMaterial getCategoria() {
        return categoria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("[EBOOK] #%d %s (%d) - %s -> %s%n", id, titulo, anioPublicacion, autor, urlLectura);
    }

    @Override
    public String obtenerURLLectura() {
        return urlLectura;
    }

    @Override
    public String toString() {
        return "Ebook{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", urlLectura='" + urlLectura + '\'' +
                '}';
    }
}
