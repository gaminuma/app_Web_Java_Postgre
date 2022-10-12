package EDMaster.Proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import EDMaster.Proyecto.Entidades.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil,String>{
    
}
