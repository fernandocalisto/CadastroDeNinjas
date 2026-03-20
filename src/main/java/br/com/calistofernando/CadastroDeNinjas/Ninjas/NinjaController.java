package br.com.calistofernando.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "This is my first route";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + newNinja.getName() + " successfully created!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> showAllNinjas(){
        List<NinjaDTO> ninjaList = ninjaService.showAllNinjas();
        return ResponseEntity.ok(ninjaList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> showByID(@PathVariable Long id){
        NinjaDTO ninjaByID = ninjaService.findNinjaByID(id);
        if (ninjaByID != null) {
            return ResponseEntity.ok(ninjaByID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID: " + id + " NO FOUND!");
        }
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<String> modifyNinjaByID(@PathVariable Long id, @RequestBody NinjaModel ninja){
        if (ninjaService.findNinjaByID(id) != null){
            NinjaDTO modifiedNinja = ninjaService.modifyByID(id, ninja);
            return ResponseEntity.ok("Ninja modified: " + modifiedNinja.getName());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID: " + id + " NOT FOUND!!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaByID(@PathVariable Long id){
        if (ninjaService.findNinjaByID(id) !=  null) {
            ninjaService.deleteNinjaByID(id);
            return ResponseEntity.ok("Ninja successfully deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID: " + id + " NOT FOUND!");
        }
    }

}
