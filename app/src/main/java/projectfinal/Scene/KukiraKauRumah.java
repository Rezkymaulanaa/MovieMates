package projectfinal.Scene;

import java.net.URI;
import java.awt.Desktop;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KukiraKauRumah extends NotifBookmark{
    private Stage stage;

    public KukiraKauRumah(Stage stage){
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

        Label homeLabel = new Label("Home");
        homeLabel.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        homeLabel.setPadding(new Insets(5, 0, 0, 0));
        homeLabel.setOnMouseClicked(event -> {
            homeLabel.setStyle("-fx-background-color: #BD2424; -fx-padding: 10px;");
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });
        homeLabel.setOnMouseEntered(event -> {
            homeLabel.setStyle("-fx-text-fill: #BD2424; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        homeLabel.setOnMouseExited(event -> {
            homeLabel.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        

        Label bookmarkLabel = new Label("Bookmarks");
        bookmarkLabel.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        bookmarkLabel.setPadding(new Insets(5, 0, 0, 0));
        bookmarkLabel.setOnMouseClicked(event -> {
            bookmarkLabel.setStyle("-fx-background-color: #BD2424; -fx-padding: 10px;");
            Bookmark bookmark = new Bookmark(stage);
            bookmark.show();
        });
        bookmarkLabel.setOnMouseEntered(event -> {
            bookmarkLabel.setStyle("-fx-text-fill: #BD2424; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        bookmarkLabel.setOnMouseExited(event -> {
            bookmarkLabel.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });

        Button logout = new Button("Logout");
        logout.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        logout.setMaxWidth(100);
        logout.setMaxHeight(0);
        logout.setOnMouseEntered(event -> {
            logout.setStyle("-fx-background-color: #8F0B1F; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        logout.setOnMouseExited(event -> {
            logout.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        logout.setOnAction(V -> {
            MainScene mainScene = new MainScene(stage);
            mainScene.show();
        });

        HBox logoutBox = new HBox();
        logoutBox.getChildren().add(logout);
        logoutBox.setAlignment(Pos. TOP_RIGHT);
        logoutBox.setPadding(new Insets(0, 0, 0, 450));

        HBox navbar = new HBox();
        navbar.setSpacing(40);
        navbar.setPadding(new Insets(20));
        navbar.getChildren().addAll(labelapp, homeLabel, bookmarkLabel, logoutBox);
        navbar.setAlignment(Pos.TOP_LEFT);
        navbar.setStyle("-fx-background-color: black");
        navbar.setPrefWidth(900);


        // Sinopsis film
        String movieTitle = "Kukira Kau Rumah";
        String movieDetail = "2022 - 1h 30m - Indonesian | 13+";
        String movieSynopsis = "Niskala memang berbeda dengan gadis pada umumnya, pasalnya emosi yang dimilikinya memang tidak terkontrol. Itulah kenapa ia membutuhkan kehadiran kedua sahabat baiknya, yaitu Dinda dan Oktavianus yang selalu menemaninya. Keduanya selalu berusaha untuk menenangkan Niskala, jika gadis itu sudah mulai bereaksi dan meluapkan amarahnya. Tidak banyak orang yang tahu bahwa Niskala bukanlah seorang gadis yang kasar dan pemarah, tapi ia mengidap bipolar. Penyakit mental ini sudah menggerogoti hidup Niskala sejak gadis ini masih duduk dibangku SMA.";
        String movieGenre = "Drama | Romance";

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
        Image image2 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Kukira_kau_Rumah.jpg"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setTranslateX(-55);
        imageView2.setTranslateY(20);
        
        imageView2.setFitHeight(194);
        imageView2.setFitWidth(306);

        // Membuat rectangle dengan efek melengkung
        Rectangle rectangle = new Rectangle(306, 194);
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
        Button buttonback = new Button("B A C K");
        buttonback.setStyle("-fx-background-color: #F8F8F8; -fx-font-weight: bold");
        buttonback.setOnMouseEntered(event -> {
            buttonback.setStyle("-fx-background-color: #DBD5D6; -fx-font-weight: bold");
        });
        buttonback.setOnMouseExited(event -> {
            buttonback.setStyle("-fx-background-color: #F8F8F8; -fx-font-weight: bold");
        });
        buttonback.setMaxHeight(50);
        buttonback.setMaxWidth(120);
        buttonback.setOnAction(V -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(60, 0, 0 , 30));
        vBox.getChildren().add(buttonback);

        // Button Tonton
        Button buttontonton = new Button("Watch Trailer");
        buttontonton.setStyle("-fx-background-color: #F8F8F8; -fx-font-weight: bold");
        buttontonton.setOnMouseEntered(event -> {
            buttontonton.setStyle("-fx-background-color: #DBD5D6; -fx-font-weight: bold");
        });
        buttontonton.setOnMouseExited(event -> {
            buttontonton.setStyle("-fx-background-color: #F8F8F8; -fx-font-weight: bold");
        });
        buttontonton.setMaxHeight(50);
        buttontonton.setMaxWidth(120);
        buttontonton.setOnAction(e -> {
            try {
                String url = "https://youtu.be/yLIY-yaF9tE";

                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        labelnotif = new Label();
        labelnotif.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold;");
        labelnotif.setVisible(false);

        Button buttonbookmark = new Button("Bookmark");
        buttonbookmark.setStyle("-fx-background-color: #F8F8F8; -fx-font-weight: bold");
        buttonbookmark.setMaxHeight(50);
        buttonbookmark.setMaxWidth(120);
        buttonbookmark.setOnMouseEntered(event -> {
            buttonbookmark.getScene().setCursor(Cursor. HAND);
        });
        buttonbookmark.setOnMouseExited(event -> {
            buttonbookmark.getScene().setCursor(Cursor. DEFAULT);
        });
        if (Bookmark.ListBookmark.contains("images/Poster_Kukira_Kau_Rumah.jpg")){
            buttonbookmark.setStyle("-fx-background-color: #C2C2C2; -fx-font-weight: bold");
        }
        buttonbookmark.setOnAction(event -> {
            if (!Bookmark.ListBookmark.contains("images/Poster_Kukira_Kau_Rumah.jpg")){
            Bookmark.ListBookmark.add("images/Poster_Kukira_Kau_Rumah.jpg");
            buttonbookmark.setStyle("-fx-background-color: #C2C2C2; -fx-font-weight: bold");
            notifShow();}
            else{Bookmark.ListBookmark.remove("images/Poster_Kukira_Kau_Rumah.jpg");
            buttonbookmark.setStyle("-fx-background-color: #F8F8F8; -fx-font-weight: bold");
            notifRemove();
            }
        });

        VBox vBox2 = new VBox(10);
        vBox2.setPadding(new Insets(0, 0, 0 , 650));
        vBox2.getChildren().addAll(buttontonton, buttonbookmark, labelnotif);
  
        // Layout Semua Item
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #101010");
        layout.getChildren().addAll(navbar,gabungan,vBox2,vBox);

        Scene scene = new Scene(layout,960,540);
        stage.setScene(scene);
        stage.setTitle("CINEMATCH");
        stage.show();
    }

    @Override
    public void notifShow() {
        super.notifShow();
    }
}