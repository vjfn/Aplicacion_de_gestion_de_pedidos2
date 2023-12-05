package clase;

import java.util.ArrayList;

/**
 * La clase Pedido contiene la solicitud de productos realizada por un usuario, la fecha de la misma
 * el codigo de los productos, el usuario que realizó el pedido y el total.
 */
public class Pedido {

    private Integer id;
    private String codigo;
    private String date;
    private Integer usuarioId;
    private Integer total;
    private ArrayList<Item> items = new ArrayList<>();

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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", date='" + date + '\'' +
                ", usuarioId=" + usuarioId +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
