package Empleados;

public class Cocinero extends Cajero {

	private int productividad = 1;
	
	public Cocinero(int ID,String login, String contraseña, int dinero) {
	    super( ID,login, contraseña, dinero);
	    this.añadirCapacitacion("COCINA");
	}
    // Constructor vacío requerido por Gson
    public Cocinero() {
        super(0, "", "", 0);
    }

    public void cocinar(Cafeteria cafeteria) {
        cafeteria.aumentarComidas(productividad);
    }


		
	
}
