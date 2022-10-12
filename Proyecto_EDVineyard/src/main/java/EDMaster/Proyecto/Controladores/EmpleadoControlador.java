package EDMaster.Proyecto.Controladores;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import EDMaster.Proyecto.Entidades.Empleado;
import EDMaster.Proyecto.Servicios.EmpleadoServicio;


@RestController
public class EmpleadoControlador {
    private EmpleadoServicio servicios;


    public EmpleadoControlador(EmpleadoServicio servicios){
        this.servicios = servicios;        
    }

    @GetMapping("/userss")
    public List<Empleado> listarEmpleados(){
        return this.servicios.listarEmpleados();
    }

    @GetMapping("/user/{id}")
    public Optional<Empleado> buscarEmpleado(@PathVariable("id") Long id){
        return this.servicios.buscarEmpleado(id);       
    }

    @PostMapping("/users")
    public String crearEmpleado(@RequestBody Empleado empleado){
        return this.servicios.crearEmpleado(empleado);
    } 

    @PatchMapping("/user/{id}")
    public Empleado actualizarCampo(@PathVariable("id") Long id, @RequestBody Map<Object, Object> mapeoEmpleado){
        return this.servicios.actualizarCampo(id, mapeoEmpleado);        
    }

    @DeleteMapping("/user/{id}")
    public String eliminarEmpleado(@PathVariable("id") Long id){
        return this.servicios.eliminarEmpleado(id);
    }
}
