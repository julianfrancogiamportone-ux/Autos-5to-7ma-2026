package autos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*; 
@Entity

public class Arma {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY))
    private Long id;  
    private String nombre (String) 
    Private int bonificadorDanio (int) 
    private peso (float)
}

