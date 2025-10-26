package biblioteca;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio que opera sobre materiales prestables.
 * El parámetro de tipo U usa un bound múltiple: extiende Material y además implementa Prestable,
 * demostrando cómo Java permite combinar herencia e interfaces en genéricos.
 */
public class ServicioPrestamos<U extends Material & Prestable> {

    private final Biblioteca<U> repo;

    public ServicioPrestamos(Biblioteca<U> repo) {
        this.repo = repo;
    }

    public void prestar(int idMaterial, LocalDate hasta) {
        U m = repo.buscarPorId(idMaterial).orElseThrow();
        m.prestar(hasta);
    }

    public void devolver(int idMaterial) {
        U m = repo.buscarPorId(idMaterial).orElseThrow();
        m.devolver();
    }

    public List<U> vencidos(LocalDate fecha) {
        return repo.buscar(m -> m.getEstado() == EstadoPrestamo.PRESTADO
                && m.getFechaVencimiento() != null
                && m.getFechaVencimiento().isBefore(fecha));
    }
}
