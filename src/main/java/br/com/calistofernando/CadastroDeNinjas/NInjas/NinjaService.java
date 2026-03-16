package br.com.calistofernando.CadastroDeNinjas.NInjas;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
