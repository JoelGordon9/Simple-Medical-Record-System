package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/gordon/joel/views/mainPage.fxml"));
			window.setTitle("Patient Records");
			window.setScene(new Scene(root, 400, 400));
			window.show();
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getWindow() {
		return window;
	}
}

/*
Use this to run code before you close. That is if you want.

window.setOnCloseRequest(e -> closeDisProgram());

private void closeDisProgram(){
	do stuff here
	window.close();
}
*/