module uk.epsilondynamics.breaktime {
  requires javafx.controls;
  requires javafx.fxml;


  opens uk.epsilondynamics.breaktime to javafx.fxml;
  exports uk.epsilondynamics.breaktime;
}