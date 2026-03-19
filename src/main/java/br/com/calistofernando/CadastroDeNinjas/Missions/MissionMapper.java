package br.com.calistofernando.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Component;

@Component

public class MissionMapper {

    public MissionDTO map(MissionModel missionModel){

        MissionDTO missionDTO = new MissionDTO();

        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setDifficulty(missionModel.getDifficulty());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }

    public MissionModel map(MissionDTO missionDTO) {

        MissionModel missionModel = new MissionModel();

        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setDifficulty(missionDTO.getDifficulty());
        missionModel.setNinjas(missionDTO.getNinjas());

        return missionModel;
    }

}
