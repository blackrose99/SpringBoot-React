package com.proyectomomgo1.app.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.validation.constraints.NotEmpty;


@Document(collection = "asociacion") 
public class Asociaciones {

    @Id
    private String id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String pais;

    @NotEmpty
    private String presidente;

    @NotEmpty
    private String siglas;
    
    @DocumentReference
    private List<Clubes> clubes;

    public Asociaciones() {
    
    }

	public Asociaciones(String id, @NotEmpty String nombre, @NotEmpty String pais, @NotEmpty String presidente,
			@NotEmpty String siglas, List<Clubes> clubes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.presidente = presidente;
		this.siglas = siglas;
		this.clubes = clubes;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public List<Clubes> getClubes() {
		return clubes;
	}

	public void setClubes(List<Clubes> clubes) {
		this.clubes = clubes;
	}

   
}

