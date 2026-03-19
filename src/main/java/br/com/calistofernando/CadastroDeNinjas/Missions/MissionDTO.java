package br.com.calistofernando.CadastroDeNinjas.Missions;

import br.com.calistofernando.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MissionDTO {
    private Long id;
    private String name;
    private MissionDifficulty difficulty;
    private List<NinjaModel> ninjas;
}
