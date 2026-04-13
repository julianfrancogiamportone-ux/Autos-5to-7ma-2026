package autos.entidades;

import jakarta.persistence.*; 
import java.util.List;
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
    private List<Arma> inventario;
    private List<Ataque> habilidades;
}
