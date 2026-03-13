package br.com.calistofernando.CadastroDeNinjas.NInjas;

import br.com.calistofernando.CadastroDeNinjas.Missions.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
