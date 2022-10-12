package EDMaster.Proyecto.Entidades;

import javax.persistence.*;


@Entity
@Table(name = "Perfil")
public class Perfil{
    //Atributos para la clase. El atributo user debemos saber cómo implementarlo
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column
    private String imagen;

    @Column(nullable = false)
    private  String telefono;

    //@OneToOne(mappedBy = "perfil")
    //private Empleado empleado;
    

    //Constructor para la clase
    public Perfil(String id, String telefono) {
        this.id = id;
        this.imagen = "0";
        this.telefono = telefono;
    }
    public Perfil(){
        
    }

    //Getters y setters para la clase
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getimagen() {
        return imagen;
    }
    public void setimagen(String imagen) {
        this.imagen = imagen;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /*
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }*/

    @Override
    public String toString() {
        return "Perfil = [id=" + id + ", imagen=" + imagen + ", telefono=" + telefono + "]";
    }
    
    

    //Aún no he creado el "createdAt" ni "updatedAt", no sé si son métodos o atributos
    
}