package EDMaster.Proyecto.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import EDMaster.Proyecto.Entidades.MovimientoDinero;

@Repository
@EnableJpaRepositories
public interface MovimientosRepositorio extends JpaRepository<MovimientoDinero, Integer> {
    
}
