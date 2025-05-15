package mains;

import Empleados.AdministradorEmpleados;
import Empleados.Cafeteria;
import Empleados.Cajero;
import Empleados.Cocinero;
import Empleados.Empleado;
import Empleados.LugarDeServicio;
import Empleados.ServicioGeneral;
import Empleados.Tienda;
import Empleados.Turno;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import AtraccionesYServicio.Atraccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsolaAdministrador {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            AdministradorEmpleados adminEmp = new AdministradorEmpleados("admin", "123");
            
            AdministradorAtraccionesYLugares adminAtr = new AdministradorAtraccionesYLugares();

            System.out.println("=== BIENVENIDO ADMINISTRADOR ===");
            System.out.print("Ingrese login: ");
            String login = reader.readLine();
            System.out.print("Ingrese contraseña: ");
            String clave = reader.readLine();
            
            if (!adminEmp.getLogin().equals(login) || !adminEmp.verificarContraseña(clave)) {
                System.out.println("Credenciales incorrectas o usuario no encontrado.");
                return;
            }

            int opcion = -1;
            while (opcion != 0) {
                System.out.println("\n--- MENÚ ADMINISTRADOR ---");
                System.out.println("1. Crear cajero");
                System.out.println("2. Crear cocinero");
                
                System.out.println("3. Crear cafeteria");
                System.out.println("4. Crear tienda");
                
                System.out.println("5. Crear servicio general");
                System.out.println("6. Crear atracción mecánica");
                System.out.println("7. Crear atracción cultural");
                
                System.out.println("8. Cambiar turno global");
                System.out.println("9. Añadir capacitacion");
                System.out.println("10. Añadir turno a empleado");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Login del cajero: ");
                        String login1 = reader.readLine();
                        System.out.print("Contraseña del cajero: ");
                        String contraseña = reader.readLine();
                        adminEmp.crearCajero(login1, contraseña);
                        System.out.println("Cajero creado.");
                    }
                    case 2 -> {
                        System.out.print("Login del cocinero: ");
                        String login1 = reader.readLine();
                        System.out.print("Contraseña del cocinero: ");
                        String contraseña = reader.readLine();
                        adminEmp.crearCocinero(login1, contraseña);
                        System.out.println("Cocinero creado.");
                    }
                    case 3 -> {
                        System.out.print("Login del servicio general: ");
                        String login1 = reader.readLine();
                        System.out.print("Contraseña del servicio general: ");
                        String contraseña = reader.readLine();
                        adminEmp.crearServicioGeneral(login1, contraseña);
                        System.out.println("Empleado de servicio general creado.");
                    }
                    
                    case 4 -> {
                        System.out.print("Ingrese la cantidad inicial de comidas para la cafetería: ");
                        int comidas = Integer.parseInt(reader.readLine());
                        adminAtr.crearCafeteria(comidas);
                        System.out.println("Cafetería creada con " + comidas + " comidas.");
                    }

                    case 5 -> {
                        System.out.print("Ingrese la cantidad inicial de juguetes para la tienda: ");
                        int juguetes = Integer.parseInt(reader.readLine());
                        adminAtr.crearTienda(juguetes);
                        System.out.println("Tienda creada con " + juguetes + " juguetes.");
                    }

                    
                    case 6 -> {
                        System.out.print("Nombre: ");
                        String nombre = reader.readLine();
                        System.out.print("Temporada: ");
                        String temporada = reader.readLine();
                        System.out.print("Ubicación: ");
                        String ubicacion = reader.readLine();
                        System.out.print("Nivel de riesgo (ALTO/MEDIO): ");
                        String riesgo = reader.readLine();
                        System.out.print("Cupo máximo: ");
                        int cupo = Integer.parseInt(reader.readLine());
                        System.out.print("Mínimo empleados: ");
                        int minEmp = Integer.parseInt(reader.readLine());
                        System.out.print("Nivel exclusividad (0-3): ");
                        int exclu = Integer.parseInt(reader.readLine());
                        adminAtr.crearAtraccionMecanica(nombre, temporada, ubicacion, riesgo, cupo, minEmp, exclu);
                        System.out.println("Atracción mecánica creada.");
                    }
                    case 7 -> {
                        System.out.print("Nombre: ");
                        String nombre = reader.readLine();
                        System.out.print("Temporada: ");
                        String temporada = reader.readLine();
                        System.out.print("Ubicación: ");
                        String ubicacion = reader.readLine();
                        System.out.print("Cupo máximo: ");
                        int cupo = Integer.parseInt(reader.readLine());
                        System.out.print("Mínimo empleados: ");
                        int minEmp = Integer.parseInt(reader.readLine());
                        System.out.print("Nivel exclusividad (0-3): ");
                        int exclu = Integer.parseInt(reader.readLine());
                        System.out.print("Edad mínima: ");
                        int edad = Integer.parseInt(reader.readLine());
                        System.out.print("Restricción climática: ");
                        String clima = reader.readLine();
                        System.out.print("Nivel de riesgo: ");
                        String riesgo = reader.readLine();
                        adminAtr.crearAtraccionCultural(nombre, temporada, ubicacion, clima, minEmp, exclu, edad, cupo, riesgo);
                        System.out.println("Atracción cultural creada.");
                    }
                    case 8 -> {
                        boolean turnoGlobalNocturno = adminEmp.isTurnoGlobalNocturno();
                        String tipoTurnoActual;
                        String tipoTurnoNuevo;

                        if (turnoGlobalNocturno) {
                            tipoTurnoActual = "Nocturno";
                            tipoTurnoNuevo = "Diurno";
                            
                        } else {
                            tipoTurnoActual = "Diurno";
                            tipoTurnoNuevo = "Nocturno";
                        }

                        System.out.println("El turno actual global es: " + tipoTurnoActual);
                        System.out.println("¿Desea cambiar todos los empleados al turno " + tipoTurnoNuevo + "? si/no: ");

                        String respuesta = reader.readLine();

                        if (respuesta.equals("si")) {
                        	
                            adminEmp.cambiarTurnoGlobal(!turnoGlobalNocturno);
                            System.out.println("Cambio de turno aplicado a: " + tipoTurnoNuevo);
                            
                        } else {
                            System.out.println("No se realizó ningún cambio.");
                        }
                    }
                    case 9 -> {
                        Empleado elegido = seleccionarEmpleado(adminEmp, reader);
                        if (elegido == null){
                        	System.out.println("Escoja una opcion valida");
                        	return;
                        	}

                        System.out.println("Capacitaciones disponibles:");
                        System.out.println("1. COCINA");
                        System.out.println("2. MANTENIMIENTO_MEDIO");
                        System.out.println("3. MANTENIMIENTO_ALTO");
                        System.out.println("Ingrese los números separados por coma (ej: 1,2,3): ");
                        
                        String[] opciones = reader.readLine().split(",");

                        for (String opcion1 : opciones) {
                            opcion1 = opcion1.trim();
                            
                            switch (opcion1) {
                                case "1" -> {
                                	adminEmp.añadirCapacitacion(elegido, "COCINA");
                                	System.out.println("Opción inválida: " + opcion1);
                                	}
                                case "2" -> {
                                	adminEmp.añadirCapacitacion(elegido, "MANTENIMIENTO_MEDIO");
                                	System.out.println("Opción inválida: " + opcion1);
                                	}
                                case "3" -> {
                                	adminEmp.añadirCapacitacion(elegido, "MANTENIMIENTO_ALTO");
                                	System.out.println("Opción inválida: " + opcion1);
                                	}
                            }
                        }
                        System.out.println("Capacitaciones añadidas.");
                    }
                    case 10 ->{
                    	
                    	Empleado elegido = seleccionarEmpleado(adminEmp, reader);
                        if (elegido == null) {
                        	System.out.println("Escoja una opcion valida");
                        	return;
                        	}

                        System.out.print("¿Turno nocturno o diurno? (n = nocturno, d = diurno): ");
                        String turnoInput = reader.readLine().trim().toLowerCase();
                        boolean turnoNocturno;

                        if (turnoInput.equals("n")) {
                            turnoNocturno = true;
                            
                        } else if (turnoInput.equals("d")) {
                            turnoNocturno = false;
                            
                        } else {
                            System.out.println("Entrada inválida. se asignó el turno diurno por defecto.");
                            turnoNocturno = false;
                        }

                        System.out.print("¿A qué tipo de lugar desea asignarlo? \n oprima 1 para Atracciónes y 2 = Lugar de Servicio): ");
                        int tipoLugar = Integer.parseInt(reader.readLine());

                        Turno turno;

                        if (tipoLugar == 1) {
                            Atraccion atraccion = seleccionarAtraccion(adminAtr, reader);
                            if (atraccion == null) {
                            	System.out.println("Escoja una opcion valida");
                            	return;
                            	}


                            turno = adminEmp.crearTurno(LocalDate.now(), turnoNocturno, atraccion);
                        } else if (tipoLugar == 2) {
                            LugarDeServicio lugar = seleccionarLugarDeServicio(adminAtr, reader);
                            if (lugar == null){
                            	System.out.println("Escoja una opcion valida");
                            	return;
                            	}

                            turno = adminEmp.crearTurno(LocalDate.now(), turnoNocturno, lugar);
                        } else {
                            System.out.println("Opción inválida.");
                            return;
                        }

                        adminEmp.cambiarTurno(elegido, turno);
                        System.out.println("Turno asignado correctamente.");
                    }


                }
            } 

            // TODO: guardar cambios en archivos automáticamente

        } catch (Exception e) {
            System.err.println("Error en la consola del administrador: " + e.getMessage());
        }
        
        
    }
    
    private static Empleado seleccionarEmpleado(AdministradorEmpleados adminEmp, BufferedReader reader) throws IOException {
        List<Empleado> todos = new ArrayList<>();
        int index = 0;

        for (Cajero cadaCajero : adminEmp.getCajeros()) {
            System.out.println(index + ". Cajero: " + cadaCajero.getLogin());
            todos.add(cadaCajero);
            index++;
        }

        for (Cocinero cadaCocinero : adminEmp.getCocineros()) {
            System.out.println(index + ". Cocinero: " + cadaCocinero.getLogin());
            todos.add(cadaCocinero);
            index++;
        }

        for (ServicioGeneral cadaServicio : adminEmp.getServicios()) {
            System.out.println(index + ". Servicio General: " + cadaServicio.getLogin());
            todos.add(cadaServicio);
            index++;
        }

        if (todos.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return null;
        }

        System.out.print("Ingrese el número del empleado: ");
        int seleccion = Integer.parseInt(reader.readLine());
        return todos.get(seleccion);
        
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
    
    public static LugarDeServicio seleccionarLugarDeServicio(AdministradorAtraccionesYLugares adminAtr, BufferedReader reader) throws IOException {
        List<LugarDeServicio> lugares = new ArrayList<>();
        int index = 0;

        System.out.println("Seleccione un lugar de servicio:");
        for (Tienda cadaTienda : adminAtr.getTiendas()) {
            System.out.println(index + ". Tienda con " + cadaTienda.getNumeroJuguetes() + " juguetes.");
            lugares.add(cadaTienda);
            index++;
        }
        for (Cafeteria cadaCafeteria : adminAtr.getCafeterias()) {
            System.out.println(index + ". Cafetería con " + cadaCafeteria.getNumeroComidas() + " comidas.");
            lugares.add(cadaCafeteria);
            index++;
        }

        if (lugares.isEmpty()) {
            System.out.println("No hay lugares de servicio registrados.");
            return null;
        }

        System.out.print("Ingrese el número del lugar: ");
        int seleccion = Integer.parseInt(reader.readLine());

        

        return lugares.get(seleccion);
    }


    


    
    
}
