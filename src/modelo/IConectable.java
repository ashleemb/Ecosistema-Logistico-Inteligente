package modelo;

/**
 * Interfaz que define las capacidades de conectividad para los vehículos.
 *
 * @author Jimena Pintos
 * @author Ashlee Bogado
 */
public interface IConectable {

    /**
     * Establece la conexión con el satélite para actualizar la posición
     * y sincronizar los datos de navegación del vehículo.
     */
    void sincronizarGPS();
}