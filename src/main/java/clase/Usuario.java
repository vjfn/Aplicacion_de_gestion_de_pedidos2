package clase;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * Contiene la información  del usuario, su ID, nombre, contraseña, mail y un arraylist de sus pedidos.
 */

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private String mail;
    @Transient
    private ArrayList<Pedido> pedido;

    public Usuario(Integer id, String name, String password, String mail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
    }
    public Usuario(String mail, String password)  {
        this.pedido = new ArrayList<Pedido>();
    }

    public Usuario() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {   this.password = password;  }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + mail + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}
