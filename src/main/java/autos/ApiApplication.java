package autos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import autos.entidades.Peleador;
import autos.entidades.Arma;
import autos.entidades.Ataque;
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		Arma arma1 = new Arma();
		arma1.setNombre("Espada de Kusanagi");
		arma1.setBonificadorDanio(50);
		arma1.setPeso(5.0f);

		Arma arma2 = new Arma();
		arma2.setNombre("Espada de Vegeta");
		arma2.setBonificadorDanio(50);
		arma2.setPeso(5.0f);
		
		Arma arma3 = new Arma();
		arma3.setNombre("Espada de Trunks");
		arma3.setBonificadorDanio(50);
		arma3.setPeso(5.0f);

		Peleador peleador1 = new Peleador();
		peleador1.setNombre("Goku");
		peleador1.setPuntosVida(1000);
		peleador1.setEnergia(500);
		peleador1.setDefensaBase(0.2f);

	}

}
