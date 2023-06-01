package projectfinal.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TWD {
    private Stage stage;

    public TWD(Stage stage){
        this.stage = stage;
    }

    public void show(){
        // LAYOUT NAVBAR ATAS
        Label labeljudul = new Label("CINE");
        labeljudul.setStyle("-fx-text-fill: #BD2424; -fx-font-size: 20px; -fx-font-family: GOTHAM; -fx-font-weight: bold;");
        Label labeljudul2 = new Label("MATCH");
        labeljudul2.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: GOTHAM; -fx-font-weight: bold;");

        HBox labelapp = new HBox();
        labelapp.setSpacing(0);
        labelapp.getChildren().addAll(labeljudul,labeljudul2);
        labelapp.setAlignment(Pos.TOP_LEFT);

        Button home = new Button("Home");
        home.setStyle("-fx-background-color: #101010; -fx-text-fill: white;");
        home.setOnAction(e -> System.out.println("Home button clicked"));
        Button trending = new Button("Trending");
        trending.setStyle("-fx-background-color: #101010; -fx-text-fill: white;");
        trending.setOnAction(e -> System.out.println("Genre button clicked"));

        HBox navbar = new HBox();
        navbar.setSpacing(20);
        navbar.setPadding(new Insets(20));
        navbar.getChildren().addAll(labelapp, home, trending);
        navbar.setAlignment(Pos.TOP_LEFT);
        navbar.setStyle("-fx-background-color: black");
        navbar.setPrefWidth(960);

        // Sinopsis film
        String movieTitle = "The Walking Dead";
        String movieSynopsis = "The Walking Dead, based on the comic book series written by Robert Kirkman and published by Image Comics, tells the story of the months and years that follow after a zombie apocalypse. It follows a group of survivors, led by police officer Rick Grimes, who travel in search of a safe and secure home. The comic goes on to explore the challenges of life in a world overrun by zombies who take a toll on the survivors.                                                                                                          ";
        String movieGenre = "Drama | Horror | Zombie Apocalypse | Thriller";        

        // Membuat komponen Label untuk judul film
        Label titleLabel = new Label(movieTitle);
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #D4D4D4");
        
        // Membuat komponen Label untuk sinopsis film
        Label synopsisLabel = new Label(movieSynopsis);
        synopsisLabel.setWrapText(true);
        synopsisLabel.setStyle("-fx-text-fill: #D4D4D4");

        // Membuat komponen Label untuk genre film
        Label genreLabel = new Label(movieGenre);
        genreLabel.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #D4D4D4");
        
        
        // Membuat layout VBox sebagai root
        VBox root = new VBox(10);
        root.setMaxWidth(400);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, synopsisLabel, genreLabel);

        // POSTER 
        Image image2 = new Image("D:/IMG Poster FILM/Poster The Walking Dead.jpg");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setTranslateX(-175);
        imageView2.setTranslateY(25);
        
        imageView2.setFitHeight(225);
        imageView2.setFitWidth(175);


        Button buttonback = new Button("<-- Back");
        buttonback.setOnAction(V -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });


  
        GridPane gridpane = new GridPane();
        gridpane.setHgap(3);
        gridpane.add(navbar,1,0);
        gridpane.add(root,1,1);
        gridpane.add(imageView2,2,1);
        gridpane.add(buttonback,1,9);
        gridpane.setStyle("-fx-background-color: #101010");

        Scene scene = new Scene(gridpane,960,540);
        stage.setScene(scene);
        stage.setTitle("The Avenger: Endgame");
        stage.show();
    }
}