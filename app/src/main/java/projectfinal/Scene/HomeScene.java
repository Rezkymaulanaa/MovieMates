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

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        
        // LAYOUT DI NAVBAR 
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
        navbar.setPrefWidth(900);


        // Kategori 1
        Label label1 = new Label("Box Office HITS");
        label1.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: Bold");
        GridPane kategori1 = new GridPane();
        kategori1.add(label1,0,1);
        kategori1.setAlignment(Pos.TOP_LEFT);
        kategori1.setPadding(new Insets(20, 20, 1, 20));
       
        // Button Kategori1
        GridPane poster = new GridPane();
        poster.setAlignment(Pos.TOP_LEFT);
        poster.setHgap(20);
        poster.setVgap(0);
        poster.setPadding(new Insets(10, 10, 0, 10));




    //SET ON ACTION KATEGORI 1 
        // Poster 1
        Image image1 = new Image("D:/IMG Poster FILM/Poster GOTG.jpg");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(175);
        imageView1.setFitWidth(125);

        Button buttonPoster1 = new Button();
        buttonPoster1.setGraphic(imageView1);
        buttonPoster1.setMaxHeight(200);
        buttonPoster1.setMaxWidth(200);
        buttonPoster1.setStyle("-fx-background-color: #000000;");
        buttonPoster1.setOnAction(V -> {
            GOTG gotg = new GOTG(stage);
            gotg.show();
        });
        poster.add(buttonPoster1, 0, 0);

        // Poster 2
        Image image2 = new Image("D:/IMG Poster FILM/Poster Endgame.jpg");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(175);
        imageView2.setFitWidth(125);

        Button buttonPoster2 = new Button();
        buttonPoster2.setGraphic(imageView2);
        buttonPoster2.setMaxHeight(200);
        buttonPoster2.setMaxWidth(200);
        buttonPoster2.setStyle("-fx-background-color: #000000;");
        buttonPoster2.setOnAction(V -> {
            Endgame endgame = new Endgame(stage);
            endgame.show();
        });
        poster.add(buttonPoster2, 1, 0);

        // Poster 3
        Image image3 = new Image("D:/IMG Poster FILM/Poster Titanic.jpg");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(175);
        imageView3.setFitWidth(125);

        Button buttonPoster3 = new Button();
        buttonPoster3.setGraphic(imageView3);
        buttonPoster3.setMaxHeight(200);
        buttonPoster3.setMaxWidth(200);
        buttonPoster3.setStyle("-fx-background-color: #000000;");
        buttonPoster3.setOnAction(V -> {
            Titanic titanic = new Titanic(stage);
            titanic.show();
        });
        poster.add(buttonPoster3, 1, 0);

        // Poster 4
        Image image4 = new Image("D:/IMG Poster FILM/Poster The Walking Dead.jpg");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitHeight(175);
        imageView4.setFitWidth(125);

        Button buttonPoster4 = new Button();
        buttonPoster4.setGraphic(imageView4);
        buttonPoster4.setMaxHeight(200);
        buttonPoster4.setMaxWidth(200);
        buttonPoster4.setStyle("-fx-background-color: #000000;");
        buttonPoster4.setOnAction(V -> {
            TWD twd = new TWD(stage);
            twd.show();
        });
        poster.add(buttonPoster4, 1, 0);

        // Poster 5
        Image image5 = new Image("D:/IMG Poster FILM/Poster ToyStory4.jpg");
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitHeight(175);
        imageView5.setFitWidth(125);

        Button buttonPoster5 = new Button();
        buttonPoster5.setGraphic(imageView5);
        buttonPoster5.setMaxHeight(200);
        buttonPoster5.setMaxWidth(200);
        buttonPoster5.setStyle("-fx-background-color: #000000;");
        buttonPoster5.setOnAction(V -> {
            ToyStory toyStory = new ToyStory(stage);
            toyStory.show();
        });
        poster.add(buttonPoster5, 1, 0);

        // Poster 6
        Image image6 = new Image("D:/IMG Poster FILM/Poster Avatar.jpg");
        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitHeight(175);
        imageView6.setFitWidth(125);

        Button buttonPoster6 = new Button();
        buttonPoster6.setGraphic(imageView6);
        buttonPoster6.setMaxHeight(200);
        buttonPoster6.setMaxWidth(200);
        buttonPoster6.setStyle("-fx-background-color: #000000;");
        buttonPoster6.setOnAction(V -> {
            Avatar avatar = new Avatar(stage);
            avatar.show();
        });
        poster.add(buttonPoster6, 1, 0);
        
        // TAMPILAN LAYOUT KATEGORI 1
        HBox hBox2 = new HBox();
        hBox2.setSpacing(15);
        hBox2.setPadding(new Insets(20));
        hBox2.getChildren().addAll(buttonPoster1, buttonPoster2, buttonPoster3, buttonPoster4, buttonPoster5, buttonPoster6);




        // Kategori 2
        Label label2 = new Label("    Indonesian Hits");
        label2.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: Bold");
        GridPane kategori2 = new GridPane();
        kategori2.add(label2,0,1);
        kategori2.setAlignment(Pos.TOP_LEFT);
        kategori2.setPadding(new Insets(20, 20, 1, 20));

        // Button Kategori 2
        GridPane poster2 = new GridPane();
        poster2.setAlignment(Pos.TOP_LEFT);
        poster2.setHgap(20);
        poster2.setVgap(0);
        poster2.setPadding(new Insets(20, 0, 0, 20));

    //SET ON ACTION KATEGORI 2
        // Poster 1
        
        Image img1 = new Image("D:/IMG Poster FILM/Poster GOTG.jpg");
        ImageView imgView1 = new ImageView(img1);
        imgView1.setFitHeight(175);
        imgView1.setFitWidth(125);

        Button tombolPoster1 = new Button();
        tombolPoster1.setGraphic(imgView1);
        tombolPoster1.setMaxHeight(200);
        tombolPoster1.setMaxWidth(200);
        tombolPoster1.setStyle("-fx-background-color: #000000;");
        tombolPoster1.setOnAction(V -> {
            GOTG gotg = new GOTG(stage);
            gotg.show();
        });
        poster.add(tombolPoster1, 0, 0);

        // Poster 2
        Image img2 = new Image("D:/IMG Poster FILM/Poster Endgame.jpg");
        ImageView imgView2 = new ImageView(img2);
        imgView2.setFitHeight(175);
        imgView2.setFitWidth(125);

        Button tombolPoster2 = new Button();
        tombolPoster2.setGraphic(imgView2);
        tombolPoster2.setMaxHeight(200);
        tombolPoster2.setMaxWidth(200);
        tombolPoster2.setStyle("-fx-background-color: #000000;");
        tombolPoster2.setOnAction(V -> {
            Endgame endgame = new Endgame(stage);
            endgame.show();
        });
        poster.add(tombolPoster2, 1, 0);

        // Poster 3
        Image img3 = new Image("D:/IMG Poster FILM/Poster Titanic.jpg");
        ImageView imgView3 = new ImageView(img3);
        imgView3.setFitHeight(175);
        imgView3.setFitWidth(125);

        Button tombolPoster3 = new Button();
        tombolPoster3.setGraphic(imgView3);
        tombolPoster3.setMaxHeight(200);
        tombolPoster3.setMaxWidth(200);
        tombolPoster3.setStyle("-fx-background-color: #000000;");
        tombolPoster3.setOnAction(V -> {
            Titanic titanic = new Titanic(stage);
            titanic.show();
        });
        poster.add(tombolPoster3, 1, 0);

        // Poster 4
        Image img4 = new Image("D:/IMG Poster FILM/Poster The Walking Dead.jpg");
        ImageView imgView4 = new ImageView(img4);
        imgView4.setFitHeight(175);
        imgView4.setFitWidth(125);

        Button tombolPoster4 = new Button();
        tombolPoster4.setGraphic(imgView4);
        tombolPoster4.setMaxHeight(200);
        tombolPoster4.setMaxWidth(200);
        tombolPoster4.setStyle("-fx-background-color: #000000;");
        tombolPoster4.setOnAction(V -> {
            TWD twd = new TWD(stage);
            twd.show();
        });
        poster.add(tombolPoster4, 1, 0);

        // Poster 5
        Image img5 = new Image("D:/IMG Poster FILM/Poster ToyStory4.jpg");
        ImageView imgView5 = new ImageView(img5);
        imgView5.setFitHeight(175);
        imgView5.setFitWidth(125);

        Button tombolPoster5 = new Button();
        tombolPoster5.setGraphic(imgView5);
        tombolPoster5.setMaxHeight(200);
        tombolPoster5.setMaxWidth(200);
        tombolPoster5.setStyle("-fx-background-color: #000000;");
        tombolPoster5.setOnAction(V -> {
            ToyStory toyStory = new ToyStory(stage);
            toyStory.show();
        });
        poster.add(tombolPoster5, 1, 0);

        // Poster 6
        Image img6 = new Image("D:/IMG Poster FILM/Poster Avatar.jpg");
        ImageView imgView6 = new ImageView(img6);
        imgView6.setFitHeight(175);
        imgView6.setFitWidth(125);

        Button tombolPoster6 = new Button();
        tombolPoster6.setGraphic(imgView6);
        tombolPoster6.setMaxHeight(200);
        tombolPoster6.setMaxWidth(200);
        tombolPoster6.setStyle("-fx-background-color: #000000;");
        tombolPoster6.setOnAction(V -> {
            Avatar avatar = new Avatar(stage);
            avatar.show();
        });
        poster.add(tombolPoster6, 1, 0);

        // TAMPILAN LAYOUT KATEGORI 1
        HBox hBox3 = new HBox();
        hBox3.setSpacing(15);
        hBox3.setPadding(new Insets(20));
        hBox3.getChildren().addAll(tombolPoster1, tombolPoster2, tombolPoster3, tombolPoster4, tombolPoster5, tombolPoster6);


        // TAMPILAN SEMUA LAYOUT
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #101010");
        layout.getChildren().addAll(navbar, kategori1, hBox2, label2, hBox3);
        

        Scene scene = new Scene(layout , 960, 540);
        stage.setScene(scene);
        stage.show();

    }
}