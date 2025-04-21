package Venta_de_tiquetes;

public abstract class Tiquete {

	

	private CategoriaExclusividad categoria; 
	
	public Tiquete(CategoriaExclusividad categoria) {
		this.categoria = categoria; 
		
	}

	public CategoriaExclusividad getCategoria() {
		return categoria;
	}

	public abstract boolean esValidoPara(String idAtraccion);
	public abstract void marcarUsado();
	public abstract boolean estaUsado();

	
	
	


}
