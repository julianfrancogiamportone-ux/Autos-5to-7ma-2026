package autos.service;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import autos.entidades.Arma;
import autos.repository.ArmaRepository;
import autos.iservice.IArmaService;

@Service 
public class ArmaService implements IArmaService { 
 @Autowired 
    private ArmaRepository aRepository; 
    public List<Arma> findAllArmas() { 
        return aRepository.findAll(); 
    } 
    public Arma saveArma(Arma arma) { 
        return aRepository.save(arma); 
    } 
}
