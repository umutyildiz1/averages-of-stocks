module com.umutyildiz.averageofpurchased {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.umutyildiz.averageofpurchased to javafx.fxml;
    exports com.umutyildiz.averageofpurchased;

    //needed for HTTP
    requires unirest.java;

    //needed for JSON
    requires com.google.gson;
    requires java.sql;
    //needed for JSON
    //opens com.umutyildiz.averageofpurchased.dto.AmountDto to gson;
    //opens com.edencoding.models.dogs to gson;
}
