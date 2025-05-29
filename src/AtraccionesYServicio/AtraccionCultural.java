package AtraccionesYServicio;

import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Tiquete;

public class AtraccionCultural extends Atraccion {

    private int edadMin; 
    private String restriccionClima;

    public AtraccionCultural(String nombre, String ubicacion, String temporada, int cupo, int minEmp, int exclusividad,
            int edadMin, String restriccionClima,String nivelDeRiesgo) {
	super(nombre, temporada, ubicacion, nivelDeRiesgo, cupo, minEmp, exclusividad);
	this.edadMin = edadMin;
	this.restriccionClima = restriccionClima;
	}
    
    

    	
    public AtraccionCultural() {
		super("", "", "", "", 0, 0, 0);
		
		this.edadMin = 0;
		this.restriccionClima = "";
		
	}




	@Override
    public boolean cumpleRestricciones(Cliente cliente) {
        if (cliente.getEdad() < edadMin) {
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



