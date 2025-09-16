package biblioteca;

import java.util.ArrayList;
import java.util.List;
import static java.util.Comparator.*;


public class Biblioteca {
        private List<Material> materiales = new ArrayList<>();

        //BUSCA POR ID, devuelve null sino existe
    public Material buscarPorId(int id) {
        Material encontrado = null; // valor por defecto si no se encuentra

        for (Material m : materiales) {
            if (m.getId() == id) {
                encontrado = m; // guarda el encontrado pero no retorna todavía
                break;         // sale del bucle al encontrarlo
            }
        }

        return encontrado; // devuelve el resultado (null si no se halló)
    }


    //BUSCA POR TITULO, la primer coincidencia exacta, ignora mayusculas/ minusculas, devuelve null si no existe
    public Material buscarPorTitulo(String texto) {
        Material resultado = null; // valor por defecto si no encuentra nada

        for (Material m : materiales) {
            if (m.getTitulo().equalsIgnoreCase(texto)) {
                resultado = m; // guarda el material encontrado
                break;         // sale del bucle al hallarlo
            }
        }
        return resultado; // devuelve el hallado o null si no hubo coincidencia
    }

    //BUSCA POR TITULO, DEVOLVIENDO UNA LISTA DE COINCIDENCIAS CON TEXTO PASADO
    public List<Material> buscarPorTituloLista(String texto) {
        List<Material> encontrados = new ArrayList<>();

        for (Material m : materiales) {
            if (m.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                encontrados.add(m);
            }
        }
        return encontrados;
    }



    //--ABM -- //
    //ALTA

    public void alta(Material m) {
        if (m != null) materiales.add(m);
    }


    //BAJA

     //Metodo auxiliar para eliminar un material ya encontrado.
    public boolean eliminarMaterial(Material m) {
        boolean eliminado = false;
        if (m != null) {
            materiales.remove(m);
            eliminado = true;
        }
        return eliminado;
    }

     // Elimina un material dado por ID.
    public boolean bajaPorId(int id){
        return eliminarMaterial(buscarPorId(id));
    }

    // Elimina un material dado por título.
    public boolean bajaPorTitulo(String titulo){
        return eliminarMaterial(buscarPorTitulo(titulo));
    }


    //MODIFICACION

    public boolean modificarDatos (int id, String nuevoTitulo, String nuevoAutor, int nuevoAnio){
        boolean encontrado = false;
        Material m = buscarPorId(id);
        if (m != null  ){
            //logica
            m.setTitulo(nuevoTitulo.trim());
            m.setAutor(nuevoAutor.trim());
            m.setAnioPublicacion(nuevoAnio);
            encontrado = true;
        }

        return encontrado;
    }


    //LISTADOS
    //1) Listar todos sin ordenar
    public List<Material> listarTodos(){
        return new ArrayList<>(materiales);
    }

    // 2) Listar por TÍTULO (ignorando mayúsculas/minúsculas)
    public List<Material> listarPorTitulo() {
        List<Material> copia = new ArrayList<>(materiales);
        copia.sort(comparing(Material::getTitulo, String.CASE_INSENSITIVE_ORDER));
        return copia;
    }

    // 3) Listar por TÍTULO descendente (ignorando mayúsculas/minúsculas)
    public List<Material> listarPorTituloDesc() {
        List<Material> copia = new ArrayList<>(materiales);
        copia.sort(comparing(Material::getTitulo, String.CASE_INSENSITIVE_ORDER).reversed());
        return copia;
    }

    // 4) Listar por AUTOR ascendente
    public List<Material> listarPorAutorAsc() {
        List<Material> copia = new ArrayList<>(materiales);
        copia.sort(comparing(Material::getAutor, String.CASE_INSENSITIVE_ORDER));
        return copia;
    }

    // 5) Listar por AÑO ascendente
    public List<Material> listarPorAnioAsc() {
        List<Material> copia = new ArrayList<>(materiales);
        copia.sort(comparingInt(Material::getAnioPublicacion));
        return copia;
    }

    // 6) Listar Compuesto: por AUTOR y luego TÍTULO
    public List<Material> listarPorAutorLuegoTitulo() {
        List<Material> copia = new ArrayList<>(materiales);
        copia.sort(
                comparing(Material::getAutor, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Material::getTitulo, String.CASE_INSENSITIVE_ORDER)
        );
        return copia;
    }






    // === PRÉSTAMO / DEVOLUCIÓN ===
    public void prestar(int id) {
        Material m = buscarPorId(id);

        if (m != null && m.estaDisponible()) {
            m.prestar();
            System.out.println("Préstamo realizado");
        } else {
            System.out.println(" No disponible o no encontrado");
        }
    }

    public void devolver(int id) {
        Material m = buscarPorId(id);

        if (m != null && !m.estaDisponible()) {
            m.devolver();
            System.out.println("Devuelto correctamente");
        } else {
            System.out.println("No se pudo devolver (ya disponible o no existe)");
        }
    }

    // === FILTROS Y ESTADISTICAS DE CANTIDADES===

    //CANTIDAD DE MATERIALES
    public int cantidad() {
        return materiales.size();
    }

    //CANTIDAD DE PRESTADOS
    public int cantidadPrestados() {
        int contador = 0;
        for (Material m : materiales) {
            if (m.estaPrestado()) {
                contador++;
            }
        }
        return contador;
    }

    //CANTIDAD DE DISPONIBLES
    public int cantidadDisponibles(){
        int contador = 0;
        for (Material m : materiales){
            if(m.estaDisponible()){
                contador++;
            }
        }
        return contador;
    }

    //LISTAR  PRESTADOS
    public List<Material> listarPrestados() {
        List<Material> prestados = new ArrayList<>();
        for (Material m : materiales) {
            if (m.estaPrestado()) {
                prestados.add(m);
            }
        }
        return prestados;
    }

    //LISTAR AUTORES ORDEN ASCENDENTE CASE INSENSITIVE
    public List<String>listarAutores(){
        List<String> autores = new ArrayList<>();
        for (Material m: materiales){
            autores.add(m.getAutor());
        }
        autores.sort(String.CASE_INSENSITIVE_ORDER);
        return autores;
    }



    //LISTAR TITULOS ORDEN ASCENDENTE CASE INSENSITIVE
    public List<String>listarTitulos(){
        List <String> titulos = new ArrayList<>();
           for(Material m : materiales){
               titulos.add(m.getTitulo());
            }
           titulos.sort(String.CASE_INSENSITIVE_ORDER);
           return titulos;
    }


    //FILTROS POR CATEGORIAS
    public List<Material> listarPorCategoria(CategoriaMaterial tipo) {
        List<Material> listadoCategoria = new ArrayList<>();
        for (Material m : materiales) {
            if (m.getCategoria() == tipo) {
                listadoCategoria.add(m);
            }
        }
        return listadoCategoria;
    }



    //LISTAR TITULOS PERO SOLAMENTE DE REVISTAS, ASCENDENTE CASE INSENSITIVE
    public List<String>listarTitulosRevistas(){
        List <String> titulosRevistas = new ArrayList<>();
        for(Material m : materiales) {
            if (m.getCategoria() == CategoriaMaterial.REVISTA) {
                titulosRevistas.add(m.getTitulo());
            }
        }
        titulosRevistas.sort(String.CASE_INSENSITIVE_ORDER);
        return titulosRevistas;
    }





}
