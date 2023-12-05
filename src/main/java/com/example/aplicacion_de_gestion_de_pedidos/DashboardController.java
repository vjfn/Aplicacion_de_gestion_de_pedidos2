package com.example.aplicacion_de_gestion_de_pedidos;

import clase.Usuario;
import clase.Pedido;
import clase.Sesion;
import domain.DBConnection;
import domain.PedidoDAOImp;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

/**
 * La clase DashboardController controla la lógica de la ventana de pedidos.
 */
public class DashboardController implements Initializable {


    @javafx.fxml.FXML
    private MenuItem btnLogOut;
    @javafx.fxml.FXML
    private Label labelNombreUsuario;
    private ObservableList<Pedido> observablePedidos;
    @javafx.fxml.FXML
    private TableView ordersTable;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderId;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderCodigo;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderDate;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderUsuarioId;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        labelNombreUsuario.setText("Bienvenido: " + Sesion.getUsuario().getName() + "!!");

        orderId.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });
        orderCodigo.setCellValueFactory((fila) -> {
            String codigo = String.valueOf(fila.getValue().getCodigo());
            return new SimpleStringProperty(codigo);
        });
        orderDate.setCellValueFactory((fila) -> {
            String date = String.valueOf(fila.getValue().getDate());
            return new SimpleStringProperty(date);
        });
        orderUsuarioId.setCellValueFactory((fila) -> {
            String usuario_id = String.valueOf(fila.getValue().getUsuarioId());
            return new SimpleStringProperty(usuario_id);
        });
        orderTotal.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        observablePedidos = FXCollections.observableArrayList();
        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
        observablePedidos.addAll(Sesion.getPedidos());
        ordersTable.setItems(observablePedidos);

        ordersTable.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            seleccionarPedido((Pedido) ordersTable.getSelectionModel().getSelectedItem());
        });

    }

    private void seleccionarPedido(Pedido pedido) {
        Sesion.setFocusedOrder(pedido);
        Sesion.setItems(pedido.getItems());;
        MainApplication.loadOrderDetail();
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) { MainApplication.returnLogin(); }

}
