package Venta_de_tiquetes;

import java.util.Scanner;

public class PlataformaDeVentaOnline {

	Cliente clienteActivo; 
	final Taquilla taquilla; 
	private final Scanner scanner = new Scanner(System.in);
	

	PlataformaDeVentaOnline(Taquilla taquilla, Cliente clienteA){
		this.taquilla = taquilla;
		this.clienteActivo = clienteA;
	}
	
	void setClienteActivo(Cliente cliente){
		this.clienteActivo = cliente; 
	}
	
	void showPlataformaDeVenta() {
		
		System.out.println("¡Bienvenido a la plataforma, " + clienteActivo.getNombre() + "!");
        boolean salir = false;

        while (!salir) {
            System.out.println("\\n¿Qué tipo de tiquete deseas comprar?");
            System.out.println("1. Tiquete Regular");
            System.out.println("2. Tiquete Individual");
            System.out.println("3. Tiquete de Temporada");
            System.out.println("4. Tiquete FastPass");
            System.out.println("5. Ver tiquetes adquiridos");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Selecciona la categoría (BASICO, FAMILIAR, ORO, DIAMANTE):");
                        CategoriaExclusividad cat = CategoriaExclusividad.valueOf(scanner.nextLine().toUpperCase());
                        taquilla.venderTiqueteRegular(clienteActivo, cat, false);
                        System.out.println("¡Tiquete regular adquirido!");
                    }
                    case 2 -> {
                        System.out.print("Ingresa el ID de la atracción: ");
                        String id = scanner.nextLine();
                        taquilla.venderTiqueteIndividual(clienteActivo, id, false);
                        System.out.println("¡Tiquete individual adquirido!");
                    }
                    case 3 -> {
                        System.out.println("Selecciona la categoría (BASICO, FAMILIAR, ORO, DIAMANTE):");
                        CategoriaExclusividad cat = CategoriaExclusividad.valueOf(scanner.nextLine().toUpperCase());
                        System.out.println("Selecciona la unidad de tiempo (DIA, SEMANA, MES, ESTACION, ANO):");
                        UnidadTiempo unidad = UnidadTiempo.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("¿Cuántas unidades?: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer
                        taquilla.venderTiqueteTemporada(clienteActivo, cat, unidad, cantidad, false);
                        System.out.println("¡Tiquete de temporada adquirido!");
                    }
                    case 4 -> {
                        System.out.println("Selecciona la unidad de tiempo (DIA, SEMANA, MES, ESTACION, ANO):");
                        UnidadTiempo unidad = UnidadTiempo.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("¿Cuántas unidades?: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer
                        taquilla.venderTiqueteFastPass(clienteActivo, unidad, cantidad, false);
                        System.out.println("¡Tiquete FastPass adquirido!");
                    }
                    case 5 -> {
                        System.out.println("\\nTiquetes adquiridos:");
                        for (Tiquete t : clienteActivo.getTiquetes()) {
                            System.out.println(" - " + t);
                        }
                    }
                    case 6 -> salir = true;
                    default -> System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Gracias por visitar la plataforma.");
		
	}
	
}
