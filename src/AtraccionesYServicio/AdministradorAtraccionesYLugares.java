package AtraccionesYServicio;

import Empleados.*;
import Venta_de_tiquetes.Taquilla;
import AtraccionesYServicio.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorAtraccionesYLugares {

    private List<Tienda> tiendas;
    private List<Cafeteria> cafeterias;
    private List<AtraccionMecanica> mecanicas;
    private List<AtraccionCultural> culturales;
    private List<Espectaculo> espectaculos;
    private List<Taquilla> taquillas;

    public AdministradorAtraccionesYLugares() {
        tiendas = new ArrayList<>();
        cafeterias = new ArrayList<>();
        mecanicas = new ArrayList<>();
        culturales = new ArrayList<>();
        espectaculos = new ArrayList<>();
        taquillas = new ArrayList<>();
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
    
    public void crearTaquilla() {
    	
        Taquilla nueva = new Taquilla();
        taquillas.add(nueva);
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public List<Cafeteria> getCafeterias() {
        return cafeterias;
    }
    
    public List<AtraccionMecanica> getMecanicas() {
        return mecanicas;
    }

    public List<AtraccionCultural> getCulturales() {
        return culturales;
    }

    public List<Espectaculo> getEspectaculos() {
        return espectaculos;
    }    
    
    public List<Taquilla> getTaquillas() {
		return taquillas;
	}

	public void crearAtraccionMecanica(String nombre, String temporada, String ubicacionFija, String nivelDeRiesgo, int cupoMaximo, int minEmpleados, int nivelExclusividad) {


	AtraccionMecanica mecanica = new AtraccionMecanica(nombre, temporada, ubicacionFija, nivelDeRiesgo, cupoMaximo, minEmpleados, nivelExclusividad);
	mecanicas.add(mecanica);
	}
	
    public void crearAtraccionCultural(String nombre, String temporada, String ubicacionFija, String nivelDeRiesgo,int cupoMaximo, int minEmpleadosEncargados, int nivelExclusividad, int edadMinima, String restriccionClima) {
    
			
	AtraccionCultural cultural = new AtraccionCultural(
	nombre, ubicacionFija, temporada, cupoMaximo, minEmpleadosEncargados, nivelExclusividad, edadMinima, restriccionClima, nivelDeRiesgo);
	
	culturales.add(cultural);
	}


}