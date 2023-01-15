
package com.MiPortfolio.Oscar.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombreE;
   private String descripcionE;
   
   private String puesto;
   
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date inicio;
   
   
   private Date fin;
   
   //constructor

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
              
    }

    public Experiencia(String puesto, Date inicio, Date fin) {
        this.puesto = puesto;
        this.inicio = inicio;
        this.fin = fin;
    }

    
    }

    
    
   
           
           