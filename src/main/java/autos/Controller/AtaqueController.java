package autos.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import autos.entidades.Arma;
import autos.entidades.Ataque;
import autos.iservice.AtaqueIService;

@RestController
@RequestMapping("/api/characters/ataques")
public class AtaqueController {

    @Autowired
    private AtaqueIService ataqueService;
    @GetMapping
    public List<Ataque> getAllAtaques() {
    return ataqueService.findAllCharacters();
    }
    @PostMapping
    public Ataque createCharacter(@RequestBody Ataque ataque) {
    return ataqueService.saveCharacter(ataque);
    }
    }

