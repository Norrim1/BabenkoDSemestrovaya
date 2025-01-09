module org.example.babenkopogoda {
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires org.json;
    requires org.apache.commons.io;
    requires commons.logging;
    requires static lombok;
    requires org.controlsfx.controls;
    requires java.net.http;
    requires com.jfoenix;
    requires com.oracle.database.jdbc;


    opens org.example.babenkopogoda to javafx.fxml;
    exports org.example.babenkopogoda;

    //because module javafx.base does not export com.sun.javafx.event to module org.controlsfx.controls
}