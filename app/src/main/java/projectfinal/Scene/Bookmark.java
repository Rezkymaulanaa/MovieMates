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
        
        Label watchlist = new Label("Watch List");
        watchlist.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 20px; -fx-font-weight: Bold");
        HBox hWatchlist = new HBox();
        hWatchlist.setStyle("-fx-background-color: #101010");
        hWatchlist.getChildren().add(watchlist);
        hWatchlist.setAlignment(Pos. TOP_LEFT);
        hWatchlist.setPadding(new Insets(20,20, 0, 20));


        HBox hMovie = new HBox();
        hMovie.setStyle("-fx-background-color: #101010");
        hMovie.setAlignment(Pos. TOP_CENTER);
        hMovie.setSpacing(15);
        hMovie.setPadding((new Insets(20,20,20,40)));
        for (String string : ListBookmark) {
            hMovie.setStyle("-fx-background-color: #101010");
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

        ScrollPane scroll1 = new ScrollPane(hMovie);
        scroll1.setStyle("-fx-background-color: #101010");
        scroll1.setFitToHeight(true);
        scroll1.setFitToWidth(true);
        scroll1.setMinWidth(960);
        scroll1.setMaxWidth(960);
        scroll1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll1.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        
        // Layout Semua Item
        VBox layout = new VBox();
        layout.getChildren().addAll(navbar,hWatchlist, scroll1);
        layout.setStyle("-fx-background-color: #101010");

        Scene scene = new Scene(layout,960,540);
        stage.setScene(scene);
        stage.setTitle("CINEMATCH");
        stage.show();
        
    }
}