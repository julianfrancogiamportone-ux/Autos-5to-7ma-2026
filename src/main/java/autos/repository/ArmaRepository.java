package autos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import autos.entidades.Arma; 

public interface ArmaRepository extends JpaRepository<Arma, Long> { 
} 