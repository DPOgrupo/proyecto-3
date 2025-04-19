package Empleados;

public class Cocinero extends Cajero {

	private int productividad = 1;
	
	public Cocinero(String login, String contraseña, int dinero) {
        super(login, contraseña, dinero);
    }

    public void cocinar(Cafeteria cafeteria) {
        cafeteria.aumentarComidas(productividad);
    }


		
	
}
