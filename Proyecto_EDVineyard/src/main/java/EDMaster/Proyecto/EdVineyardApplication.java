package EDMaster.Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*import EDMaster.Proyecto.Entidades.Empleado;
import EDMaster.Proyecto.Entidades.Empresa;
import EDMaster.Proyecto.Entidades.MovimientoDinero;
import EDMaster.Proyecto.Entidades.Perfil; */


@SpringBootApplication
public class EdVineyardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdVineyardApplication.class, args);

		/*Empresa Emp1=new Empresa(1234,"EdVineyard", "9001", "0003", "Av las uvas", null, null);
		System.out.println(Emp1.getNombre());
		Emp1.setNombre("EDVINEYARD");
		System.out.println(Emp1.getDireccion());
		Emp1.setDireccion("Av Siempreviva");
		System.out.println(Emp1.getTelefono());
		Emp1.setTelefono("2345");
		System.out.println(Emp1.getNit());
		Emp1.setNit("8001");

		Perfil perf1 = new Perfil("Carlos Sepulveda", "url/tal", "3116543261");
		Empleado emp1 = new Empleado(10287362, "carlos@yahoo.com", perf1, "Administrador", Emp1);
		System.out.println(emp1.getPerfil().getId());
		emp1.CambiarNombre("Camilo Sepulveda");
		System.out.println(emp1.getEmail());
		emp1.setEmail("camiloSvda@gmail.com");
		System.out.println(emp1.getRol());
		emp1.setRol("Operario");
		emp1.setEmpresa(new Empresa(5678,"Otra Empresa", "2408","2453654","cll 44 # 20 98",null,null));
		System.out.println(emp1.toString());



		MovimientoDinero M1=new MovimientoDinero(100000,"Compra de insumos",-200000,emp1);
		System.out.println(M1.getMonto());
		M1.setMonto(-250000);

		MovimientoDinero Venta=new MovimientoDinero(123245,"Venta de pro",1000000,emp1);
		Venta.setConcepto("Venta despues de Iva");
		Venta.setMonto((float) (Venta.getMonto()*0.81));

		System.out.println(Venta.getMonto());

		System.out.println(Venta.getMonto());*/
	}
}
