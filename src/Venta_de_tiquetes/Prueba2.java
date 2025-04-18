package Venta_de_tiquetes;

import java.time.LocalDate;

public class Prueba2 {

    public static void main(String[] args) {
        try {
            // Crear un cliente con suficiente dinero
            Cliente cliente1 = new Cliente("Santiago Rojas", "Yago", "Lucas1226", 1152500);
            Taquilla taquilla = new Taquilla();

            // Vender tiquete regular (empleado = false)
            taquilla.venderTiqueteRegular(cliente1, CategoriaExclusividad.FAMILIAR, false);

            // Vender tiquete individual
            taquilla.venderTiqueteIndividual(cliente1, "ATR123", false);

            // Vender tiquete de temporada (2 semanas)
            taquilla.venderTiqueteTemporada(cliente1, CategoriaExclusividad.ORO, UnidadTiempo.SEMANA, 2, false);

            // Vender tiquete fastpass (1 mes)
            taquilla.venderTiqueteFastPass(cliente1, UnidadTiempo.MES, 1, false);

            // Mostrar resultados
            System.out.println("\n--- RESUMEN CLIENTE ---");
            System.out.println("Nombre: " + cliente1.getNombre());
            System.out.println("Dinero restante: $" + cliente1.getDinero());
            System.out.println("Tiquetes comprados:");
            for (Tiquete t : cliente1.getTiquetes()) {
                System.out.println(" - " + t);
            }

        } catch (FondosInsuficientesException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
