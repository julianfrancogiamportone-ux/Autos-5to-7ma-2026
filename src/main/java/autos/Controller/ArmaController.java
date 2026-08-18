package autos.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import autos.entidades.Arma;
import autos.iservice.IArmaService;

@RestController
@RequestMapping("/api/characters/armas")
public class ArmaController {

    @Autowired
    private IArmaService armaService;
    @GetMapping
    public List<Arma> getAllArmamentos() {
    return armaService.findAllArmas();
    }
    @PostMapping
    public Arma createArma(@RequestBody Arma arma) {
    return armaService.saveArma(arma);
    }
    }
