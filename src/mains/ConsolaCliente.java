package mains;

import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsolaCliente {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AdministradorTiquetes adminTiquetes = new AdministradorTiquetes();
        AdministradorAtraccionesYLugares adminAtr = new AdministradorAtraccionesYLugares();
        adminAtr.crearTaquilla();
        Cliente cliente = null;

        try {
            System.out.println("=== BIENVENIDO CLIENTE ===");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(reader.readLine());

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = reader.readLine();
                System.out.print("Login: ");
                String login = reader.readLine();
                System.out.print("Contraseña: ");
                String pass = reader.readLine();
                System.out.print("Dinero disponible: ");
                int dinero = Integer.parseInt(reader.readLine());
                System.out.print("Edad: ");
                int edad = Integer.parseInt(reader.readLine());
                System.out.print("¿Tiene restricción de salud? (true/false): ");
                boolean rest = Boolean.parseBoolean(reader.readLine());

                cliente = new Cliente(nombre, login, pass, dinero, edad, rest);
                adminTiquetes.registrarCliente(cliente);
                System.out.println("¡Registro exitoso!");
            } else if (opcion == 2) {
                System.out.print("Login: ");
                String login = reader.readLine();
                System.out.print("Contraseña: ");
                String pass = reader.readLine();
                for (Cliente c : adminTiquetes.getClientesRegistrados()) {
                    if (c.getLogin().equals(login) && c.getContrasena().equals(pass)) {
                        cliente = c;
                        break;
                    }
                }
                if (cliente == null) {
                    System.out.println("Credenciales incorrectas.");
                    return;
                }
                System.out.println("¡Bienvenido de nuevo, " + cliente.getNombre() + "!");
            }

            while (true) {
                System.out.println("\n--- MENÚ CLIENTE ---");
                System.out.println("1. Comprar tiquete");
                System.out.println("2. Usar tiquete en atracción");
                System.out.println("3. Comprar en la tienda");
                System.out.println("4. Comprar en la cafetería");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                int opcion1 = Integer.parseInt(reader.readLine());

                switch (opcion1) {
	                case 1 -> {
	                    if (adminAtr.getTaquillas().isEmpty()) {
	                        System.out.println("No hay taquillas disponibles.");
	                    }
	
	                    Taquilla taquilla = adminAtr.getTaquillas().get(0);
	                    PlataformaDeVentaOnline plataforma = new PlataformaDeVentaOnline(taquilla, cliente);
	                    plataforma.showPlataformaDeVenta(); 
	                }


                    case 2 -> {
                        Atraccion atraccion = seleccionarAtraccion(adminAtr, reader);
                        if (atraccion != null && atraccion.cumpleRestricciones(cliente)) {
                            atraccion.añadirCliente(cliente);
                            System.out.println("¡Te montaste en " + atraccion.getIdAtraccion() + "!");
                        } else {
                            System.out.println("No puedes ingresar a esta atracción.");
                        }
                    }

                    case 3 -> {

                    	Tienda tienda = seleccionarTienda(adminAtr, reader);
                        if (tienda == null) {
                        	System.out.println("Escoja una opcion valida");
                        	break;}

                        System.out.print("¿Cuántos juguetes desea comprar?: ");
                        int cantidad = Integer.parseInt(reader.readLine());

                        tienda.venderTiquetes(cantidad, cliente);
                    }
                    case 4 -> {
                        
                    	Cafeteria cafeteria = seleccionarCafeteria(adminAtr, reader);
                        if (cafeteria == null) {
                        	System.out.println("Escoja una opcion valida");
                        	break;}

                        System.out.print("¿Cuántos almuerzos desea comprar?: ");
                        int cantidad = Integer.parseInt(reader.readLine());

                        cafeteria.venderAlmuerzos(cantidad, cliente);
                    }

                    case 0 -> {
                        System.out.println("Gracias por su visita.");
                        return;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }

    public static Atraccion seleccionarAtraccion(AdministradorAtraccionesYLugares adminAtr, BufferedReader reader) throws IOException {
        List<Atraccion> atracciones = new ArrayList<>();
        int index = 0;

        System.out.println("Seleccione una atracción:");
        for (Atraccion cadaAtraccion : adminAtr.getMecanicas()) {
            System.out.println(index + ". Mecánica: " + cadaAtraccion.getIdAtraccion());
            atracciones.add(cadaAtraccion);
            index++;
        }
        for (Atraccion cadaCultural : adminAtr.getCulturales()) {
            System.out.println(index + ". Cultural: " + cadaCultural.getIdAtraccion());
            atracciones.add(cadaCultural);
            index++;
        }

        if (atracciones.isEmpty()) {
            System.out.println("No hay atracciones registradas.");
            return null;
        }

        System.out.print("Ingrese el número de la atracción: ");
        int seleccion = Integer.parseInt(reader.readLine());
        return atracciones.get(seleccion);
    }

    public static Cafeteria seleccionarCafeteria(AdministradorAtraccionesYLugares adminAtr, BufferedReader reader) throws IOException {
        List<Cafeteria> cafeterias = adminAtr.getCafeterias();
        if (cafeterias.isEmpty()) {
            System.out.println("No hay cafeterías registradas.");
            return null;
        }

        System.out.println("Seleccione una cafetería:");
        for (int i = 0; i < cafeterias.size(); i++) {
            System.out.println(i + ". Cafetería con " + cafeterias.get(i).getNumeroComidas() + " comidas.");
        }

        System.out.print("Ingrese el número de la cafetería: ");
        int seleccion = Integer.parseInt(reader.readLine());
        return cafeterias.get(seleccion);
    }

    public static Tienda seleccionarTienda(AdministradorAtraccionesYLugares adminAtr, BufferedReader reader) throws IOException {
        List<Tienda> tiendas = adminAtr.getTiendas();
        
        if (tiendas.isEmpty()) {
            System.out.println("No hay tiendas registradas.");
            return null;
        }

        System.out.println("Seleccione una tienda:");
        for (int i = 0; i < tiendas.size(); i++) {
            System.out.println(i + ". Tienda con " + tiendas.get(i).getNumeroJuguetes() + " juguetes.");
        }

        System.out.print("Ingrese el número de la tienda: ");
        int seleccion = Integer.parseInt(reader.readLine());

        return tiendas.get(seleccion);
    }
}
