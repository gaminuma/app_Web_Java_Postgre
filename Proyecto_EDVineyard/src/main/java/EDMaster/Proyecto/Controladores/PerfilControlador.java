package EDMaster.Proyecto.Controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import EDMaster.Proyecto.Entidades.Perfil;
import EDMaster.Proyecto.Servicios.PerfilServicio;

@RestController
public class PerfilControlador {
    
    private PerfilServicio servicio;

    public PerfilControlador(PerfilServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/MostrarPerfiles")
    public ArrayList<Perfil> verPerfiles(){
        return this.servicio.verPefiles();
    }

    @GetMapping("/BuscarPerfil/{nombre}")
    public Optional<Perfil> buscarPerfil(@PathVariable("nombre") String nombre){
        return this.servicio.buscarPerfil(nombre);
    }

    @PostMapping("/CrearPerfil")
    public String crearPefil(@RequestBody Perfil perfil){
        return this.servicio.crearPerfil(perfil);
    }

    @PutMapping("/ActualizarPerfil")
    public String actualizarPerfil(@RequestBody Perfil perfil){
        return this.servicio.actualizarPerfil(perfil);
    }

    @DeleteMapping("/EliminarPerfil/{id}")
    public String eliminarPerfil(@PathVariable("id") String id){
        return this.servicio.eliminarPerfil(id);
    }
}
