package br.com.calistofernando.CadastroDeNinjas.NInjas;

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

    @PostMapping("/create")
    public String createNinja(){
        return "Ninja created!";
    }

    @GetMapping("/all")
    public List<NinjaModel> showAllNinjas(){
        return this.ninjaService.showAllNinjas();
    }

    @GetMapping("/id/{id}")
    public NinjaModel showByID(@PathVariable Long id){
        return this.ninjaService.findNinjaByID(id);
    }

    @PutMapping("/modify")
    public String modifyNinja(){
        return "Modifying ninja!";
    }

    @DeleteMapping("/delete")
    public String deleteNinja(){
        return "Deleting Ninja!";
    }

}
