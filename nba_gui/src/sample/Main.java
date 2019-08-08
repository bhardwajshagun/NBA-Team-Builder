package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    try {

      Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primaryStage.setTitle("NBA Team Builder");
      primaryStage.setScene(new Scene(root, 1200, 750)); // this is our primary stage that the user will see and interact with
      primaryStage.show();

    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
