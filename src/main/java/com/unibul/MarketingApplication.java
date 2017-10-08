package com.unibul;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MarketingApplication extends Application {
	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(MarketingApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/layouts/Main.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setMinWidth(360);
		primaryStage.setMinHeight(400);



		Image image = new Image("/images/icon.png");
		primaryStage.getIcons().add(image);

//        primaryStage.setMaxWidth(355);
		primaryStage.setTitle("Amazon Marketing Suite v1.0");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}


	public static void main(String[] args) {
		launch(MarketingApplication.class, args);
	}
}
