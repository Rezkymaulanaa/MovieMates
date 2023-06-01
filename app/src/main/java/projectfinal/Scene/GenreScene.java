package projectfinal.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GenreScene {
    private Stage stage;
    private String nameValue;

    public GenreScene(Stage stage, String nameValue) {
        this.stage = stage;
        this.nameValue = nameValue;
    }

    public void show() {
        Button home = new Button("Home");
        Button genre = new Button("Genre");

        home.setOnAction(e -> {
            System.out.println("Home button clicked");
            HomeScene homeScene = new HomeScene(stage, nameValue);
            homeScene.show();
        });
        genre.setOnAction(e -> System.out.println("Genre button clicked"));

        HBox navbar = new HBox(home, genre);
        navbar.setSpacing(10);
        navbar.setAlignment(Pos.CENTER_LEFT);

        VBox content = new VBox(navbar);
        content.setAlignment(Pos.TOP_LEFT);
        content.setSpacing(10);
        content.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(content);

        Scene scene = new Scene(root, 600, 700);
        stage.setScene(scene);
        stage.show();
    }
}
