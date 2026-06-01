package autos.iservice;
import autos.entidades.Ataque;
import java.util.List;

public interface AtaqueIService {
    public List<Ataque> findAllCharacters();
    public Ataque saveCharacter(Ataque ataque);
}
