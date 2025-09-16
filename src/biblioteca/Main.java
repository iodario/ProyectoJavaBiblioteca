package biblioteca;

import java.util.List;

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

        //Alta de Materiales
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




        //LISTAR TODOS===============
        System.out.println("=== Todos ===");
        for (Material m : abm.listarTodos()) {
            System.out.println(m);
        }

        System.out.println();

        //LISTADOS ORDENADOS====================
        System.out.println("\n=== Por título (ASC) ===");
        for (Material m : abm.listarPorTitulo()) {
            System.out.println(m);
        }


        System.out.println("\n=== Por título (DESC) ===");
        for (Material m : abm.listarPorTituloDesc()) {
            System.out.println(m);
        }

        System.out.println("\n=== Por autor (ASC) ===");
        for (Material m : abm.listarPorAutorAsc()) {
            System.out.println(m);
        }

        System.out.println("\n=== Por año (ASC) ===");
        for (Material m : abm.listarPorAnioAsc()) {
            System.out.println(m);
        }

        System.out.println("\n=== Por autor y luego título (ASC/ASC) ===");
        for (Material m : abm.listarPorAutorLuegoTitulo()) {
            System.out.println(m);
        }


        //FILTROS
        System.out.println("================================");
        System.out.println("listado de autores");
        for (String m : abm.listarAutores()) {
            System.out.println(m);
        }

        System.out.println("================================");
        System.out.println("listado de titulos");
        for (String m : abm.listarTitulos()){
            System.out.println(m);
        }

        System.out.println("================================");
        System.out.println("listado de prestados");
        for (Material m : abm.listarPrestados()){
            System.out.println(m);
        }




        System.out.println("================================");
        System.out.println("listado por CATEGORIA");
        System.out.println("LISTADO DE LIBROS");

        List<Material> libros = abm.listarPorCategoria(CategoriaMaterial.LIBRO);
        libros.sort(null); // usa el compareTo() natural (por título)

        for (Material m : libros) {
            System.out.println(m);
        }


        System.out.println("LISTADO DE REVISTAS");
        for (Material m : abm.listarPorCategoria(CategoriaMaterial.REVISTA)){
            System.out.println(m);
        }
        System.out.println("LISTADO DE EBOOKS");
        for (Material m : abm.listarPorCategoria(CategoriaMaterial.EBOOK)){
            System.out.println(m);
        }

        System.out.println("================================");
        System.out.println("Listado de titulos de solo revistas");
        for (String m : abm.listarTitulosRevistas()){
            System.out.println(m);
        }


    }
}
