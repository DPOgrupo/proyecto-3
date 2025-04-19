package AtraccionesYServicio;

public class Atraccion extends AtraccionOEspectaculo{
	
	private String ubicacionFija; 
	private int cupoMaximo; 
	private int minEmpleadosEncargados;
	private int nivelExclusividad; 
	private boolean danado; 

	
	
	
	

	public Atraccion() {
		
		this.disponible = false;
	}




	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}





}
