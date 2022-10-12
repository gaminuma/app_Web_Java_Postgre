package EDMaster.Proyecto.Servicios;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import EDMaster.Proyecto.Entidades.Empresa;
import EDMaster.Proyecto.Repositorio.EmpresaRepositorio;

@Service
public class EmpresaServicios {
    private EmpresaRepositorio repositorio;

    public EmpresaServicios(EmpresaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Empresa> listarEmpresas(){
        return (ArrayList<Empresa>) this.repositorio.findAll();
    }

    public List<Empresa> listarEmpresa1(){
        return this.repositorio.findAll();
    }

    public Optional<Empresa> buscarEmpresa(Long id){    
        return this.repositorio.findById(id);
    }

    public Empresa buscarEmpresa1(Long id){    
        return this.repositorio.findById(id).get();
    }


    public String crearEmpresa(Empresa empresa){
        if(this.repositorio.findById(empresa.getId()).isEmpty()){
            this.repositorio.save(empresa);
            return "Se creó la empresa exitosamente";
        }else{
            return "No se creó la empresa.";
        }
    }

    public Empresa actualizarCampo(Long id, Map<Object,Object> empresaMapeo){
        Empresa emp = this.repositorio.findById(id).get();

        empresaMapeo.forEach((key,value)->{
            Field campo = ReflectionUtils.findField(Empresa.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, emp, value);
        });

        return this.repositorio.save(emp);
    }

    public String eliminarEmpresa(Long id){
        if(this.repositorio.findById(id).isPresent()){
            this.repositorio.deleteById(id);
            return "Se eliminó la empresa exitosamente";
        }else{
            return "No se eliminó la empresa.";
        }
    }

    public Empresa actualizarEmp(Long id, Empresa empresa){
        Empresa emp = buscarEmpresa1(id);
        emp.setDireccion(empresa.getDireccion());
        emp.setNit(empresa.getNit());
        emp.setNombre(empresa.getNombre());
        emp.setTelefono(empresa.getTelefono());

        return repositorio.save(emp);
    }
}
