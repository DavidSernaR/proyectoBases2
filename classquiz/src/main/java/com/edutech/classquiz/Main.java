package com.edutech.classquiz;

import com.edutech.classquiz.controladores.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		var ventanaPrincipal = new FXMLLoader(getClass().getResource("/Home.fxml"));
		var scene = new Scene(ventanaPrincipal.load());
		stage.setTitle("ClassQuizz");
		stage.setResizable(false);
		Image icon = new Image("/icon.png");
		stage.getIcons().add(icon);
		stage.setScene(scene);
		HomeController homeController = ventanaPrincipal.getController();
		homeController.setStage(stage);
		stage.show();
	}
}
