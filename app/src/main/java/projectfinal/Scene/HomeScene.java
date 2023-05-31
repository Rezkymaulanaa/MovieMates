package projectfinal.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Button home = new Button("Home");
        Button genre = new Button("Genre");

        home.setOnAction(e -> System.out.println("Home button clicked"));
        genre.setOnAction(e -> System.out.println("Genre button clicked"));
        
        HBox navbar = new HBox();
        navbar.setSpacing(10);
        navbar.setPadding(new Insets(10));
        navbar.getChildren().addAll(home, genre);
        navbar.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(navbar , 600, 700);
        stage.setScene(scene);
        stage.show();

    }
}