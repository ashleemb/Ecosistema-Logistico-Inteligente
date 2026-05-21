package controlador;

import modelo.IConectable;
import modelo.Vehiculo;
import repositorio.VehiculoRepositorio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador encargado de gestionar la lógica de negocio y las operaciones avanzadas
 * sobre la flota de vehículos, haciendo uso de Streams y Lambdas de Java.
 *
 * @author Jimena Pintos
 * @author Ashlee Bogado
 */
public class VehiculoControlador {

    private VehiculoRepositorio repo = new VehiculoRepositorio();

    /**
     * Constructor de la clase VehiculoControlador.
     * Asigna el repositorio que servirá como fuente de datos para el controlador.
     * * @param repo El repositorio de vehículos (VehiculoRepositorio) que se va a utilizar.
     */
    public VehiculoControlador(VehiculoRepositorio repo){
        this.repo = repo;
    }

    /**
     * Recorre toda la lista de vehículos y ejecuta el patrón de movimiento de cada uno.
     */
    public void monitorearFlota() {
        System.out.println("\n~~~~~MONITOREO DE FLOTA~~~~~");
        repo.obtenerVehiculos().forEach(vehiculo -> vehiculo.patronMovimiento());
    }

    /**
     * Filtra los vehículos de la flota que implementan la interfaz IConectable
     * y ejecuta el método de sincronización de GPS para cada uno de ellos.
     */
    public void filtrarVehiculosConectables(){
        System.out.println("\n~~~~~VEHICULOS CONECTABLES~~~~~");
        repo.obtenerVehiculos().stream().
                filter(vehiculo -> vehiculo instanceof IConectable).
                forEach(vehiculo -> ((IConectable)vehiculo).sincronizarGPS());
    }

    /**
     * Extrae los identificadores (IDs) de todos los vehículos de la flota,
     * los almacena en una lista y los muestra en la consola.
     */
    public void obtenerListaDeIDs(){
        System.out.println("\n~~~~~LISTA DE IDENTIFICADORES DE LA FLOTA~~~~~");
        List<String> listaIDs = repo.obtenerVehiculos().stream().
                map(vehiculo -> vehiculo.getId()).collect(Collectors.toList());

        listaIDs.forEach(id -> System.out.println(id));
    }

    /**
     * Contabiliza la cantidad total de vehículos registrados en la flota
     * e imprime el resultado en la consola.
     */
    public void contarVehiculos(){
        System.out.println("\n~~~~~RECUENTO DE VEHICULOS~~~~~");
        long totalVehiculos = repo.obtenerVehiculos().stream().count();
        System.out.println("Total de vehiculos registrados: " + totalVehiculos);
    }

    /**
     * Busca y muestra en consola todos los vehículos de la flota cuyo tipo
     * coincida (ignorando mayúsculas y minúsculas) con el tipo especificado.
     * * @param tipoBuscado El tipo de vehículo que se desea filtrar (ej. "Camion", "Dron").
     */
    public void buscarPorTipo(String tipoBuscado){
        System.out.println("\n~~~~~BÚSQUEDA DE VEHICULOS: " + tipoBuscado.toUpperCase() + " ~~~~~");
        repo.obtenerVehiculos().stream().
                filter(vehiculo -> vehiculo.getTipo().equalsIgnoreCase(tipoBuscado)).
                forEach(vehiculo -> System.out.
                        println("Tipo: " + vehiculo.getTipo() + " | ID: " + vehiculo.getId()));
    }

    /**
     * Ordena la flota de vehículos numéricamente según la parte numérica de su ID
     * (omitiendo el prefijo de texto) y muestra el resultado ordenado en consola.
     */
    public void ordenarPorID(){
        System.out.println("\n~~~~~FLOTA ORDENADA POR ID~~~~~");
        repo.obtenerVehiculos().stream().
                sorted(Comparator.comparing(vehiculo -> vehiculo.getId().
                        substring(2))).//Para que no interfiera el prefijo al ordenar.
                forEach(vehiculo -> System.out.println("ID: " + vehiculo.getId()
                + " | Tipo: [" + vehiculo.getTipo() + "]"));
    }

    /**
     * Ordena la flota de vehículos alfabéticamente (A-Z) según su tipo
     * y muestra el resultado ordenado en consola.
     */
    public void ordenarPorTipo(){
        System.out.println("\n~~~~~FLOTA ORDENADA POR TIPO (A-Z)~~~~~");
        repo.obtenerVehiculos().stream().
                sorted(Comparator.comparing(Vehiculo::getTipo)).
                forEach(vehiculo -> System.out.println("Tipo: [" + vehiculo.getTipo() + "]"
                        + " | ID: " + vehiculo.getId()));
    }
}