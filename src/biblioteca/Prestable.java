package biblioteca;

import java.time.LocalDate;

/**
 * Define la capacidad de ser prestado con fechas y estados.
 * Este contrato permite parametrizar servicios usando bounds múltiples.
 */
public interface Prestable {
    /** Registra el préstamo del material hasta la fecha indicada. */
    void prestar(LocalDate hasta);

    /** Marca la devolución del material. */
    void devolver();

    /** Obtiene el estado de disponibilidad actual. */
    EstadoPrestamo getEstado();

    /** Obtiene la fecha de vencimiento del préstamo. */
    LocalDate getFechaVencimiento();
}
