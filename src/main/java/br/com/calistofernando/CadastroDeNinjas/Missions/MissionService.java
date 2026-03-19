package br.com.calistofernando.CadastroDeNinjas.Missions;

import br.com.calistofernando.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public List<MissionDTO> showAllMissions() {
        List<MissionModel> mission  = missionRepository.findAll();
        return mission.stream()
                .map(missionMapper::map)
                .toList();
    }

    public MissionDTO getMissionByID(Long id) {
        Optional<MissionModel> missionModel = missionRepository.findById(id);
        return missionModel.map(missionMapper::map).orElse(null);
    }

    public MissionDTO addMission(MissionDTO missionDTO) {
        MissionModel missionModel = missionMapper.map(missionDTO);
        missionRepository.save(missionModel);
        return missionMapper.map(missionModel);
    }

    public void deleteMissionByID (Long id) {
        this.missionRepository.deleteById(id);
    }

    public MissionDTO modifyMissionByID (Long id, MissionModel missionModel) {
        Optional<MissionModel> missionModelOptional = missionRepository.findById(id);
        if (missionModelOptional.isPresent()) {
            missionModel.setId(id);
            MissionModel savedMission = missionRepository.save(missionModel);
            return missionMapper.map(savedMission);
        }
        return null;
    }
}
