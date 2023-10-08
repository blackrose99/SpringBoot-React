package com.proyectomomgo1.app.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

	@Document(collection = "clubes")
	public class Clubes {
	
	    @Id
	    private String id;
	
	    @NotEmpty
	    private String nombre;
	
	    @DocumentReference
	    private List<Jugadores> jugadores;
	
	    @DocumentReference
	    private List<Asociaciones> asociaciones;
	
	    @DocumentReference
	    private List<Competiciones> competiciones;
	    
	    @DocumentReference
	    private List<Directores> directores;

    public Clubes() {
        super();
    }

    public Clubes(String id, @NotEmpty String nombre, List<Jugadores> jugadores, List<Asociaciones> asociaciones,
                  List<Competiciones> competiciones, List<Directores> directores) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.asociaciones = asociaciones;
        this.competiciones = competiciones;
        this.directores = directores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Asociaciones> getAsociaciones() {
        return asociaciones;
    }

    public void setAsociaciones(List<Asociaciones> asociaciones) {
        this.asociaciones = asociaciones;
    }

    public List<Competiciones> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competiciones> competiciones) {
        this.competiciones = competiciones;
    }
    
    public List<Directores> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Directores> directores) {
        this.directores = directores;
    }
}
