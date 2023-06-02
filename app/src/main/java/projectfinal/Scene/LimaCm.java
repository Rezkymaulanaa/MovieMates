package projectfinal.Scene;


import java.net.URI;
import java.awt.Desktop;
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

public class LimaCm {
    private Stage stage;

    public LimaCm(Stage stage){
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
        String movieTitle = "5 CM";
        String movieDetail = "2012 - 2h 5m - Indonesian | 13+";
        String movieSynopsis = "Film dibuka dengan perkenalan para tokoh utama yang narasinya diceritakan oleh Zafran (Herjunot Ali), seorang pemuda super puitis tapi karirnya amblas tak karuan membuat Ibunya hipertensi. Sedangkan tokoh utama lainnya adalah Genta (Fedi Nuril), Arial (Denny Sumargo), Riani (Raline Shah) dan Ian (Igor Saykoji). Mereka berlima sudah menjadi sahabat selama 10 tahun dan tidak pernah melewatkan 1 kali weekend pun untuk tidak bertemu. Mereka selalu menghabiskan akhir pekan mereka bersama dan basecamp mereka adalah rumah mewah milik Arial yang selalu menyediakan apapun yang mereka butuhkan.";
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
        Image image2 = new Image("D:/IMG Poster Film/Poster 5Cm.jpg");
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
        Button buttonback = new Button("<-- Back");
        buttonback.setMaxHeight(50);
        buttonback.setMaxWidth(120);
        buttonback.setOnAction(V -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(105, 0, 0 , 30));
        vBox.getChildren().add(buttonback);

        // Button Tonton
        Button buttontonton = new Button("Watch Trailer");
        buttontonton.setMaxHeight(50);
        buttontonton.setMaxWidth(120);
        buttontonton.setOnAction(e -> {
            try {
                String url = "https://youtu.be/aL-wI0xZJ6M";

                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(0, 0, 0 , 650));
        vBox2.getChildren().add(buttontonton);
  
        // Layout Semua Item
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #101010");
        layout.getChildren().addAll(navbar,gabungan,vBox2,vBox);

        Scene scene = new Scene(layout,960,540);
        stage.setScene(scene);
        stage.setTitle("CINEMATCH");
        stage.show();
    }
}