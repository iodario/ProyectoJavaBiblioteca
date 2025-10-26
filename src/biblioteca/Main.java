package biblioteca;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

/**
 * Punto de entrada que demuestra el uso de la biblioteca genérica.
 * Se documentan los ejemplos con comentarios pedagógicos sobre genéricos y funciones.
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("=== Demostración de biblioteca genérica ===");

        // Repositorios tipados: seguridad de tipos sin casts.
        Biblioteca<Libro> bibliotecaLibros = new Biblioteca<>();
        Biblioteca<Ebook> bibliotecaEbooks = new Biblioteca<>();

        cargarLibros(bibliotecaLibros);
        cargarEbooks(bibliotecaEbooks);

        // Uso de Predicate: función T -> boolean; se pueden encadenar con and(), or(), negate().
        Predicate<Libro> esReciente = libro -> libro.getAnioPublicacion() >= 2016;
        Predicate<Libro> deAutorFowler = libro -> libro.getAutor().equalsIgnoreCase("Martin Fowler");
        List<Libro> filtrados = bibliotecaLibros.buscar(esReciente.and(deAutorFowler));
        System.out.println("Libros recientes de Martin Fowler: " + filtrados);

        // Ordenamientos utilizando comparadores genéricos.
        bibliotecaLibros.ordenar(ComparadoresMaterial.porTituloAsc());
        System.out.println("Ordenados por título ascendente: " + bibliotecaLibros.verTodos());
        bibliotecaLibros.ordenar(ComparadoresMaterial.porAnioAsc());
        System.out.println("Ordenados por año ascendente: " + bibliotecaLibros.verTodos());

        // Map/Proyección: Function<? super T, ? extends R> permite transformar entidades en strings.
        List<String> titulos = bibliotecaLibros.map(Libro::getTitulo);
        System.out.println("Títulos de la biblioteca: " + titulos);

        // Servicios tipados con bounds múltiples.
        ServicioPrestamos<Libro> prestamoLibros = new ServicioPrestamos<>(bibliotecaLibros);
        prestamoLibros.prestar(101, LocalDate.now().plusDays(14));
        System.out.println("Libros vencidos mañana: " + prestamoLibros.vencidos(LocalDate.now().plusDays(1)));
        prestamoLibros.devolver(101);

        ServicioLectura<Ebook> lecturaEbooks = new ServicioLectura<>(bibliotecaEbooks);
        lecturaEbooks.urlDeLectura(201).ifPresent(url ->
                System.out.println("URL de lectura del ebook 201: " + url));

        // Mostrar detalles usando polimorfismo.
        bibliotecaLibros.verTodos().forEach(Material::mostrarDetalles);
        bibliotecaEbooks.verTodos().forEach(Material::mostrarDetalles);

        // Ejemplo de eliminación genérica.
        boolean eliminado = bibliotecaLibros.eliminarPorId(103);
        System.out.println("Libro 103 eliminado: " + eliminado);
    }

    private static void cargarLibros(Biblioteca<Libro> bibliotecaLibros) {
        bibliotecaLibros.agregar(new Libro(101, "Refactoring", "Martin Fowler", 2018, GeneroLibro.NOVELA));
        bibliotecaLibros.agregar(new Libro(102, "Clean Code", "Robert C. Martin", 2008, GeneroLibro.DRAMA));
        bibliotecaLibros.agregar(new Libro(103, "Domain-Driven Design", "Eric Evans", 2003, GeneroLibro.ROMANCE));
    }

    private static void cargarEbooks(Biblioteca<Ebook> bibliotecaEbooks) {
        bibliotecaEbooks.agregar(new Ebook(201, "Effective Java", "Joshua Bloch", 2018,
                "https://ejemplo.com/ebooks/effective-java"));
        bibliotecaEbooks.agregar(new Ebook(202, "Design Patterns", "GoF", 1994,
                "https://ejemplo.com/ebooks/design-patterns"));
    }
}
