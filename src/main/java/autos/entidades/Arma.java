package autos.entidades;

import jakarta.persistence.*; 
@Entity

public class Arma {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    private String nombre; 
    private int bonificadorDanio;
    private float peso;
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getBonificadorDanio() {
        return bonificadorDanio;
    }
    public float getPeso() {
        return peso;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setBonificadorDanio(int bonificadorDanio) {
        this.bonificadorDanio = bonificadorDanio;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public Arma() {
    }
    public Arma(String nombre, int bonificadorDanio, float peso) {
        this.nombre = nombre;
        this.bonificadorDanio = bonificadorDanio;
        this.peso = peso;
    }
    public Arma(Long id, String nombre, int bonificadorDanio, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadorDanio = bonificadorDanio;
        this.peso = peso;
    }
}
