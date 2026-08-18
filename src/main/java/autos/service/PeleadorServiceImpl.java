package autos.service;

import autos.iservice.PeleadorIService;
import autos.entidades.Peleador;
import autos.repository.PeleadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeleadorServiceImpl implements PeleadorIService {

    @Autowired
    private PeleadorRepository peleadorRepository;

    @Override
    public List<Peleador> findAllPeleadores() {
        return peleadorRepository.findAll();
    }

    @Override
    public Peleador savePeleador(Peleador peleador) {
        return peleadorRepository.save(peleador);
    }
}