package projectfinal;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import projectfinal.Scene.MainScene;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("MovieMates");
        stage.setResizable(false);
        Image imgIcon = new Image(getClass().getClassLoader().getResourceAsStream("images/logo.png"));
        stage.getIcons().add(imgIcon);

        MainScene mainsScene = new MainScene(stage);
        mainsScene.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
