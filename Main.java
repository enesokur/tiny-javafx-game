package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	Stage stage = new Stage();
	Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Level1 level1 = new Level1();
	}
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
	
	public Scene getScene() {
		return scene;
	}
	public Stage getStage() {
		return stage;
	}
}
