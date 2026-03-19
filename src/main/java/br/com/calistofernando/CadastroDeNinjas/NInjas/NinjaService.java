package br.com.calistofernando.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> showAllNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .toList();
    }

    public NinjaDTO findNinjaByID(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public void deleteNinjaByID(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO modifyByID(Long id, NinjaModel ninjaModel) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            ninjaModel.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
