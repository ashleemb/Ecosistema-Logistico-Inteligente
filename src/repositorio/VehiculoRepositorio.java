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

}
