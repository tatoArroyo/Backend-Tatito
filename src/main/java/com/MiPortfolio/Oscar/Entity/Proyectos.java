
package com.MiPortfolio.Oscar.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
 private int id;
 private String nombre;
 private String acercaproyec;
 //constructor

    public Proyectos() {
    }

    public Proyectos(String nombre, String acercaproyec) {
        this.nombre = nombre;
        this.acercaproyec = acercaproyec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
