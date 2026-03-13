package br.com.calistofernando.CadastroDeNinjas.Missions;

import br.com.calistofernando.CadastroDeNinjas.NInjas.NinjaModel;
import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Entity
@Table(name = "tb_missions")

public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionDifficulty difficulty;

    // Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "mission")
    private List<NinjaModel> ninjas;

    public MissionModel(String name, MissionDifficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public MissionModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(MissionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }
}
