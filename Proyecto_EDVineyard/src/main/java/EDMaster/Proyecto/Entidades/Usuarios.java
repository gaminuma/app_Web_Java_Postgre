package EDMaster.Proyecto.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email, image, auth0Id, nombre;


    public Usuarios() {
    }


    public Usuarios(String email, String image, String auth0Id, String nombre) {
        this.email = email;
        this.image = image;
        this.nombre = nombre;
        this.auth0Id = auth0Id;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public String getAuth0Id() {
        return auth0Id;
    }


    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
