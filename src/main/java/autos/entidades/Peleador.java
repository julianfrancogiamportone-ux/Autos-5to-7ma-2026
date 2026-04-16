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

    public Peleador() {
    }

    public Peleador(String nombre, int puntosVida, int energia, float defensaBase, Arma armaEquipada, List<Arma> inventario, List<Ataque> habilidades) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.armaEquipada = armaEquipada;
        this.inventario = inventario;
        this.habilidades = habilidades;
    }

    public Peleador(Long id, String nombre, int puntosVida, int energia, float defensaBase, Arma armaEquipada, List<Arma> inventario, List<Ataque> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.armaEquipada = armaEquipada;
        this.inventario = inventario;
        this.habilidades = habilidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public float getDefensaBase() {
        return defensaBase;
    }

    public void setDefensaBase(float defensaBase) {
        this.defensaBase = defensaBase;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public List<Arma> getInventario() {
        return inventario;
    }

    public void setInventario(List<Arma> inventario) {
        this.inventario = inventario;
    }

    public List<Ataque> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Ataque> habilidades) {
        this.habilidades = habilidades;
    }
}
