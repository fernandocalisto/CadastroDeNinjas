package br.com.calistofernando.CadastroDeNinjas.NInjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping("/welcome")
    public String welcome() {
        return "This is my first route";
    }

    @PostMapping("/create")
    public String createNinja(){
        return "Ninja created!";
    }

    @GetMapping("/all")
    public String showAllNinjas(){
        return "Show all ninjas";
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
