package autos.entidades;

import jakarta.persistence.*; 
@Entity

public class Peleador {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int puntosVida; 
    private int energia;
    private float defensaBase; 
    private Arma armaEquipada;
    private List o Arma[] inventario;
    private List o Ataque[] habilidades;
}
//67