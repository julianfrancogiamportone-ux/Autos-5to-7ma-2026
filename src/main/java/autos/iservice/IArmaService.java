package autos.iservice;
import autos.entidades.Arma;
import java.util.List;

public interface IArmaService {
    public List<Arma> findAllCharacters();
    public Arma saveCharacter(Arma arma);
}
