package Venta_de_tiquetes;

import java.util.Scanner;

public class PlataformaDeVentaOnline {

    private Cliente clienteActivo;
    private Taquilla taquilla = new Taquilla();
    private final Scanner scanner = new Scanner(System.in);

    public PlataformaDeVentaOnline(Taquilla taquilla, Cliente cliente) {
    	this.clienteActivo = cliente;
    	this.taquilla = taquilla;
    	
    }

    public void setClienteActivo(Cliente cliente) {
        this.clienteActivo = cliente;
    }

    public void showPlataformaDeVenta() {
        System.out.println("¡Bienvenido a la plataforma, " + clienteActivo.getNombre() + "!");
        
        boolean salir = false;

        while (!salir) {
            System.out.println("\n¿Qué tipo de tiquete deseas comprar?");
            System.out.println("1. Tiquete Regular");
            System.out.println("2. Tiquete Individual");
            System.out.println("3. Tiquete de Temporada");
            System.out.println("4. Tiquete FastPass");
            System.out.println("5. Ver tiquetes adquiridos");
            System.out.println("6. Salir");

            int opcion = leerEntero("Selecciona una opción: ");

            try {
                switch (opcion) {
                    case 1 -> {
                        CategoriaExclusividad cat = seleccionarCategoria();
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
                        CategoriaExclusividad cat = seleccionarCategoria();
                        UnidadTiempo unidad = seleccionarUnidadTiempo();
                        int cantidad = leerEntero("¿Cuántas unidades de tiempo?: ");
                        taquilla.venderTiqueteTemporada(clienteActivo, cat, unidad, cantidad, false);
                        System.out.println("¡Tiquete de temporada adquirido!");
                    }
                    case 4 -> {
                        UnidadTiempo unidad = seleccionarUnidadTiempo();
                        int cantidad = leerEntero("¿Cuántas unidades?: ");
                        taquilla.venderTiqueteFastPass(clienteActivo, unidad, cantidad, false);
                        System.out.println("¡Tiquete FastPass adquirido!");
                    }
                    case 5 -> {
                        System.out.println("\nTiquetes adquiridos:");
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

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine(); 
                return valor;
            } else {
                System.out.println("Por favor ingresa un número válido.");
                scanner.nextLine(); 
            }
        }
    }

    public CategoriaExclusividad seleccionarCategoria() {
        System.out.println("Selecciona la categoría:");
        System.out.println("1. BASICO");
        System.out.println("2. FAMILIAR");
        System.out.println("3. ORO");
        System.out.println("4. DIAMANTE");

        int opcion = leerEntero("Opción: ");
        return switch (opcion) {
            case 1 -> CategoriaExclusividad.BASICO;
            case 2 -> CategoriaExclusividad.FAMILIAR;
            case 3 -> CategoriaExclusividad.ORO;
            case 4 -> CategoriaExclusividad.DIAMANTE;
            default -> {
                System.out.println("Opción inválida. Se usará BASICO por defecto.");
                yield CategoriaExclusividad.BASICO;
            }
        };
    }

    public UnidadTiempo seleccionarUnidadTiempo() {
        System.out.println("Selecciona la unidad de tiempo:");
        System.out.println("1. DIA");
        System.out.println("2. SEMANA");
        System.out.println("3. MES");
        System.out.println("4. ESTACION");
        System.out.println("5. ANO");

        int opcion = leerEntero("Opción: ");
        return switch (opcion) {
            case 1 -> UnidadTiempo.DIA;
            case 2 -> UnidadTiempo.SEMANA;
            case 3 -> UnidadTiempo.MES;
            case 4 -> UnidadTiempo.ESTACION;
            case 5 -> UnidadTiempo.ANO;
            default -> {
                System.out.println("Opción inválida. Se usará DIA por defecto.");
                yield UnidadTiempo.DIA;
            }
        };
    }
}

