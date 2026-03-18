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
    public String createMission() {
        return "Creating Mission...";
    }

    @GetMapping("/all")
    public List<MissionModel> showAllMissions() {
        return missionService.showAllMissions();
    }

    @PutMapping("/modify")
    public String modifyMission() {
        return "Modifying Mission...";
    }

    @DeleteMapping("/delete")
    public String deleteMission() {
        return "Deleting Mission...";
    }
}
