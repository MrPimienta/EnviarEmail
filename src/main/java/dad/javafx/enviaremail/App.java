package dad.javafx.enviaremail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
	
	private Controller controller;
	
	public static void main(String[] ar) {
		launch(ar);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new Controller();
		Scene escena = new Scene(controller.getView());
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Enviar Email");
		primaryStage.getIcons().add(new Image("/imagenes/email_icon.png"));
		primaryStage.show();
	}

}
