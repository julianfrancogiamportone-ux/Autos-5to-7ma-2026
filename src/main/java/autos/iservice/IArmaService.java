package autos.iservice;
import autos.entidades.Arma;
import java.util.List;

public interface IArmaService {
    public List<Arma> findAllArmas();
    public Arma saveArma(Arma arma);
}
