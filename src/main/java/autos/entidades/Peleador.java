package autos.entidades;

import jakarta.persistence.*; 
import java.util.List;

@Entity
@Table(name = "peleador") // Asegúrate de que coincida con el nombre de tu tabla en MySQL
public class Peleador {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int puntosVida; 
    private int energia;
    private float defensaBase; 
    
    @Column(name = "imagen", length = 500)
    private String imagen; 

    @ManyToMany 
    @JoinTable( 
        name = "inventario_arma_peleador", 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        inverseJoinColumns = @JoinColumn(name = "arma_id")  
    ) 
    private List<Arma> inventarioList; 

    @ManyToMany 
    @JoinTable( 
        name = "ataque_tabla", 
        joinColumns = @JoinColumn(name = "tablapeleador_id"),  
        inverseJoinColumns = @JoinColumn(name = "ataque_id")  
    ) 
    private List<Ataque> habilidadesAtaquesList;

    public Peleador() {
    }

    public Peleador(Long id, String nombre, int puntosVida, int energia, float defensaBase, String imagen, List<Arma> inventarioList, List<Ataque> habilidadesAtaquesList) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.imagen = imagen;
        this.inventarioList = inventarioList;
        this.habilidadesAtaquesList = habilidadesAtaquesList;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Arma> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Arma> inventarioList) {
        this.inventarioList = inventarioList;
    }

    public List<Ataque> getHabilidadesAtaquesList() {
        return habilidadesAtaquesList;
    }

    public void setHabilidadesAtaquesList(List<Ataque> habilidadesAtaquesList) {
        this.habilidadesAtaquesList = habilidadesAtaquesList;
    }
}