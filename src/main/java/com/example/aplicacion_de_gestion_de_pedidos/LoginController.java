package com.example.aplicacion_de_gestion_de_pedidos;

import clase.Pedido;
import clase.Usuario;
import clase.Sesion;
import domain.DBConnection;
import domain.UsuarioDAO;
import domain.UsuarioDAOHib;
import domain.UsuarioDAOImp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase LoginController controla la lógica de la ventana de Login.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField registerUserField;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private Button btnRegister;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        Pedido p = new Pedido();
//        p.setUsuario( new Usuario("pepe","pepe"));
//        System.out.println(p);
//
//        UsuarioDAOHib usuarioDAOHib = new UsuarioDAOHib();
//        Usuario u = usuarioDAOHib.loadUser("user","user");
//        System.out.println(u);

    }

    @FXML
    public void login(ActionEvent actionEvent) {
        String userMail = userField.getText();
        String userPassword = passField.getText();

        UsuarioDAO usuarioLogin = new UsuarioDAOHib();
        try{
            Usuario usuario = usuarioLogin.loadUser(userMail,userPassword);
            Sesion.setUsuario(usuario);

            System.out.println("Exito al Logear");

            MainApplication.loadDahsboard();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void register(ActionEvent actionEvent) {
        String userMail = registerUserField.getText();
        String userPassword = registerPasswordField.getText();

        UsuarioDAOImp usuarioRegister = new UsuarioDAOImp(DBConnection.getConnection());

        try{
            Usuario usuario = usuarioRegister.createUser(userMail,userPassword);
            Sesion.setUsuario(usuario);

            System.out.println("Exito al registro");
            MainApplication.loadDahsboard();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}