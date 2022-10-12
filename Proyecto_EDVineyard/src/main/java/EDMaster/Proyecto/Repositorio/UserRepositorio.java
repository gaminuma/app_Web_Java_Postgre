package EDMaster.Proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EDMaster.Proyecto.Entidades.Usuarios;

@Repository
public interface UserRepositorio extends JpaRepository<Usuarios,Long>{
    Usuarios findByEmail(String email);
}
