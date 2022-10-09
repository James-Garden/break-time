package uk.jamesgarden.breaktime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BreakTimeApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(BreakTimeApplication.class.getResource("break-time.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 300, 200);
    stage.setTitle("BreakTime");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}