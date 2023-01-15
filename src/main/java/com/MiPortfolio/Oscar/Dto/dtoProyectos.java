
package com.MiPortfolio.Oscar.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {
   @NotBlank
    private String nombre;
    @NotBlank
    private String acercaproyec;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String acercaproyec) {
        this.nombre = nombre;
        this.acercaproyec = acercaproyec;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcercaproyec() {
        return acercaproyec;
    }

    public void setAcercaproyec(String acercaproyec) {
        this.acercaproyec = acercaproyec;
    }
    
     
}
