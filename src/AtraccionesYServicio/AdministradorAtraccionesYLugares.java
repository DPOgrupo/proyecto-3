package AtraccionesYServicio;

import Empleados.*;
import AtraccionesYServicio.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorAtraccionesYLugares {

    private List<Tienda> tiendas;
    private List<Cafeteria> cafeterias;

    public AdministradorAtraccionesYLugares() {
        tiendas = new ArrayList<>();
        cafeterias = new ArrayList<>();
    }

    public void crearTienda(int numJuguetes) {
        Tienda nueva = new Tienda();
        nueva.setNumeroJuguetes(numJuguetes);
        tiendas.add(nueva);
    }

    public void añadirJuguetes(Tienda tienda, int cantidad) {
    	tienda.aumentarJuguetes(cantidad);
    }

    public void crearCafeteria(int numComidas) {
        Cafeteria nueva = new Cafeteria();
        nueva.setNumeroComidas(numComidas);
        cafeterias.add(nueva);
    }

    public void añadirComidas(Cafeteria cafeteria, int cantidad) {
    	cafeteria.aumentarComidas(cantidad);
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public List<Cafeteria> getCafeterias() {
        return cafeterias;
    }
}
