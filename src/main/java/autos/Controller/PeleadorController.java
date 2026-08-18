package autos.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import autos.entidades.Peleador;
import autos.iservice.PeleadorIService;

@RestController 
@RequestMapping("/api/peleadores") 
public class PeleadorController { 
    @Autowired
    private final PeleadorIService pService;

    PeleadorController(PeleadorIService pService) {
        this.pService = pService;
    } 
 
    @GetMapping 
    public List<Peleador> getAllPeleadores() { 
        return pService.findAllPeleadores(); 
    } 
 
    @PostMapping 
    public Peleador createPeleador(@RequestBody Peleador peleador) { 
        return pService.savePeleador(peleador); 
    } 
} 