package uk.jamesgarden.breaktime;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class BreakTimeTimer {
  public static Timeline build(Duration time, Label node, String text) {
    Timeline timeline = new Timeline();
    timeline.setCycleCount(2);
    timeline.setAutoReverse(true);

    var timeElapsed = Duration.millis(0);
    while (timeElapsed.lessThan(time)) {
      timeElapsed = timeElapsed.add(Duration.millis(100));
      timeline.getKeyFrames().add(
          new KeyFrame(timeElapsed,
          new KeyValue(node.textProperty(),
              String.format("%s: %s", text, formatTimeRemaining(time, timeElapsed)))));
    }
    timeline.setCycleCount(1);
    return timeline;
  }

  private static String formatTimeRemaining(Duration time, Duration timeElapsed) {
    var timeRemaining = time.subtract(timeElapsed);
    var minutes = Math.floor(timeRemaining.toMinutes());
    if (minutes >= 1) {
      var seconds = timeRemaining.toSeconds() - (minutes * 60);
      return String.format("%.0f m %.2f s", minutes, seconds);
    }
    return String.format("%.2f s", timeRemaining.toSeconds());
  }
}
