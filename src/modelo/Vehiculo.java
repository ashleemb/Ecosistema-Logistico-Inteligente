package modelo;

/**
 * Clase abstracta que define la estructura base para cualquier vehículo del sistema.
 * Maneja la identificación automática de cada objeto mediante un contador estático.
 *
 * @author Jimena Pintos
 * @author Ashlee Bogado
 */
public abstract class Vehiculo {

    //Atributos privados.
    private String id;     // ID específico de la instancia
    private String tipo;    // Tipo de vehiculo
    private static int nextId = 1;    // Contador global de la clase

    /**
     * Constructor de la clase Vehiculo.
     * Se encarga de llamar al método que asigna el ID único al crear la instancia.
     */
    public Vehiculo(String tipo, String prefijo){
        this.tipo = tipo;
        setId(prefijo);
    }

    /**
     * Asigna el valor actual de nextId al vehículo y luego incrementa
     * el contador para la próxima instancia.
     */
    private void setId(String prefijo){
        this.id= prefijo + String.format("%03d", nextId);
        nextId++;
    }

    /**
     * @return El valor que tendrá el ID del próximo vehículo que se cree.
     */
    public static int getNextId(){
        return nextId;
    }

    /**
     * @return El identificador único del vehículo.
     */
    public String getId(){
        return id;
    }

    public String getTipo(){
        return tipo;
    }

    /**
     * Método abstracto que define cómo se mueve el vehículo.
     */
    public abstract void patronMovimiento();

}