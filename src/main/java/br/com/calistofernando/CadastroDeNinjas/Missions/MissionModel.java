package br.com.calistofernando.CadastroDeNinjas.Missions;

import br.com.calistofernando.CadastroDeNinjas.NInjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionDifficulty difficulty;
    // Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "mission")
    private List<NinjaModel> ninjas;
}
