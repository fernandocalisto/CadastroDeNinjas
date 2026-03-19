package br.com.calistofernando.CadastroDeNinjas.Ninjas;

import br.com.calistofernando.CadastroDeNinjas.Missions.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String rank;
    private MissionModel mission;
}
