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
    @ManyToMany 
    @JoinTable( 
 // Nombre de la tabla intermedia en SQL 
        name = "inventario_arma_peleador", 
// FK de esta entidad 
        joinColumns = @JoinColumn(name = "arma_id"),  
// FK de la otra entidad 
        inverseJoinColumns = @JoinColumn(name = "peleador_id")  
    ) 
    private List<Arma> inventarioList; 

    @ManyToMany 
    @JoinTable( 
 // Nombre de la tabla intermedia en SQL 
        name = "ataque_tabla", 
// FK de esta entidad 
        joinColumns = @JoinColumn(name = "tablapeleador_id"),  
// FK de la otra entidad 
        inverseJoinColumns = @JoinColumn(name = "ataque_id")  
    ) 
    private List<Ataque> habilidadesAtaquesList;

    public Peleador() {
    }

    public Peleador(Long id, String nombre, int puntosVida, int energia, float defensaBase, Arma armaEquipada, List<Arma> inventario, List<Ataque> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
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

    
}

