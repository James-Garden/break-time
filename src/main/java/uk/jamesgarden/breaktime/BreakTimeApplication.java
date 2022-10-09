package uk.jamesgarden.breaktime;

import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BreakTimeApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(BreakTimeApplication.class.getResource("break-time.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 300, 200);
    stage.setTitle("BreakTime");
    stage.setScene(scene);
    stage.getIcons().add(new Image(
        Objects.requireNonNull(BreakTimeApplication.class.getResourceAsStream("icon.png"))));
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}