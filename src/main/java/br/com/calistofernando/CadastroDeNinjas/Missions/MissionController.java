package br.com.calistofernando.CadastroDeNinjas.Missions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mission")
@RequiredArgsConstructor

public class MissionController {

    private final MissionService missionService;

    @PostMapping("/create")
    public ResponseEntity<String> addMission(@RequestBody MissionDTO missionModel) {
        MissionDTO newMission = missionService.addMission(missionModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The mission (" + newMission.getName() + ") was successfully created, with ID (" + newMission.getId() + ").");
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionDTO>> showAllMissions() {
        List<MissionDTO> missionDTOList = missionService.showAllMissions();
        return ResponseEntity.ok(missionDTOList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getMissionByID(@PathVariable Long id) {
        MissionDTO missionDTO = missionService.getMissionByID(id);
        if (missionDTO != null){
            return ResponseEntity.ok(missionDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission was NOT FOUND!");
        }
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifyMissionByID (@PathVariable Long id, @RequestBody MissionModel missionModel) {
        MissionDTO missionDTO = missionService.getMissionByID(id);
        if (missionDTO != null){
            MissionDTO savedMission = missionService.modifyMissionByID(id, missionModel);
            return ResponseEntity.ok(savedMission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission NOT FOUND!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {
        if (missionService.getMissionByID(id) != null){
            missionService.deleteMissionByID(id);
            return ResponseEntity.ok("Mission with ID: " + id + " was successfully deleted!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Mission with ID: " + id + " was NOT FOUND!");
    }
}
