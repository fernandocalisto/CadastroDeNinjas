package br.com.calistofernando.CadastroDeNinjas.NInjas;

import br.com.calistofernando.CadastroDeNinjas.Missions.MissionModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_ninja_registration")

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

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public NinjaModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
