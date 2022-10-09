module uk.jamesgarden.breaktime {
  requires javafx.controls;
  requires javafx.fxml;


  opens uk.jamesgarden.breaktime to javafx.fxml;
  exports uk.jamesgarden.breaktime;
}