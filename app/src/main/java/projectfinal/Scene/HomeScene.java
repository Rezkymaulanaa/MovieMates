package projectfinal.Scene;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public void show() {
        Scene scene = new Scene(new VBox(), 450, 500);
        stage.setScene(scene);
    }
}