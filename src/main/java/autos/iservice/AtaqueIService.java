package autos.iservice;
import autos.entidades.Ataque;
import java.util.List;

public interface AtaqueIService {
    public List<Ataque> findAllAtaques();
    public Ataque saveAtaque(Ataque ataque);
}
