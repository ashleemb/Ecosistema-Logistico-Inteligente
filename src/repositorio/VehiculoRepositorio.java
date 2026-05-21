package repositorio;

import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio encargado de la gestión y almacenamiento en memoria de los vehículos del sistema.
 * Proporciona operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre la colección de vehículos.
 *
 * @author Jimena Pintos
 * @author Ashlee Bogado
 */
public class VehiculoRepositorio {

    //Lista donde se guardan todos los vehículos que se registran.
    private ArrayList<Vehiculo> listaVehiculos;

    /**
     * Constructor por defecto de la clase VehiculoRepositorio.
     * Inicializa la lista interna de vehículos como un ArrayList vacío.
     */
    public VehiculoRepositorio() {
        this.listaVehiculos = new ArrayList<>();
    }

    /**
     * Almacena un nuevo vehículo en el repositorio.
     * * @param vehiculo El objeto Vehiculo que se desea registrar.
     */
    public void guardarVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }

    /**
     * Obtiene la lista completa de los vehículos registrados en el sistema.
     * * @return Una lista (List) que contiene todos los objetos Vehiculo almacenados.
     */
    public List<Vehiculo> obtenerVehiculos(){
        return listaVehiculos;
    }

    /**
     * Busca un vehículo en el repositorio a partir de su identificador único.
     * * @param id El identificador único del vehículo a buscar.
     * @return El objeto Vehiculo correspondiente al ID proporcionado, o null si no se encuentra.
     */
    public Vehiculo buscarPorID(String id){
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getId().equals(id)){
                return vehiculo;
            }
        }
        return null;
    }

    /**
     * Modifica los datos de un vehículo existente reemplazándolo por una nueva instancia.
     * * @param id El identificador único del vehículo que se desea modificar.
     * @param vehiculoModificado La nueva instancia de Vehiculo con los datos actualizados.
     * @return true si el vehículo fue encontrado y modificado con éxito; false en caso contrario.
     */
    public boolean modificarVehiculo(String id, Vehiculo vehiculoModificado){
        Vehiculo encontrado = buscarPorID(id);
        int indice = listaVehiculos.indexOf(encontrado);

        if(encontrado != null){
            listaVehiculos.set(indice, vehiculoModificado);
            return true;
        }
        return false;
    }

    /**
     * Elimina un vehículo del repositorio a partir de su identificador único.
     * * @param id El identificador único del vehículo que se desea eliminar.
     * @return true si el vehículo fue encontrado y eliminado con éxito; false en caso contrario.
     */
    public boolean eliminarVehiculo(String id){
        Vehiculo v = buscarPorID(id);

        if(v != null){
            listaVehiculos.remove(v);
            return true;
        }
        return false;
    }
}