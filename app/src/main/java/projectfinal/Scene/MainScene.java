package projectfinal.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene {
    private Stage stage;

    public MainScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Label title = new Label("Hello MovieMates");
        Label name = new Label("Set your name");

        TextField inputName = new TextField();
        inputName.setMaxWidth(200);

        Button start = new Button("Start");
        start.setOnAction(action -> {
            HomeScene homeScene = new HomeScene();
            homeScene.show();
        });

        VBox apptitle = new VBox();
        apptitle.getChildren().add(title);
        apptitle.setAlignment(Pos.TOP_CENTER);

        VBox content = new VBox(name, inputName, start);
        content.setAlignment(Pos.CENTER);
        content.setSpacing(20);

        VBox root = new VBox();
        root.getChildren().addAll(apptitle, content);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        VBox.setMargin(content, new Insets(150, 0, 180, 0));

        Scene scene = new Scene(root, 600, 700);
        stage.setScene(scene);
        stage.show();
    }
}