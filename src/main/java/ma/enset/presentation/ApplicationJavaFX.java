package ma.enset.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class ApplicationJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("/ProductView.fxml"));
        Scene scene = new Scene(root,1000,600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion des produits");
        primaryStage.show();
    }
}
