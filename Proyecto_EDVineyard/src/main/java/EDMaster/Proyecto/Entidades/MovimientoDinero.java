package EDMaster.Proyecto.Entidades;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {

    @Id
    @Column(unique = true, length = 30)
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //generar automaticamente un valor
    private int id;

    @Column(nullable = false, length = 30)
    private  String concepto;

    @Column(nullable = false, length = 50)
    private  float monto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Empleado_id", referencedColumnName = "id", nullable = false)
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Empresa_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Empresa empresa;


    public MovimientoDinero() {     //Constructor vacio
    }

    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public MovimientoDinero(int id, String concepto, float monto,Empleado empleado, Empresa empresa) { //Constructor
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado =empleado;
        this.empresa = empresa;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "id=" + id +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", empleado=" + empleado +
                ", empresa=" + empresa +
                '}';
    }
}
