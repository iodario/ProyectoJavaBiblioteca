package biblioteca;

import java.util.Comparator;

/**
 * Comparadores reutilizables para ordenar materiales.
 * Usamos Comparator<? super Material> para permitir comparadores declarados en supertipos
 * y demostrar la regla PECS (Producer Extends, Consumer Super).
 */
public final class ComparadoresMaterial {
    private ComparadoresMaterial() {
    }

    /**
     * Comparator que ordena por título ascendente ignorando mayúsculas.
     */
    public static Comparator<Material> porTituloAsc() {
        return Comparator.comparing(Material::getTitulo, String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Comparator que ordena por año de publicación ascendente.
     */
    public static Comparator<Material> porAnioAsc() {
        return Comparator.comparingInt(Material::getAnioPublicacion);
    }
}
