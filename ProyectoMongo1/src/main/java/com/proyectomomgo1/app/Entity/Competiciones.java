package com.proyectomomgo1.app.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Document(collection = "competicion") 
public class Competiciones {

    @Id
    private String id;

    @NotEmpty
    private String nombre;

    @NotNull
    private Date fechaInicial;

    @NotNull
    private Date fechaFinal;

    @DocumentReference
    private Clubes club;

    public Competiciones() {
        super();
    }

    public Competiciones(String id, @NotEmpty String nombre, @NotNull Date fechaInicial, @NotNull Date fechaFinal, Clubes club) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.club = club;
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

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Clubes getClub() {
        return club;
    }

    public void setClub(Clubes club) {
        this.club = club;
    }
}
