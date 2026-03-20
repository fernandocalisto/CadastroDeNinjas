package br.com.calistofernando.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
