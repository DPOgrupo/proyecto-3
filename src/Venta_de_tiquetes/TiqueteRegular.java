package Venta_de_tiquetes;

public class TiqueteRegular extends Tiquete {

	private boolean usado; 
	
	public TiqueteRegular(CategoriaExclusividad categoria) 
	{
		super(categoria);
		this.usado = false; 
	}
	
}

