
package Venta_de_tiquetes;

public class Prueba3 {

    public static void main(String[] args) {
        // Crear cliente y taquilla 
        Cliente cliente = new Cliente("Santiago Rojas", "Yago", "Lucas1226", 300000, 18);
        Taquilla taquilla = new Taquilla();

        // Crear plataforma
        PlataformaDeVentaOnline plataforma = new PlataformaDeVentaOnline(taquilla, cliente);

        // Iniciar interacción
        plataforma.showPlataformaDeVenta();
    }
}
