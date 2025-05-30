package ventaDeTiquetes;

import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Taquilla;

public class TestSimple {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan", "juan123", "123", 9990000, 25, false);
        AdministradorAtraccionesYLugares admin = new AdministradorAtraccionesYLugares();
        admin.crearTaquilla();
        Taquilla taquilla = admin.getTaquillas().get(0);

        new VentanaVentaTiquetes(cliente, taquilla, admin);
    }
}
