package Empleados;

public class Cajero extends Empleado {
	
	
    public Cajero(int ID,String login, String contraseña, int dinero) {
        super(ID,login, contraseña, dinero);
    }


	@Override
    public void cobrar(int precio, int cantidad, Cliente cliente) {
		
        int total = precio * cantidad;
        
        int dineroCliente = cliente.getDinero();

        if (dineroCliente >= total) {
        	
            cliente.quitarDinero(total);
            
            this.dinero += total;
            
            System.out.println("Compra realizada. Total: $" + total);
            
        } 
        else {
        	
            System.out.println("El cliente no tiene suficiente dinero. Tiene: $" + dineroCliente);
            
        }
    }


}
