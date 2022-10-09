package uk.epsilondynamics.breaktime;

import javafx.scene.control.Alert;

public class BreakTimeAlert {

  public static Alert build(String alertHeaderText, String alertMessageText, Alert.AlertType alertType) {
    Alert alert = new Alert(alertType);
    alert.setHeaderText(alertHeaderText);
    alert.setContentText(alertMessageText);

    return alert;
  }

  public static Alert buildInfoMessage(String alertHeaderText, String alertMessageText) {
    return build(alertHeaderText, alertMessageText, Alert.AlertType.INFORMATION);
  }

  public static Alert buildErrorMessage(String alertHeaderText, String alertMessageText) {
    return build(alertHeaderText, alertMessageText, Alert.AlertType.ERROR);
  }
}
