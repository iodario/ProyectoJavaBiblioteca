package biblioteca;

import java.util.Optional;

/**
 * Servicio orientado a materiales con lectura online.
 * El parámetro V combina Material y LeibleOnline para garantizar que exista URL de lectura.
 */
public class ServicioLectura<V extends Material & LeibleOnline> {

    private final Biblioteca<V> repo;

    public ServicioLectura(Biblioteca<V> repo) {
        this.repo = repo;
    }

    public Optional<String> urlDeLectura(int idMaterial) {
        return repo.buscarPorId(idMaterial).map(V::obtenerURLLectura);
    }
}
