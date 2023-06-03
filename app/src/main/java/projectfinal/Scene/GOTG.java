package projectfinal.Scene;

import java.net.URI;
import java.time.Duration;
import java.awt.Desktop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
// import javafx.util.Duration;

public class GOTG {
    private Stage stage;

    public GOTG(Stage stage){
        this.stage = stage;
    }

    public void show(){
        // LAYOUT NAVBAR ATAS
        Label labeljudul = new Label("C I N E ");
        labeljudul.setStyle("-fx-text-fill: #BD2424; -fx-font-size: 20px; -fx-font-family: GOTHAM; -fx-font-weight: bold;");
        Label labeljudul2 = new Label("M A T C H");
        labeljudul2.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 20px; -fx-font-family: GOTHAM; -fx-font-weight: bold;");

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
        navbar.setSpacing(30);
        navbar.setPadding(new Insets(20));
        navbar.getChildren().addAll(labelapp, home, trending);
        navbar.setAlignment(Pos.TOP_LEFT);
        navbar.setStyle("-fx-background-color: black");
        navbar.setPrefWidth(900);


        // Sinopsis film
        String movieTitle = "Guardian Of The Galaxy";
        String movieDetail = "2014 - 2h | 13+";
        String movieSynopsis = "Brash space adventurer Peter Quill (Chris Pratt) finds himself the quarry of\nrelentless bounty hunters after he steals an orb coveted by Ronan,\na powerful villain. To evade Ronan, Quill is forced into an uneasy\ntruce with four disparate misfits: gun-toting Rocket Raccoon, treelike-humanoid\nGroot, enigmatic Gamora, and vengeance-driven Drax the Destroyer.                                                                                                                                                                                         ";
        String movieGenre = "SuperHero | Action | Dark Humour | Fantasy | Alien | Buddy";

        // Membuat komponen Label untuk judul film
        Label titleLabel = new Label(movieTitle);
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #D4D4D4");

        // Membuat komponen Label untuk detail film
        Label detaiLabel = new Label(movieDetail);
        detaiLabel.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #D4D4D4");
        
        // Membuat komponen Label untuk sinopsis film
        Label synopsisLabel = new Label(movieSynopsis);
        synopsisLabel.setWrapText(true);
        synopsisLabel.setStyle("-fx-text-fill: #D4D4D4");

        // Membuat komponen Label untuk genre film
        Label genreLabel = new Label(movieGenre);
        genreLabel.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #D4D4D4");
        
        
        // Membuat layout VBox sebagai root
        VBox root = new VBox(10);
        root.setPadding(new Insets(0, 0, 0, 40) );
        root.getChildren().addAll(titleLabel, detaiLabel, synopsisLabel, genreLabel);

        // POSTER 
        Image image2 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_GOTG.jpg"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setTranslateX(-75);
        imageView2.setTranslateY(30);
        
        imageView2.setFitHeight(275);
        imageView2.setFitWidth(200);

        // Membuat rectangle dengan efek melengkung
        Rectangle rectangle = new Rectangle(200, 275);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        // Mengatur efek melengkung pada ImageView
        imageView2.setClip(rectangle);

        // Menggabungkan Root dan Poster
        HBox gabungan = new HBox();
        gabungan.setSpacing(180);
        gabungan.setPadding(new Insets(30, 40, 0, 0));
        gabungan.getChildren().addAll(root,imageView2);

        // Button Kembali 
        Button buttonback = new Button("<-- Back");
        buttonback.setMaxHeight(50);
        buttonback.setMaxWidth(120);
        buttonback.setOnAction(V -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(-25, 0, 0 , 30));
        vBox.getChildren().add(buttonback);

        // Button Tonton
        Button buttontonton = new Button("Watch Trailer");
        buttontonton.setMaxHeight(50);
        buttontonton.setMaxWidth(120);
        buttontonton.setOnAction(e -> {
            try {
                String url = "https://youtu.be/d96cjJhvlMA";

                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        Label labelnotif = new Label();
        labelnotif.setStyle("-fx-background-color: #D4D4D4; -fx-text-fill: #D4D4D4");
        labelnotif.setVisible(false);

        Button buttonbookmark = new Button("Bookmark");
        buttonbookmark.setMaxHeight(50);
        buttonbookmark.setMaxWidth(120);
        buttonbookmark.setOnAction(event -> showNotif(labelnotif));

        VBox vBox2 = new VBox(10);
        vBox2.setPadding(new Insets(50, 0, 0 , 685));
        vBox2.getChildren().addAll(buttontonton, buttonbookmark,labelnotif);
  
        // Layout Semua Item
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #101010");
        layout.getChildren().addAll(navbar,gabungan,vBox2,vBox);

        Scene scene = new Scene(layout,960,540);
        stage.setScene(scene);
        stage.setTitle("CINEMATCH");
        stage.show();
    }


    public void showNotif(Label label){
        label.setText("Film Ditambahkan Ke Bookmark");
        label.setVisible(true);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(-45, 0, 0, -250));
        // Membuat timeline untuk mengatur durasi notifikasi
        // Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3)event -> {
        //     label.setVisible(false);
        // }));
        // timeline.setCycleCount(1);
        // timeline.play();
    }
}
