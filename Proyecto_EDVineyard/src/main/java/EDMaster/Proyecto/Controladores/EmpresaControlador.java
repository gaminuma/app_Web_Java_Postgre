package EDMaster.Proyecto.Controladores;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import EDMaster.Proyecto.Entidades.Empresa;
import EDMaster.Proyecto.Servicios.EmpresaServicios;

@RestController
public class EmpresaControlador {
    private EmpresaServicios servicios;

    public EmpresaControlador(EmpresaServicios servicios) {
        this.servicios = servicios;
    }


    @GetMapping("/enterprisess")
    public ArrayList<Empresa> listarEmpresas(){
        return this.servicios.listarEmpresas();
    }

    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> buscarEmpresa(@PathVariable("id") Long id){
        return this.servicios.buscarEmpresa(id);
    }

    @PostMapping("enterprises")
    public String crearEmpresa(@RequestBody Empresa empresa){
        return this.servicios.crearEmpresa(empresa);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarCampo(@PathVariable("id") Long id, @RequestBody Map<Object,Object> mapeoEmp){
        return this.servicios.actualizarCampo(id, mapeoEmp);
    }

    @DeleteMapping("enterprises/{id}")
    public String eliminarEmpresa(@PathVariable Long id){
        return this.servicios.eliminarEmpresa(id);
    }

}


