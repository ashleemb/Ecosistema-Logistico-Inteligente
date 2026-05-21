package controlador;

import modelo.IConectable;
import modelo.Vehiculo;
import repositorio.VehiculoRepositorio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehiculoControlador {

    private VehiculoRepositorio repo = new VehiculoRepositorio();

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

    public void filtrarVehiculosConectables(){
        System.out.println("\n~~~~~VEHICULOS CONECTABLES~~~~~");
        repo.obtenerVehiculos().stream().
                filter(vehiculo -> vehiculo instanceof IConectable).
                forEach(vehiculo -> ((IConectable)vehiculo).sincronizarGPS());
    }

    public void obtenerListaDeIDs(){
        System.out.println("\n~~~~~LISTA DE IDENTIFICADORES DE LA FLOTA~~~~~");
        List<String> listaIDs = repo.obtenerVehiculos().stream().
                map(vehiculo -> vehiculo.getId()).collect(Collectors.toList());

        listaIDs.forEach(id -> System.out.println(id));
    }

    public void contarVehiculos(){
        System.out.println("\n~~~~~RECUENTO DE VEHICULOS~~~~~");
        long totalVehiculos = repo.obtenerVehiculos().stream().count();
        System.out.println("Total de vehiculos registrados: " + totalVehiculos);
    }

    public void buscarPorTipo(String tipoBuscado){
        System.out.println("\n~~~~~BÚSQUEDA DE VEHICULOS: " + tipoBuscado.toUpperCase() + " ~~~~~");
        repo.obtenerVehiculos().stream().
                filter(vehiculo -> vehiculo.getTipo().equalsIgnoreCase(tipoBuscado)).
                forEach(vehiculo -> System.out.
                        println("Tipo: " + vehiculo.getTipo() + " | ID: " + vehiculo.getId()));
    }

    public void ordenarPorID(){
        System.out.println("\n~~~~~FLOTA ORDENADA POR ID~~~~~");
        repo.obtenerVehiculos().stream().
                sorted(Comparator.comparing(vehiculo -> vehiculo.getId().
                        substring(2))).//Para que no interfiera el prefijo al ordenar.
                forEach(vehiculo -> System.out.println("ID: " + vehiculo.getId()
                + " | Tipo: [" + vehiculo.getTipo() + "]"));
    }

    public void ordenarPorTipo(){
        System.out.println("\n~~~~~FLOTA ORDENADA POR TIPO (A-Z)~~~~~");
        repo.obtenerVehiculos().stream().
                sorted(Comparator.comparing(Vehiculo::getTipo)).
                forEach(vehiculo -> System.out.println("Tipo: [" + vehiculo.getTipo() + "]"
                        + " | ID: " + vehiculo.getId()));
    }
}
