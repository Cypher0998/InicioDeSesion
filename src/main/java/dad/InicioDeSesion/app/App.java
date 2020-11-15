package dad.InicioDeSesion.app;

import dad.InicioDeSesion.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	Controller controlador= new Controller();
	public void start(Stage primaryStage)throws Exception{
		Scene escena =new Scene(controlador.getView(),400,200);
		primaryStage.setScene(escena);
		primaryStage.setTitle("Iniciar Sesión");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
