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


}
