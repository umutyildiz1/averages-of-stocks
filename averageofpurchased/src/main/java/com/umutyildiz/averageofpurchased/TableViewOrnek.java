package com.umutyildiz.averageofpurchased;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewOrnek extends Application {
    @Override
    public void start(Stage primaryStage) {
        TableView<VeriModeli> tableView = new TableView<>();

        TableColumn<VeriModeli, String> sutun1 = new TableColumn<>("Sütun 1");
        sutun1.setCellValueFactory(cellData -> cellData.getValue().sutun1Property());

        TableColumn<VeriModeli, String> sutun2 = new TableColumn<>("Sütun 2");
        sutun2.setCellValueFactory(cellData -> cellData.getValue().sutun2Property());

        TableColumn<VeriModeli, String> sutun3 = new TableColumn<>("Sütun 3");
        sutun3.setCellValueFactory(cellData -> cellData.getValue().sutun3Property());

        tableView.getColumns().addAll(sutun1, sutun2, sutun3);

        ObservableList<VeriModeli> veriListesi = FXCollections.observableArrayList(
                new VeriModeli("Veri1-1", "Veri1-2", "Veri1-3"),
                new VeriModeli("Veri2-1", "Veri2-2", "Veri2-3"),
                new VeriModeli("Veri3-1", "Veri3-2", "Veri3-3")
        );

        tableView.setItems(veriListesi);

        VBox vBox = new VBox(tableView);

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView Örnek");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class VeriModeli {
        private final SimpleStringProperty sutun1;
        private final SimpleStringProperty sutun2;
        private final SimpleStringProperty sutun3;

        public VeriModeli(String sutun1, String sutun2, String sutun3) {
            this.sutun1 = new SimpleStringProperty(sutun1);
            this.sutun2 = new SimpleStringProperty(sutun2);
            this.sutun3 = new SimpleStringProperty(sutun3);
        }

        public SimpleStringProperty sutun1Property() {
            return sutun1;
        }

        public SimpleStringProperty sutun2Property() {
            return sutun2;
        }

        public SimpleStringProperty sutun3Property() {
            return sutun3;
        }

        public String getSutun1() {
            return sutun1.get();
        }

        public void setSutun1(String value) {
            sutun1.set(value);
        }

        public String getSutun2() {
            return sutun2.get();
        }

        public void setSutun2(String value) {
            sutun2.set(value);
        }

        public String getSutun3() {
            return sutun3.get();
        }

        public void setSutun3(String value) {
            sutun3.set(value);
        }
    }
}