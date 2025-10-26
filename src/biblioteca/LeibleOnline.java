package biblioteca;

/**
 * Representa la capacidad de ofrecer lectura en línea.
 * Al parametrizar servicios con este contrato demostramos cómo combinar genéricos y capacidades.
 */
public interface LeibleOnline {
    /** Devuelve la URL desde la cual se puede leer el material digital. */
    String obtenerURLLectura();
}
