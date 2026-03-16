package br.com.calistofernando.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mission")

public class MissionController {

    @PostMapping("/create")
    public String createMission(){
        return "Creating Mission...";
    }

    @GetMapping("/all")
    public String showAllMissions() {
        return "Showing all Missions...";
    }

    @PutMapping("/modify")
    public String modifyMission(){
        return "Modifying Mission...";
    }

    @DeleteMapping("/delete")
    public String deleteMission(){
        return "Deleting Mission...";
    }
}
