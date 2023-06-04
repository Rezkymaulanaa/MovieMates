package projectfinal.Scene;





import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Bookmark {
    private Stage stage;
    public static ObservableList<String> ListBookmark = FXCollections.observableArrayList();
    

    public Bookmark(Stage stage){
        this.stage = stage;
    }

    public void show(){
        System.out.println(ListBookmark);

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
        bookmarkLabel.setStyle("-fx-text-fill: #BD2424; -fx-font-weight: bold; -fx-font-size: 14px");
        bookmarkLabel.setPadding(new Insets(5, 0, 0, 0));

        HBox navbar = new HBox();
        navbar.setSpacing(40);
        navbar.setPadding(new Insets(20));
        navbar.getChildren().addAll(labelapp, homeLabel, bookmarkLabel);
        navbar.setAlignment(Pos.TOP_LEFT);
        navbar.setStyle("-fx-background-color: black");
        navbar.setPrefWidth(900);

        HBox hMovie = new HBox();
        hMovie.setPrefHeight(540);
        hMovie.setStyle("-fx-background-color: #101010");
        hMovie.setAlignment(Pos. TOP_LEFT);
            hMovie.setSpacing(20);
            hMovie.setPadding((new Insets(50, 0, 0, 20)));
        for (String string : ListBookmark) {
            Image img1 = new Image(getClass().getClassLoader().getResourceAsStream(string));
            ImageView imgView1 = new ImageView(img1);
            imgView1.setFitHeight(225);
            imgView1.setFitWidth(150);
            imgView1.setOnMouseEntered(enter -> {
                imgView1.setFitHeight(300);
                imgView1.setFitWidth(200);
                Rectangle rect1 = new Rectangle(200, 300);
                rect1.setArcWidth(20);
                rect1.setArcHeight(20);
                    // Mengatur efek melengkung pada ImageView
                imgView1.setClip(rect1);
            });
            imgView1.setOnMouseExited(enter -> {
                imgView1.setFitHeight(225);
                imgView1.setFitWidth(150);
                    // Membuat rectangle dengan efek melengkung
                Rectangle rect1 = new Rectangle(150, 225);
                rect1.setArcWidth(20);
                rect1.setArcHeight(20);
                    // Mengatur efek melengkung pada ImageView
                imgView1.setClip(rect1);
            });
                // Membuat rectangle dengan efek melengkung
            Rectangle rect1 = new Rectangle(150, 225);
            rect1.setArcWidth(20);
            rect1.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView1.setClip(rect1); 
            hMovie.getChildren().add(imgView1);
        }

        
        // Layout Semua Item
        VBox layout = new VBox();
        layout.getChildren().addAll(navbar,hMovie);
        layout.setStyle("-fx-background-color: #101010");

        
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true); 
        scrollPane.setStyle("-fx-background-color: #101010");
        scrollPane.setMinHeight(540);
        scrollPane.setBackground(null);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollPane,960,540);
        stage.setScene(scene);
        stage.setTitle("CINEMATCH");
        stage.show();
        
    }
}