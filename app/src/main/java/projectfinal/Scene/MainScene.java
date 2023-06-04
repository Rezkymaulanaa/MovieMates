package projectfinal.Scene;

import javafx.geometry.Insets;
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

public class MainScene extends Startbutton {
    private Stage stage;

    public MainScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane img = new StackPane();
        
        // LAYOUT DI NAVBAR 
        Label labeljudul = new Label("C I N E ");
        labeljudul.setStyle("-fx-text-fill: #BD2424; -fx-font-size: 24px; -fx-font-family: GOTHAM; -fx-font-weight: bold");

        Label labeljudul2 = new Label("M A T C H");
        labeljudul2.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 24px; -fx-font-family: GOTHAM; -fx-font-weight: bold");

        HBox labelapp = new HBox();
        labelapp.setSpacing(0);
        labelapp.getChildren().addAll(labeljudul,labeljudul2);
        labelapp.setAlignment(Pos.TOP_LEFT);
        labelapp.setPadding(new Insets(20, 0, 0, 30));

        // ini adalah Tombol untuk Masuk
        Button signin = new Button("Sign in");
        signin.setMaxHeight(0);
        signin.setMaxWidth(100);
        signin.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        signin.setOnMouseEntered(event -> {
            signin.setStyle("-fx-background-color: #8F0B1F; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        signin.setOnMouseExited(event -> {
            signin.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        signin.setOnAction(v -> {
            Login login = new Login(stage);
            login.show();
        });

        HBox signinBox = new HBox();
        signinBox.getChildren().add(signin);
        signinBox.setAlignment(Pos. TOP_RIGHT);
        signinBox.setPadding(new Insets(-35, 20, 0, 0));

        Label title = new Label("See what's next.");
        title.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 40px; -fx-font-family: Arial; -fx-font-weight: bold;");
        Label title2 = new Label("WATCH ANYWHERE, CANCEL ANYTIME.");
        title2.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 15px; -fx-font-family: Times new roman");

        Button start = new Button();
        start.setText(buttonstart());
        start.setMaxWidth(200);
        start.setMaxHeight(50);
        start.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        start.setOnMouseEntered(event -> {
            start.setStyle("-fx-background-color: #8F0B1F; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        start.setOnMouseExited(event -> {
            start.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        start.setOnAction(action -> {
            Login login = new Login(stage);
            login.show();
        });


        Image backImage = new Image(getClass().getClassLoader().getResourceAsStream("images/Background_Mainscene.jpg"));
        ImageView iView = new ImageView(backImage);
        img.getChildren().add(iView);


        VBox content = new VBox(title,title2, start);
        content.setAlignment(Pos.CENTER_LEFT);
        content.setSpacing(10);
        content.setPadding(new Insets(145,20, 0, 40));

        VBox layout = new VBox();
        layout.getChildren().addAll(labelapp, signinBox, content);
        img.getChildren().addAll(layout);

        Scene scene = new Scene(img, 960, 540);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    String buttonstart() {
        String a = "S T A R T";
        return a;
    }
}