package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Repositorio genérico de materiales. El tipo T está acotado a {@link Material}
 * para garantizar que todas las operaciones trabajen con elementos compatibles.
 */
public class Biblioteca<T extends Material> {

    private final List<T> materiales = new ArrayList<>();

    /** Agrega un material tipado. */
    public void agregar(T t) {
        materiales.add(t);
    }

    /** Elimina por id. Retorna true si se eliminó. */
    public boolean eliminarPorId(int id) {
        return materiales.removeIf(m -> m.getId() == id);
    }

    /** Busca por id retornando Optional. Optional evita nulls accidentales. */
    public Optional<T> buscarPorId(int id) {
        return materiales.stream().filter(m -> m.getId() == id).findFirst();
    }

    /**
     * Búsqueda genérica por condición.
     * Usamos Predicate<? super T> para permitir supertipos de T (PECS: Producer Extends, Consumer Super).
     * Predicate<T> es una función T -> boolean; se puede combinar con and(), or() y negate().
     */
    public List<T> buscar(Predicate<? super T> criterio) {
        return materiales.stream().filter(criterio).toList();
    }

    /**
     * Ordenamiento genérico.
     * Comparator<? super T> permite comparadores definidos en supertipos.
     */
    public void ordenar(Comparator<? super T> comparador) {
        materiales.sort(comparador);
    }

    /**
     * Proyección genérica: transforma T -> R (por ejemplo a DTOs o Strings).
     * Function<? super T, ? extends R> sigue la regla PECS: consumimos T (por eso super) y producimos R (por eso extends).
     */
    public <R> List<R> map(Function<? super T, ? extends R> f) {
        return materiales.stream().map(f).collect(Collectors.toList());
    }

    /** Devuelve una copia inmodificable para lecturas seguras. */
    public List<T> verTodos() {
        return Collections.unmodifiableList(materiales);
    }

    public int size() {
        return materiales.size();
    }
}
