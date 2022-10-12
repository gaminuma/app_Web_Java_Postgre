package EDMaster.Proyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EDMaster.Proyecto.Entidades.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa,Long>{
    
}
