package com.MiPortfolio.Oscar.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEstudios {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    @NotBlank
    private String fin;

    @NotBlank
    private String titulo;
//constructores

    public dtoEstudios() {
    }

    public dtoEstudios(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

   
 

//getter y setter
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
