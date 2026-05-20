package repositorio;

import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class VehiculoRepositorio {

    //Lista donde se guardan todos los vehículos que se registran.
    private ArrayList<Vehiculo> listaVehiculos;

    public VehiculoRepositorio() {
        this.listaVehiculos = new ArrayList<>();
    }

    public void guardarVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }

    public List<Vehiculo> obtenerVehiculos(){
        return listaVehiculos;
    }

    public Vehiculo buscarPorID(String id){
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getId().equals(id)){
                return vehiculo;
            }
        }
        return null;
    }

    public boolean modificarVehiculo(String id, Vehiculo vehiculoModificado){
        Vehiculo encontrado = buscarPorID(id);
        int indice = listaVehiculos.indexOf(encontrado);

        if(encontrado != null){
            listaVehiculos.set(indice, vehiculoModificado);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(String id){
        Vehiculo v = buscarPorID(id);

        if(v != null){
            listaVehiculos.remove(v);
            return true;
        }
        return false;
    }
}
