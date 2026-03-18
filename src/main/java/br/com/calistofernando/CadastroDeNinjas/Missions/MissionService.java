package br.com.calistofernando.CadastroDeNinjas.Missions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionModel> showAllMissions() {
        return missionRepository.findAll();
    }
}
