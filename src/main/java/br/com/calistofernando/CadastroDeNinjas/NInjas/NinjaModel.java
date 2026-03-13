package br.com.calistofernando.CadastroDeNinjas.NInjas;

import br.com.calistofernando.CadastroDeNinjas.Missions.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_ninja_registration")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
    //Um ninja tem apenas uma única missão
    @ManyToOne
    @JoinColumn(name = "missions_id")
    private MissionModel mission;
}
