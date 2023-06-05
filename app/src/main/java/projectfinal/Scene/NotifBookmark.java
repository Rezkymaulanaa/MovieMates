package projectfinal.Scene;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;

public abstract class NotifBookmark {
    public Label labelnotif;

    public void notifShow(){
        labelnotif.setText("Film Ditambahkan Ke Bookmarks");
        labelnotif.setVisible(true);
        labelnotif.setAlignment(Pos.BOTTOM_CENTER);
        labelnotif.setPadding(new Insets(0, 0, 0, -35));
        // Membuat timeline untuk mengatur durasi notifikasi
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),event -> {
            labelnotif.setVisible(false);
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void notifRemove(){
        labelnotif.setText("Film telah Dihapus dari Bookmarks");
        labelnotif.setVisible(true);
        labelnotif.setAlignment(Pos.BOTTOM_CENTER);
        labelnotif.setPadding(new Insets(0, 0, 0, -40));
        // Membuat timeline untuk mengatur durasi notifikasi
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),event -> {
            labelnotif.setVisible(false);
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
