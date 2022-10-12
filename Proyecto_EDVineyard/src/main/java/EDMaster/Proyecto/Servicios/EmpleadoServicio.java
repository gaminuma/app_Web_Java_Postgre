package EDMaster.Proyecto.Servicios;

import java.lang.reflect.Field;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import EDMaster.Proyecto.Repositorio.EmpleadoRepositorio;
import EDMaster.Proyecto.Entidades.Empleado;


@Service
public class EmpleadoServicio {

    private EmpleadoRepositorio repositorio;

    public EmpleadoServicio (EmpleadoRepositorio repositorio) {
        this.repositorio = repositorio;    
    }

    public List<Empleado> listarEmpleados(){
        return  this.repositorio.findAll();
    }

    public Optional<Empleado> buscarEmpleado(long id){
        return this.repositorio.findById(id);
    }

    public Empleado buscarEmpleado1(long id){
        return this.repositorio.findById(id).get();
    }

    public String crearEmpleado(Empleado empleado){
        if (empleado.getId() == null || !this.repositorio.existsById(empleado.getId())){
            this.repositorio.save(empleado);
            return "Se crea el empleado exitosamente";             
        }else{
            return "Ya existe un empleado con ese Id";    
        }
    }
    

    public Empleado actualizarCampo(long id, Map<Object, Object> empleadoMapeo){
        Empleado empleado = this.repositorio.findById(id).get();

        empleadoMapeo.forEach((key,value)->{
            Field campo = ReflectionUtils.findField(Empleado.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, empleado, value);            
        });
        return this.repositorio.save(empleado);
    }

    public String eliminarEmpleado(long id){
        if (this.repositorio.existsById(id)){
            this.repositorio.deleteById(id);
            return "Se eliminó exitosamente el empleado";
        }else{
            return "No existe un empleado con tal Id para ser eliminado";
        }
    }


    public Empleado actualizarEmpl(long id, Empleado empleado){
        Empleado emp = buscarEmpleado1(id);

        emp.getPerfil().setTelefono(empleado.getPerfil().getTelefono());
        emp.setEmail(empleado.getEmail());
        emp.setRol(empleado.getRol());

        return repositorio.save(emp);
    }
}

