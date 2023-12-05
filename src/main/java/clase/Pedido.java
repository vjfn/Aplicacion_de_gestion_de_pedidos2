package clase;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Pedido contiene la solicitud de productos realizada por un usuario, la fecha de la misma
 * el codigo de los productos, el usuario que realizó el pedido y el total.
 */
@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String date;
    @Transient
    private Integer usuarioId;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;


    private Integer total;

    @Transient
    private List<Item> items = new ArrayList<>();

    public Pedido(Integer id, String codigo, String date, Integer usuarioId, Integer total, ArrayList<Item> items) {
        this.id = id;
        this.codigo = codigo;
        this.date = date;
        this.usuarioId = usuarioId;
        this.total = total;
        this.items = items;
    }

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", date='" + date + '\'' +
                ", usuarioId=" + usuarioId +
                ", usuario=" + usuario.getMail() +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
