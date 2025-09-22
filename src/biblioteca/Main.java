package biblioteca;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        System.out.println(" Creacion de objetos de prueba");
        System.out.println();

        //CREACION DE OBJETOS DE PRUEBA
        Libro a1= new Libro ( "El Hobbit", "Tolkien", 1995, GeneroLibro.DRAMA );
        Libro a2= new Libro ( "Harry Potter", "Rowling", 2002, GeneroLibro.NOVELA );

        Ebook b1 = new Ebook("Clean Code", "Martin", 2005);
        Ebook b2 = new Ebook("Clean Code2", "Martina", 2010);

        Revista c1 = new Revista ("Gente", "Editorial Atlantida", 2002);
        Revista c2 = new Revista ("Software news", "Editorial IA", 2025);

        //Imprimir, empleando los toString();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println();
        System.out.println(c1);
        System.out.println(c2);

        b1.leer();
        b2.leer();
        */

        //ABM GESTOR

        System.out.println("=============GESTOR DE BIBLIOTECA===================");

        Biblioteca abm = new Biblioteca();
        cargarDatos(abm);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;

            while (!salir) {
                mostrarMenu();
                System.out.print("Seleccione una opción: ");
                String entrada = scanner.nextLine();

                int opcion;
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida. Intente nuevamente.\n");
                    continue;
                }

                switch (opcion) {
                    case 1 -> listarMateriales("=== Todos ===", abm.listarTodos());
                    case 2 -> listarMateriales("=== Por título (ASC) ===", abm.listarPorTitulo());
                    case 3 -> listarMateriales("=== Por título (DESC) ===", abm.listarPorTituloDesc());
                    case 4 -> listarMateriales("=== Por autor (ASC) ===", abm.listarPorAutorAsc());
                    case 5 -> listarMateriales("=== Por año (ASC) ===", abm.listarPorAnioAsc());
                    case 6 -> listarMateriales("=== Por autor y luego título (ASC/ASC) ===", abm.listarPorAutorLuegoTitulo());
                    case 7 -> listarStrings("=== Autores disponibles ===", abm.listarAutores());
                    case 8 -> listarStrings("=== Títulos disponibles ===", abm.listarTitulos());
                    case 9 -> listarMateriales("=== Materiales prestados ===", abm.listarPrestados());
                    case 10 -> listarPorCategoria(scanner, abm);
                    case 11 -> listarStrings("=== Títulos de revistas ===", abm.listarTitulosRevistas());
                    case 0 -> {
                        salir = true;
                        System.out.println("¡Hasta luego!");
                    }
                    default -> System.out.println("Opción no reconocida. Intente nuevamente.\n");
                }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========== MENÚ ==========");
        System.out.println("1. Listar todos los materiales");
        System.out.println("2. Listar por título (ascendente)");
        System.out.println("3. Listar por título (descendente)");
        System.out.println("4. Listar por autor (ascendente)");
        System.out.println("5. Listar por año (ascendente)");
        System.out.println("6. Listar por autor y luego título");
        System.out.println("7. Listar autores");
        System.out.println("8. Listar títulos");
        System.out.println("9. Listar materiales prestados");
        System.out.println("10. Listar por categoría");
        System.out.println("11. Listar títulos de revistas");
        System.out.println("0. Salir");
    }

    private static void listarMateriales(String titulo, List<Material> materiales) {
        System.out.println();
        System.out.println(titulo);
        if (materiales.isEmpty()) {
            System.out.println("No hay elementos para mostrar.");
            return;
        }

        for (Material material : materiales) {
            System.out.println(material);
        }
    }

    private static void listarStrings(String titulo, List<String> valores) {
        System.out.println();
        System.out.println(titulo);
        if (valores.isEmpty()) {
            System.out.println("No hay elementos para mostrar.");
            return;
        }

        for (String valor : valores) {
            System.out.println(valor);
        }
    }

    private static void listarPorCategoria(Scanner scanner, Biblioteca abm) {
        System.out.println();
        System.out.println("Seleccione la categoría:");
        System.out.println("1. Libros");
        System.out.println("2. Revistas");
        System.out.println("3. Ebooks");
        System.out.print("Opción: ");

        String entrada = scanner.nextLine();
        int opcion;
        try {
            opcion = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida. Regresando al menú principal.\n");
            return;
        }

        CategoriaMaterial categoria = switch (opcion) {
            case 1 -> CategoriaMaterial.LIBRO;
            case 2 -> CategoriaMaterial.REVISTA;
            case 3 -> CategoriaMaterial.EBOOK;
            default -> null;
        };

        if (categoria == null) {
            System.out.println("Opción inválida. Regresando al menú principal.\n");
            return;
        }

        List<Material> materiales = abm.listarPorCategoria(categoria);
        materiales.sort(null);
        listarMateriales("=== Materiales por categoría: " + categoria + " ===", materiales);
    }

    private static void cargarDatos(Biblioteca abm) {
        // === LIBROS ===
        abm.alta(new Libro("Blancanieves y los 7 enanos","Disney",1990,GeneroLibro.TERROR));
        abm.alta(new Libro("Cenicienta","Disney",1980,GeneroLibro.ROMANCE));
        abm.alta(new Libro("Moby Dick","Herman Melville",1851,GeneroLibro.AVENTURA));
        abm.alta(new Libro("Don Quijote de la Mancha","Miguel de Cervantes",1605,GeneroLibro.NOVELA));
        abm.alta(new Libro("Crimen y Castigo","Fiódor Dostoyevski",1866,GeneroLibro.DRAMA));
        abm.alta(new Libro("Orgullo y Prejuicio","Jane Austen",1813,GeneroLibro.ROMANCE));
        abm.alta(new Libro("1984","George Orwell",1949,GeneroLibro.CIENCIA_FICCION));
        abm.alta(new Libro("La Odisea","Homero",-800,GeneroLibro.AVENTURA));
        abm.alta(new Libro("Cien Años de Soledad","Gabriel García Márquez",1967,GeneroLibro.NOVELA));
        abm.alta(new Libro("El Principito","Antoine de Saint-Exupéry",1943,GeneroLibro.FANTASIA));
        abm.alta(new Libro("Los Miserables","Victor Hugo",1862,GeneroLibro.DRAMA));
        abm.alta(new Libro("Fahrenheit 451","Ray Bradbury",1953,GeneroLibro.CIENCIA_FICCION));

        // === EBOOKS ===
        abm.alta(new Ebook("Aprendiendo Java","Dario",2025));
        abm.alta(new Ebook("Patrones de Diseño en Java","Gamma et al.",1994));
        abm.alta(new Ebook("Java Concurrency in Practice","Brian Goetz",2006));
        abm.alta(new Ebook("Head First Java","Kathy Sierra",2005));
        abm.alta(new Ebook("Effective Python","Brett Slatkin",2015));
        abm.alta(new Ebook("Python Crash Course","Eric Matthes",2016));
        abm.alta(new Ebook("Learning SQL","Alan Beaulieu",2009));
        abm.alta(new Ebook("The Pragmatic Programmer","Andrew Hunt",1999));
        abm.alta(new Ebook("Clean Architecture","Robert C. Martin",2017));
        abm.alta(new Ebook("Kotlin in Action","Dmitry Jemerov",2017));
        abm.alta(new Ebook("Design Patterns","Erich Gamma",1994));
        abm.alta(new Ebook("Refactoring","Martin Fowler",1999));

        // === REVISTAS ===
        abm.alta(new Revista("National Geographic","NG Publishing",2024));
        abm.alta(new Revista("IEEE Software","IEEE",2025));
        abm.alta(new Revista("Science","AAAS",2023));
        abm.alta(new Revista("Nature","Nature Publishing Group",2023));
        abm.alta(new Revista("Time","Time USA",2024));
        abm.alta(new Revista("Wired","Condé Nast",2024));
        abm.alta(new Revista("The Economist","The Economist Group",2024));
        abm.alta(new Revista("National Review","NR Publishing",2024));
        abm.alta(new Revista("Popular Science","Recurrent Ventures",2023));
        abm.alta(new Revista("PC World","Foundry",2024));
        abm.alta(new Revista("Software Development Times","D2 Emerge",2025));
        abm.alta(new Revista("Astronomy","Kalmbach Media",2025));
    }
}
