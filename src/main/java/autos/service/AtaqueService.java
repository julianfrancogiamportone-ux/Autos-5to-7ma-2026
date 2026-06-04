package autos.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import autos.entidades.Ataque;
import autos.repository.AtaqueRepository;
import autos.iservice.AtaqueIService;

@Service 
public class AtaqueService implements AtaqueIService { 
 @Autowired 
    private AtaqueRepository aRepository; 
    public List<Ataque> findAllAtaques() { 
        return aRepository.findAll(); 
    } 
    public Ataque saveAtaque(Ataque ataque) { 
        return aRepository.save(ataque); 
    } 
} 