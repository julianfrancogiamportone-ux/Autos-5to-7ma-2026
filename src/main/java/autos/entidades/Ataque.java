package autos.entidades;

import jakarta.persistence.*;
import java.util.List;
@Entity

public class Ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre; 
    private int costoEnergia; 
    private int danioBase;

    @ManyToMany(mappedBy = "habilidadesAtaques") 
    private List<Peleador> peleadores2List; 


    public Ataque() {
    }


    public Ataque(Long id, String nombre, int costoEnergia, int danioBase) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.danioBase = danioBase;
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

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }
}




