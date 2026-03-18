package br.com.calistofernando.CadastroDeNinjas.Missions;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mission")
@RequiredArgsConstructor

public class MissionController {

    private final MissionService missionService;

    @PostMapping("/create")
    public MissionModel addMission(@RequestBody MissionModel missionModel) {
        return this.missionService.addMission(missionModel);
    }

    @GetMapping("/all")
    public List<MissionModel> showAllMissions() {
        return missionService.showAllMissions();
    }

    @GetMapping("/id/{id}")
    public MissionModel getMissionByID(@PathVariable Long id) {
        return this.missionService.getMissionByID(id);
    }

    @PutMapping("/modify/{id}")
    public MissionModel modifyMissionByID (@PathVariable Long id, @RequestBody MissionModel missionModel) {
        return this.missionService.modifyMissionByID(id, missionModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMission(@PathVariable Long id) {
        this.missionService.deleteMissionByID(id);
    }
}
