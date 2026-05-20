package modelo;

/**
 * Clase que representa un Dron de Transporte.
 * Hereda de la clase Vehiculo para tener un ID,
 * e implementa IConectable porque al ser un dron necesita usar GPS.
 *
 * @author Jimena Pintos
 * @author Ashlee Bogado
 */
public class DronDeTransporte extends Vehiculo implements IConectable {

    /**
     * Constructor de la Clase DronTransporte.
     * Llama al constructor de la superclase para asegurarse
     * de que el dron reciba su ID correspondiente.
     */
    public DronDeTransporte(){
        super("Dron", "D-");
    }

    /**
     * Implementación del movimiento del dron.
     * Muestra el ID del vehículo y explica que despega.
     */
    @Override
    public void patronMovimiento() {
        System.out.println("Dron con ID: " + getId() + " ,despegando verticalmente en linea recta.");
    }

    /**
     * Implementación por la interfaz IConectable.
     * Simula la conexión del dron con los satélites para obtener coordenadas.
     */
    @Override
    public void sincronizarGPS(){
        System.out.println("Conectando Dron con ID: " + getId() + "  a la red satelital para actualización de coordenadas.");
    }
}