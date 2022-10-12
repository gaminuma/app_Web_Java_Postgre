package EDMaster.Proyecto.Controladores;


import EDMaster.Proyecto.Entidades.MovimientoDinero;
import EDMaster.Proyecto.Servicios.serviciosMD;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
//import java.util.Set;

//@RestController
public class controladorMD {

    private serviciosMD servicio;

    public controladorMD(serviciosMD servicio) {
        this.servicio = servicio;
    }
    
    /*@GetMapping("/enterprises/{id}/movements")
    public Set<MovimientoDinero> ListaMD(@PathVariable("id") Long id){
        return this.servicio.ListaMovimiento(id);
    }*/
    
    @GetMapping("/enterprises/{id}/movements/{index}")
    public MovimientoDinero ConsultarMD(@PathVariable("id") Long id, @PathVariable("index") Integer index){
        return this.servicio.BuscarP(id,index);
    }

    @PostMapping("/enterprises/{id}/movements")
    public String crearMD(@RequestBody MovimientoDinero x, @PathVariable("id") Long id){
        return  this.servicio.crearMD(x, id);
    }

    @PatchMapping("/enterprises/movements/{id}")
    public MovimientoDinero actualizarMovimientos(@PathVariable("id")int id, @RequestBody Map<Object,Object> p){
        return  this.servicio.actualizarMovimientos(id,p);
    }

    @DeleteMapping("/enterprises/{id}/movements/{index}")
    public  String eliminarMovimiento(@PathVariable("id") Long id, @PathVariable("index") Integer index){
        return this.servicio.eliminarMovimiento(index, id);
    }

   
    
}
