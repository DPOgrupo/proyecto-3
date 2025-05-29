package AtraccionesYServicio;

import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Tiquete;
public class AtraccionMecanica extends Atraccion {

	public AtraccionMecanica(String nombre, String temporada, String ubicacionFija, String nivelDeRiesgo,
			int cupoMaximo, int minEmpleadosEncargados, int nivelExclusividad) {
		super(nombre, temporada, ubicacionFija, nivelDeRiesgo, cupoMaximo, minEmpleadosEncargados, nivelExclusividad);
	}
	
	
	
	
	
	public AtraccionMecanica() {
		super("", "", "", "", 0, 0, 0);
		this.pesoMin = 0;
		this.pesoMax = 0;
		this.alturaMin = 0;
		this.alturaMax = 0;
		this.contraindicacciones = "";
	}





	private int pesoMin;
	private int pesoMax; 
	private int alturaMin; 
	private int alturaMax;
	private String contraindicacciones;
	
	
	@Override
	public boolean cumpleRestricciones(Cliente cliente) {
	    if (cliente.isRestSalud()) {
	        System.out.println("No puedes ingresar a la atracción por restricciones de salud.");
	        return false;
	    }

	    for (Tiquete tiquete : cliente.getTiquetes()) {
	    	System.out.println("Analizando Tiquete");
	        if (tiquete.esValidoPara(this.idAtraccion)) {
	            if (tiquete.getCategoria().ordinal() >= this.nivelExclusividad) {
	                if (!tiquete.estaUsado()) {
	                    tiquete.marcarUsado();
	                    return true;
	                } else {
	                    System.out.println("El tiquete válido ya fue usado.");
	                }
	            } else {
	                System.out.println("El tiquete no cumple con el nivel de exclusividad requerido.");
	            }
	        } else {
	            System.out.println("El tiquete no es válido para esta atracción.");
	        }
	    }

	    System.out.println("No se encontró un tiquete válido para ingresar a la atracción.");
	    return false;
	}

	
	
}
