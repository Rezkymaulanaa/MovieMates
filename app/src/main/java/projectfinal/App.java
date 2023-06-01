package projectfinal;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import projectfinal.Scene.MainScene;

public class App extends Application {
    @Override
    public void start(Stage PrimaryStage) {
        Stage stage;
        stage = PrimaryStage;
        stage.setTitle("MovieMates");
        stage.setResizable(false);
        Image icon = new Image("D:/logo.jpg");
        stage.getIcons().add(icon);

        MainScene mainsScene = new MainScene(stage);
        mainsScene.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
