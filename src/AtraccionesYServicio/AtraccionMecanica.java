package AtraccionesYServicio;

import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Tiquete;
public class AtraccionMecanica extends Atraccion {

	public AtraccionMecanica(String nombre, String temporada, String ubicacionFija, String nivelDeRiesgo,
			int cupoMaximo, int minEmpleadosEncargados, int nivelExclusividad) {
		super(nombre, temporada, ubicacionFija, nivelDeRiesgo, cupoMaximo, minEmpleadosEncargados, nivelExclusividad);
	}
	private int pesoMin;
	private int pesoMax; 
	private int alturaMin; 
	private int alturaMax;
	private String contraindicacciones;
	
	
	@Override
    public boolean cumpleRestricciones(Cliente cliente) {
        if (cliente.isRestSalud()) {
        	return false;
        }

        for (Tiquete tiquete : cliente.getTiquetes()) {
        	
            if (tiquete.esValidoPara(this.idAtraccion)) {
            	
                if (tiquete.getCategoria().ordinal() >= this.nivelExclusividad) {
                	
                    if (!tiquete.estaUsado()) {
                    	
                    	tiquete.marcarUsado();
                        return true;
                    }
                }
            }
        }

        return false;
	
	}
	
	
}
