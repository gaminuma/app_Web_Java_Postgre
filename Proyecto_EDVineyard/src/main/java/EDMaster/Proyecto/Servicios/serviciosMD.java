package EDMaster.Proyecto.Servicios;


import EDMaster.Proyecto.Entidades.Empresa;
import EDMaster.Proyecto.Entidades.MovimientoDinero;
import EDMaster.Proyecto.Repositorio.MovimientosRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
//import java.util.Set;


@Service
public class serviciosMD {

    private EmpresaServicios empresaServicios;
    private MovimientosRepositorio repositorio;

    public serviciosMD(MovimientosRepositorio repositorio, EmpresaServicios empresaServicios) {
        this.repositorio = repositorio;
        this.empresaServicios = empresaServicios;
    }

    /*public Set<MovimientoDinero> ListaMovimiento(Long id){
        Empresa emp = this.empresaServicios.buscarEmpresa(id).get();
        return emp.getMovimientoDineros();
    }*/

    public List<MovimientoDinero> ListaMovimientos(Long id){
        Empresa emp = this.empresaServicios.buscarEmpresa(id).get();
        return (List<MovimientoDinero>) emp.getMovimientoDineros();
    }

    public Float totalAcum(Long id){
        Empresa empresa = this.empresaServicios.buscarEmpresa(id).get();
        float acum = 0;
        for(MovimientoDinero mov: empresa.getMovimientoDineros()){
            acum += mov.getMonto();
        }

        return acum;
    }


    public MovimientoDinero BuscarP(Long id, int index) {
        Empresa emp = this.empresaServicios.buscarEmpresa(id).get();
        MovimientoDinero mov = null;
        for(MovimientoDinero p: emp.getMovimientoDineros()){
            if (p.getId() == index){
                mov = new MovimientoDinero(p.getId(), p.getConcepto(), p.getMonto(), p.getEmpleado(), emp);
                break;
            }
        }
        
        return mov;
    }

    public String crearMD(MovimientoDinero movimiento, Long id) {
        Empresa emp = this.empresaServicios.buscarEmpresa(id).get();
        
        movimiento.setEmpresa(emp);

        this.repositorio.save(movimiento);

        return "Se creó el movimiento";
    }

    public String eliminarMovimiento(int index, Long id) {
        Empresa emp = this.empresaServicios.buscarEmpresa(id).get();
        MovimientoDinero mov = null;
        for(MovimientoDinero p: emp.getMovimientoDineros()){
            if (p.getId() == index){
                mov = new MovimientoDinero(p.getId(), p.getConcepto(), p.getMonto(), p.getEmpleado(), emp);
                
            }
        }

        if (mov != null){
            emp.getMovimientoDineros().remove(mov);
            this.repositorio.deleteById(index);
            return"Se elimina el movimiento exitosamente";

        }
        else{
            return"No se elimino el movimiento";
        }

    }

    
    public MovimientoDinero actualizarMovimientos(int index, Map<Object,Object> p) {
        MovimientoDinero mov = repositorio.findById(index).get();
        p.forEach((key,value)->{
            Field campo= ReflectionUtils.findField(MovimientoDinero.class,(String)key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo,mov,value);
        });
        return repositorio.save(mov);
        

    }

    public MovimientoDinero actualizarMov(int id, MovimientoDinero mov){
        MovimientoDinero movimientoDinero = BuscarP((long)1,id);

        movimientoDinero.setConcepto(mov.getConcepto());
        movimientoDinero.setMonto(mov.getMonto());
        movimientoDinero.setEmpleado(mov.getEmpleado());

        return repositorio.save(movimientoDinero);
    }
}