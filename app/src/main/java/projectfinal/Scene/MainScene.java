package projectfinal.Scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene {
    private Stage stage;

    public MainScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane img = new StackPane();
        
        Label title = new Label("Hello MovieMates");
        Label name = new Label("Set your name");

        Button start = new Button("Start");
        start.setOnAction(action -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });


        Image backImage = new Image(getClass().getClassLoader().getResourceAsStream("images/Background_Mainscene.jpg"));
        ImageView iView = new ImageView(backImage);
        img.getChildren().add(iView);

        HBox apptitle = new HBox();
        apptitle.getChildren().add(title);
        apptitle.setAlignment(Pos.TOP_CENTER);


        VBox content = new VBox(name, start);
        content.setAlignment(Pos.CENTER);
        content.setSpacing(20);

        VBox layout = new VBox();
        layout.getChildren().addAll(apptitle, content);
        layout.setAlignment(Pos.CENTER_LEFT);
        img.getChildren().addAll(layout);

        Scene scene = new Scene(img, 960, 540);
        stage.setScene(scene);
        stage.show();
    }
}