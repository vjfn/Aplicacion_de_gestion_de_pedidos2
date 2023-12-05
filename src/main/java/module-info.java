module com.example.aplicacion_de_gestion_de_pedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;

    opens images;
    opens clase;
    opens domain;
    opens com.example.aplicacion_de_gestion_de_pedidos;

    exports com.example.aplicacion_de_gestion_de_pedidos;
}