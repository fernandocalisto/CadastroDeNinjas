package br.com.calistofernando.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component

public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMission(ninjaDTO.getMission());

        return ninjaModel;
    }
    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setEmail(ninjaDTO.getEmail());
        ninjaDTO.setRank(ninjaDTO.getRank());
        ninjaDTO.setMission(ninjaModel.getMission());

        return ninjaDTO;
    }
}
