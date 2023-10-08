	package com.proyectomomgo1.app.Entity;
	
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.validation.constraints.NotEmpty;
	import jakarta.validation.constraints.NotNull;
	
	
	@Document(collection = "jugadores")
	public class Jugadores {
	
	    @Id
	    private String id;
	
	    @NotEmpty
	    private String name;
	
	    @NotEmpty
	    private String numero;
	
	    @NotEmpty
	    private String posicion;
	
	    @NotNull 
	    private Integer edad; 
	    
	    @DocumentReference
	    private Clubes club;
	    
	    public String getId() {
	        return id;
	    }
	
	    public void setId(String id) {
	        this.id = id;
	    }
	
	    public String getName() {
	        return name;
	    }
	
	    public void setName(String name) {
	        this.name = name;
	    }
	


	    public String getNumero() {
	        return numero;
	    }
	
	    public void setNumero(String numero) {
	        this.numero = numero;
	    }
	
	    public String getPosicion() {
	        return posicion;
	    }
	
	    public void setPosicion(String posicion) {
	        this.posicion = posicion;
	    }
	
	    public Integer getEdad() {
	        return edad;
	    }
	
	    public void setEdad(Integer edad) {
	        this.edad = edad;
	    }

		public Clubes getClub() {
			return club;
		}

		public void setClub(Clubes club) {
			this.club = club;
		}
	    
	    
	}
