package com.umutyildiz.averageofpurchased;

import com.umutyildiz.averageofpurchased.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene= new Scene(fxmlLoader.load(),1005,600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        MainController controller = fxmlLoader.getController();

        stage.setScene(scene);
        stage.setTitle("Average Of Shares");
        stage.show();

        controller.getCategories();
    }

    public static void main(String[] args) {
        launch();
    }
}
