package autos.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import autos.entidades.Peleador;
import autos.repository.PeleadorRepository;
import autos.iservice.PeleadorIService;

@Service 
public class PeleadorService implements PeleadorIService { 
 @Autowired 
    private PeleadorRepository pRepository; 
    public List<Peleador> findAllPeleadores() { 
        return pRepository.findAll(); 
    } 
    public Peleador savePeleador(Peleador peleador) { 
        return pRepository.save(peleador); 
    } 
} 