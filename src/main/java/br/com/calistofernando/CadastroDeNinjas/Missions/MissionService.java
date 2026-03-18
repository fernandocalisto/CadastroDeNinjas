package br.com.calistofernando.CadastroDeNinjas.Missions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionModel> showAllMissions() {
        return missionRepository.findAll();
    }

    public MissionModel getMissionByID(Long id) {
        Optional<MissionModel> missionModel = missionRepository.findById(id);
        return missionModel.orElse(null);
    }

    public MissionModel addMission(MissionModel missionModel) {
        return this.missionRepository.save(missionModel);
    }

    public void deleteMissionByID (Long id) {
        this.missionRepository.deleteById(id);
    }

    public MissionModel modifyMissionByID (Long id, MissionModel missionModel) {
        if (this.missionRepository.existsById(id)){
            missionModel.setId(id);
            return this.missionRepository.save(missionModel);
        }
        return null;
    }
}
