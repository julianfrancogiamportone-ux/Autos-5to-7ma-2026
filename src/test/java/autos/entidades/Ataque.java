package autos.entidades;

import jakarta.persistence.*; 
@Entity

public class Ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;
    private String nombre; 
    private int costoEnergia; 
    private int danioBase;
}
