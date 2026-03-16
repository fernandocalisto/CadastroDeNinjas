package br.com.calistofernando.CadastroDeNinjas.NInjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // show all ninjas

    public List<NinjaModel> showAllNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel findNinjaByID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }
}
