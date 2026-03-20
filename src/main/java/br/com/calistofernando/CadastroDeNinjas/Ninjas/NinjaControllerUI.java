package br.com.calistofernando.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
@RequiredArgsConstructor

public class NinjaControllerUI {

    private final NinjaService ninjaService;

    @GetMapping("/all")
    public String showAllNinjas(Model model){
        List<NinjaDTO> ninjaList = ninjaService.showAllNinjas();
        model.addAttribute("ninjaList", ninjaList);
        return "ninjasList";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaByID(@PathVariable Long id) {
        ninjaService.deleteNinjaByID(id);
        return "redirect:/ninja/ui/all";
    }

    @GetMapping("/id/{id}")
    public String showByID(@PathVariable Long id, Model model){
        NinjaDTO ninjaByID = ninjaService.findNinjaByID(id);
        if (ninjaByID != null){
            model.addAttribute("ninja", ninjaByID);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado!");
            return "ninjasList";
        }
    }

    @GetMapping("/add")
    public String showAddNinjaForm(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarninja";
    }

    @PostMapping("/save")
    public String saveNinja(@ModelAttribute NinjaDTO ninja) {
        ninjaService.createNinja(ninja);
        return "redirect:/ninja/ui/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateNinjaForm(@PathVariable Long id, Model model) {
        NinjaDTO ninjaByID = ninjaService.findNinjaByID(id);
        if (ninjaByID != null) {
            model.addAttribute("ninja", ninjaByID);
            return "atualizarninja";
        }
        return "redirect:/ninja/ui/all";
    }

    @PostMapping("/update/{id}")
    public String updateNinja(@PathVariable Long id, @ModelAttribute NinjaModel ninja) {
        ninjaService.modifyByID(id, ninja);
        return "redirect:/ninja/ui/all";
    }
}
