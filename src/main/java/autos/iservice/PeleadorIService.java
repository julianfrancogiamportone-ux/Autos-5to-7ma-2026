package autos.iservice;
import java.util.List;
import autos.entidades.Peleador;

public interface PeleadorIService { 
    public List<Peleador> findAllPeleadores(); 
    public Peleador savePeleador(Peleador peleador); 
} 
