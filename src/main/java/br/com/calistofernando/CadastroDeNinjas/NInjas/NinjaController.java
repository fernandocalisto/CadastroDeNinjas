package br.com.calistofernando.CadastroDeNinjas.Ninjas;

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
    public NinjaDTO addNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.createNinja(ninja);
    }

    @GetMapping("/all")
    public List<NinjaDTO> showAllNinjas(){
        return this.ninjaService.showAllNinjas();
    }

    @GetMapping("/id/{id}")
    public NinjaDTO showByID(@PathVariable Long id){
        return this.ninjaService.findNinjaByID(id);
    }

    @PutMapping("/modify/{id}")
    public NinjaDTO modifyNinjaByID(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return this.ninjaService.modifyByID(id, ninja);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinjaByID(@PathVariable Long id){
        this.ninjaService.deleteNinjaByID(id);
    }

}
