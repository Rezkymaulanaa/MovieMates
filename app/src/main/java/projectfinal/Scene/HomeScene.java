package projectfinal.Scene;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Scene scene = new Scene(new VBox(), 600, 700);
        stage.setScene(scene);
        stage.show();

    }
}