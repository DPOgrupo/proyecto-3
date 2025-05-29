package Empleados;

import java.util.ArrayList;
import java.util.List;

public abstract class LugarDeServicio {
    
    protected boolean disponible;

    protected List<Cajero> cajerosAsociados;
    protected List<Cocinero> cocinerosAsociados;
    protected List<ServicioGeneral> serviciosAsociados;

    public LugarDeServicio() {
        cajerosAsociados = new ArrayList<>();
        cocinerosAsociados = new ArrayList<>();
        serviciosAsociados = new ArrayList<>();
        disponible = false;
    }

    public abstract void setDisponible();

    public void añadirCajero(Cajero cajero) {
        if (!cajerosAsociados.contains(cajero)) {
            cajerosAsociados.add(cajero);
        } else {
            System.out.println("El cajero ya está asociado.");
        }
        setDisponible();
    }

    public void quitarCajero(Cajero cajero) {
        if (cajerosAsociados.remove(cajero)) {
            setDisponible();
        } else {
            System.out.println("El cajero no está asociado.");
        }
    }

    public List<Cajero> getCajerosAsociados() {
        return cajerosAsociados;
    }

    public void añadirCocinero(Cocinero cocinero) {
        if (!cocinerosAsociados.contains(cocinero)) {
            cocinerosAsociados.add(cocinero);
        } else {
            System.out.println("El cocinero ya está asociado.");
        }
        setDisponible();
    }

    public void quitarCocinero(Cocinero cocinero) {
        if (cocinerosAsociados.remove(cocinero)) {
            setDisponible();
        } else {
            System.out.println("El cocinero no está asociado.");
        }
    }

    public List<Cocinero> getCocinerosAsociados() {
        return cocinerosAsociados;
    }

    public void añadirServicio(ServicioGeneral servicio) {
        if (!serviciosAsociados.contains(servicio)) {
            serviciosAsociados.add(servicio);
        } else {
            System.out.println("El empleado de servicio general ya está asociado.");
        }
        setDisponible();
    }

    public void quitarServicio(ServicioGeneral servicio) {
        if (serviciosAsociados.remove(servicio)) {
            setDisponible();
        } else {
            System.out.println("El empleado de servicio general no está asociado.");
        }
    }

    public List<ServicioGeneral> getServiciosAsociados() {
        return serviciosAsociados;
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    
}
