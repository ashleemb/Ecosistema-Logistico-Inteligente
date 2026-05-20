package modelo;

/**
 * Clase que representa un Camión Autónomo.
 * Hereda de la clase Vehiculo y define su propia forma de desplazarse
 * de manera independiente.
 *
 * @author Jimena Pintos
 * @author Ashlee Bogado
 */
public class CamionAutonomo extends Vehiculo{

    /**
     * Constructor de la Clase CamionAutonomo.
     * Llama al constructor de la superclase para asegurarse
     * de que el camión reciba su ID correspondiente.
     */
    public CamionAutonomo() {
        super("Camion", "C-");
    }

    /**
     * Implementación del patrón de movimiento específico para el camión.
     * Indica que el camión está circulando y utilizando su GPS.
     */
    @Override
    public void patronMovimiento() {
        System.out.println("Camion con ID: " + getId()
                + " ,circulando por ruta con sincronizacion de su GPS interno.");
    }
}