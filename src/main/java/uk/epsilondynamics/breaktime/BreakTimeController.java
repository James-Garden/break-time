package uk.epsilondynamics.breaktime;

import java.util.Objects;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class BreakTimeController {
  private static final Alert BREAK_TIME_ALERT = BreakTimeAlert.buildInfoMessage(
      "BreakTime Reminder",
      "Time to take a break and rest your eyes."
  );

  private static final Alert INVALID_INPUT_ALERT = BreakTimeAlert.buildErrorMessage(
      "BreakTime Error",
      "Input time must be a number"
  );

  @FXML
  private Label welcomeText;

  @FXML
  private TextField timeDurationInput;

  @FXML
  private Button startTimerButton;

  @FXML
  private Button stopTimerButton;

  private Double timerDuration;

  private Timeline workTimer;

  @FXML
  protected void initialize() {
    timerDuration = 20.0;
    workTimer = BreakTimeTimer.build(
        Duration.minutes(timerDuration),
        welcomeText,
        "Work time remaining"
    );
  }

  @FXML
  protected void startTimer() {
    startTimerButton.setDisable(true);
    double inputTime;
    try {
      inputTime = Double.parseDouble(timeDurationInput.getText());
    } catch (NumberFormatException e) {
      handleInvalidInput();
      return;
    }
    if (!Objects.equals(timerDuration, inputTime)) {
      workTimer = BreakTimeTimer.build(
          Duration.minutes(inputTime),
          welcomeText,
          "Work time remaining"
      );
    }
    startTimerButton.setVisible(false);
    startTimerButton.setDisable(false);
    stopTimerButton.setVisible(true);
    workTimer.setOnFinished(event -> handleWorkTimerEnd());
    workTimer.play();
  }

  @FXML
  protected void stopTimer() {
    stopTimerButton.setVisible(false);
    startTimerButton.setVisible(true);

    workTimer.stop();
  }

  private void handleWorkTimerEnd() {
    Platform.runLater(() -> {
      BREAK_TIME_ALERT.showAndWait();

      workTimer.play();
    });
  }

  private void handleInvalidInput() {
    INVALID_INPUT_ALERT.showAndWait();
    startTimerButton.setDisable(false);
  }
}