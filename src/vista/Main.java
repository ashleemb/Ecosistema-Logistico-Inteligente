package vista;


import controlador.VehiculoControlador;
import modelo.CamionAutonomo;
import modelo.DronDeTransporte;
import repositorio.VehiculoRepositorio;

public class Main {
    public static void main(String[] args){
        //Instanciamos el repositorio.
        VehiculoRepositorio repoMain = new VehiculoRepositorio();

        //Creamos vehiculos de pruebas.
        CamionAutonomo camion1 = new CamionAutonomo();
        DronDeTransporte dron1 = new DronDeTransporte();
        DronDeTransporte dron2 = new DronDeTransporte();
        CamionAutonomo camion2 = new CamionAutonomo();
        CamionAutonomo camion3 = new CamionAutonomo();

        //Guardamos los vehiculos en el repositorio.
        repoMain.guardarVehiculo(camion1);
        repoMain.guardarVehiculo(dron1);
        repoMain.guardarVehiculo(dron2);
        repoMain.guardarVehiculo(camion2);
        repoMain.guardarVehiculo(camion3);

        //Instanciamos el controlador con repositorio.
        VehiculoControlador controlador = new VehiculoControlador(repoMain);

        //Llamamos a los metodos.
        System.out.println("Iniciando pruebas...");

        controlador.monitorearFlota();
        controlador.filtrarVehiculosConectables();
        controlador.contarVehiculos();
        controlador.obtenerListaDeIDs();

        controlador.ordenarPorID();
        controlador.ordenarPorTipo();
        controlador.buscarPorTipo("Camion");
    }
}
