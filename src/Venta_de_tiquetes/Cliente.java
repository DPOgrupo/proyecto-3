package Venta_de_tiquetes;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

    private String login;
    private String nombre;
    private String contrasena;

    private int dinero;
    private int edad;
    private boolean restSalud;

    private List<TiqueteRegular> tiquetesRegulares;
    private List<TiqueteIndividual> tiquetesIndividuales;
    private List<TiqueteTemporada> tiquetesTemporada;
    private List<TiqueteFastPass> tiquetesFastPass;

    public Cliente() {
        this.tiquetesRegulares = new ArrayList<>();
        this.tiquetesIndividuales = new ArrayList<>();
        this.tiquetesTemporada = new ArrayList<>();
        this.tiquetesFastPass = new ArrayList<>();
    }

    public Cliente(String nombre, String login, String contrasena, int dinero, int edad) {
        this(nombre, login, contrasena, dinero, edad, false);
    }

    public Cliente(String nombre, String login, String contrasena, int dinero, int edad, boolean rest) {
        this.nombre = nombre;
        this.login = login;
        this.contrasena = contrasena;
        this.dinero = dinero;
        this.edad = edad;
        this.restSalud = rest;

        this.tiquetesRegulares = new ArrayList<>();
        this.tiquetesIndividuales = new ArrayList<>();
        this.tiquetesTemporada = new ArrayList<>();
        this.tiquetesFastPass = new ArrayList<>();
    }

    public void addTiquete(Tiquete t) {
        if (t instanceof TiqueteRegular r) {
            tiquetesRegulares.add(r);
        } else if (t instanceof TiqueteIndividual i) {
            tiquetesIndividuales.add(i);
        } else if (t instanceof TiqueteTemporada temp) {
            tiquetesTemporada.add(temp);
        } else if (t instanceof TiqueteFastPass f) {
            tiquetesFastPass.add(f);
        }
    }

    public List<Tiquete> getTiquetes() {
        List<Tiquete> todos = new ArrayList<>();
        todos.addAll(tiquetesRegulares);
        todos.addAll(tiquetesIndividuales);
        todos.addAll(tiquetesTemporada);
        todos.addAll(tiquetesFastPass);
        return todos;
    }


    public int getDinero() {
        return this.dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return this.nombre;
    }
	
	public String getContrasena() {
		return this.contrasena;
	}
	public boolean isRestSalud() {
		return this.restSalud;
	}



	public String getLogin() {
		return login;
	}



	public int getEdad() {
		return edad;
	}
	
}

