package projectfinal.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        
        // LAYOUT DI NAVBAR 
        Label labeljudul = new Label("C I N E ");
        labeljudul.setStyle("-fx-text-fill: #BD2424; -fx-font-size: 20px; -fx-font-family: GOTHAM; -fx-font-weight: bold;");
        Label labeljudul2 = new Label("M A T C H");
        labeljudul2.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 20px; -fx-font-family: GOTHAM; -fx-font-weight: bold;");

        HBox labelapp = new HBox();
        labelapp.setSpacing(0);
        labelapp.getChildren().addAll(labeljudul,labeljudul2);
        labelapp.setAlignment(Pos.TOP_LEFT);

        Button home = new Button("Home");
        home.setStyle("-fx-background-color: black; -fx-text-fill: #BD2424; -fx-font-weight: bold; -fx-font-size: 14px");
        home.setMaxWidth(200);
        home.setMaxHeight(50);


        Label bookmarks = new Label("Bookmarks");
        bookmarks.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
        bookmarks.setPadding(new Insets(5, 0, 0, 0));
        bookmarks.setOnMouseClicked(event -> {
            bookmarks.setStyle("-fx-background-color: #BD2424; -fx-padding: 10px;");
            System.out.println("ASSASA");
            Bookmark bookmarkScene = new Bookmark(stage);
            bookmarkScene.show();
        });
        bookmarks.setOnMouseEntered(event -> {
            bookmarks.setStyle("-fx-text-fill: #BD2424; -fx-font-weight: bold; -fx-font-size: 14px");
        });
        bookmarks.setOnMouseExited(event -> {
            bookmarks.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 14px");
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
        logoutBox.setPadding(new Insets(0, 0, 0, 460));

        HBox navbar = new HBox();
        navbar.setSpacing(30);
        navbar.setPadding(new Insets(20));
        navbar.getChildren().addAll(labelapp, home, bookmarks, logoutBox);
        navbar.setAlignment(Pos.TOP_LEFT);
        navbar.setStyle("-fx-background-color: black");
        navbar.setPrefWidth(900);


        // Kategori 1
        Label label1 = new Label("Box Office HITS");
        label1.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 20px; -fx-font-weight: Bold");
        GridPane kategori1 = new GridPane();
        kategori1.add(label1,0,1);
        kategori1.setAlignment(Pos.TOP_LEFT);
        kategori1.setPadding(new Insets(20, 20, 1, 20));

    //SET ON ACTION KATEGORI 1 
        // Poster 1
        Label labelGOTG = new Label("Guardians of The\nGalaxy");
        labelGOTG.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelGOTG.setPadding(new Insets(0, 0, 0, 5));
        
        Image image1 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_GOTG.jpg"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(225);
        imageView1.setFitWidth(150);
        imageView1.setOnMouseClicked(V -> {
            GOTG gotg = new GOTG(stage);
            gotg.show();
        });
        imageView1.setOnMouseEntered(enter -> {
            imageView1.setFitHeight(300);
            imageView1.setFitWidth(200);
            Rectangle rectangle = new Rectangle(200, 300);
            rectangle.setArcWidth(20);
            rectangle.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView1.setClip(rectangle);
        });
        imageView1.setOnMouseExited(enter -> {
            imageView1.setFitHeight(225);
            imageView1.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle = new Rectangle(150, 225);
            rectangle.setArcWidth(20);
            rectangle.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView1.setClip(rectangle);
        });

            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle = new Rectangle(150, 225);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView1.setClip(rectangle);

        VBox vBox1 = new VBox(10);
        vBox1.getChildren().addAll(imageView1,labelGOTG);

        // Poster 2
        Label labelEndgame = new Label("The Avenger:\nEndgame");
        labelEndgame.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelEndgame.setPadding(new Insets(0, 0, 0, 5));

        Image image2 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Endgame.jpg"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(225);
        imageView2.setFitWidth(150);
        imageView2.setOnMouseClicked(V -> {
            Endgame endgame = new Endgame(stage);
            endgame.show();
        });
        imageView2.setOnMouseEntered(enter -> {
            imageView2.setFitHeight(300);
            imageView2.setFitWidth(200);
            Rectangle rectangle2 = new Rectangle(200, 300);
            rectangle2.setArcWidth(20);
            rectangle2.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView2.setClip(rectangle2);
        });
        imageView2.setOnMouseExited(enter -> {
            imageView2.setFitHeight(225);
            imageView2.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle2 = new Rectangle(150, 225);
            rectangle2.setArcWidth(20);
            rectangle2.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView2.setClip(rectangle2);
            
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle2 = new Rectangle(150, 225);
        rectangle2.setArcWidth(20);
        rectangle2.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView2.setClip(rectangle2);

        VBox vBox2 = new VBox(10);
        vBox2.getChildren().addAll(imageView2,labelEndgame);

        // Poster 3
        Label labelTitanic = new Label("Titanic");
        labelTitanic.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelTitanic.setPadding(new Insets(0, 0, 0, 5));

        Image image3 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Titanic.jpg"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(225);
        imageView3.setFitWidth(150);
        imageView3.setOnMouseClicked(V -> {
            Titanic titanic = new Titanic(stage);
            titanic.show();
        });
        imageView3.setOnMouseEntered(enter -> {
            imageView3.setFitHeight(300);
            imageView3.setFitWidth(200);
            Rectangle rectangle3 = new Rectangle(200, 300);
            rectangle3.setArcWidth(20);
            rectangle3.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView3.setClip(rectangle3);
        });
        imageView3.setOnMouseExited(enter -> {
            imageView3.setFitHeight(225);
            imageView3.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle3 = new Rectangle(150, 225);
            rectangle3.setArcWidth(20);
            rectangle3.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView3.setClip(rectangle3);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle3 = new Rectangle(150, 225);
        rectangle3.setArcWidth(20);
        rectangle3.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView3.setClip(rectangle3);

        VBox vBox3 = new VBox(10);
        vBox3.getChildren().addAll(imageView3,labelTitanic);


        // Poster 4
        Label labelTWD = new Label("The Walking Dead");
        labelTWD.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelTWD.setPadding(new Insets(0, 0, 0, 5));

        Image image4 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_The_Walking_Dead.jpg"));
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitHeight(225);
        imageView4.setFitWidth(150);
        imageView4.setOnMouseClicked(V -> {
            TWD twd = new TWD(stage);
            twd.show();
        });
        imageView4.setOnMouseEntered(enter -> {
            imageView4.setFitHeight(300);
            imageView4.setFitWidth(200);
            Rectangle rectangle4 = new Rectangle(200, 300);
            rectangle4.setArcWidth(20);
            rectangle4.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView4.setClip(rectangle4);
        });
        imageView4.setOnMouseExited(enter -> {
            imageView4.setFitHeight(225);
            imageView4.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle4 = new Rectangle(150, 225);
            rectangle4.setArcWidth(20);
            rectangle4.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView4.setClip(rectangle4);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle4 = new Rectangle(150, 225);
        rectangle4.setArcWidth(20);
        rectangle4.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView4.setClip(rectangle4);

        VBox vBox4 = new VBox(10);
        vBox4.getChildren().addAll(imageView4,labelTWD);

        // Poster 5
        Label labelToystory = new Label("Toy Story 4");
        labelToystory.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelToystory.setPadding(new Insets(0, 0, 0, 5));

        Image image5 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_ToyStory4.jpg"));
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitHeight(225);
        imageView5.setFitWidth(150);
        imageView5.setOnMouseClicked(V -> {
            ToyStory toyStory = new ToyStory(stage);
            toyStory.show();
        });
        imageView5.setOnMouseEntered(enter -> {
            imageView5.setFitHeight(300);
            imageView5.setFitWidth(200);
            Rectangle rectangle5 = new Rectangle(200, 300);
            rectangle5.setArcWidth(20);
            rectangle5.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView5.setClip(rectangle5);
        });
        imageView5.setOnMouseExited(enter -> {
            imageView5.setFitHeight(225);
            imageView5.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle5 = new Rectangle(150, 225);
            rectangle5.setArcWidth(20);
            rectangle5.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView5.setClip(rectangle5);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle5 = new Rectangle(150, 225);
        rectangle5.setArcWidth(20);
        rectangle5.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView5.setClip(rectangle5);

        VBox vBox5 = new VBox(10);
        vBox5.getChildren().addAll(imageView5,labelToystory);

        // Poster 6
        Label labelAvatar = new Label("Avatar");
        labelAvatar.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelAvatar.setPadding(new Insets(0, 0, 0, 5));

        Image image6 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Avatar.jpg"));
        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitHeight(225);
        imageView6.setFitWidth(150);
        imageView6.setOnMouseClicked(V -> {
            Avatar avatar = new Avatar(stage);
            avatar.show();
        });
        imageView6.setOnMouseEntered(enter -> {
            imageView6.setFitHeight(300);
            imageView6.setFitWidth(200);
            Rectangle rectangle6 = new Rectangle(200, 300);
            rectangle6.setArcWidth(20);
            rectangle6.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView6.setClip(rectangle6);
        });
        imageView6.setOnMouseExited(enter -> {
            imageView6.setFitHeight(225);
            imageView6.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle6 = new Rectangle(150, 225);
            rectangle6.setArcWidth(20);
            rectangle6.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView6.setClip(rectangle6);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle6 = new Rectangle(150, 225);
        rectangle6.setArcWidth(20);
        rectangle6.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView6.setClip(rectangle6);
        VBox vBox6 = new VBox(10);
        vBox6.getChildren().addAll(imageView6,labelAvatar);

        // Poster 7
        Label labelLionking = new Label("The Lion King");
        labelLionking.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelLionking.setPadding(new Insets(0, 0, 0, 5));

        Image image7 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Lion_King.jpg"));
        ImageView imageView7 = new ImageView(image7);
        imageView7.setFitHeight(225);
        imageView7.setFitWidth(150);
        imageView7.setOnMouseClicked(V -> {
            Lionking lionking = new Lionking(stage);
            lionking.show();
        });
        imageView7.setOnMouseEntered(enter -> {
            imageView7.setFitHeight(300);
            imageView7.setFitWidth(200);
            Rectangle rectangle7 = new Rectangle(200, 300);
            rectangle7.setArcWidth(20);
            rectangle7.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView7.setClip(rectangle7);
        });
        imageView7.setOnMouseExited(enter -> {
            imageView7.setFitHeight(225);
            imageView7.setFitWidth(150);
                // Membuat rectangle dengan efek melengkung
            Rectangle rectangle7 = new Rectangle(150, 225);
            rectangle7.setArcWidth(20);
            rectangle7.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imageView7.setClip(rectangle7);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rectangle7 = new Rectangle(150, 225);
        rectangle7.setArcWidth(20);
        rectangle7.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imageView7.setClip(rectangle7);
        VBox vBox7 = new VBox(10);
        vBox7.getChildren().addAll(imageView7,labelLionking);

        // TAMPILAN LAYOUT KATEGORI 1
        HBox hBox2 = new HBox();
        hBox2.setSpacing(15);
        hBox2.setStyle("-fx-background-color: #101010");

        hBox2.setPadding(new Insets(20));
        hBox2.getChildren().addAll(vBox1, vBox2, vBox3, vBox4, vBox5, vBox6, vBox7);

        ScrollPane scroll1 = new ScrollPane(hBox2);
        scroll1.setStyle("-fx-background-color: #101010");
        scroll1.setBackground(null);
        scroll1.setMinHeight(315);
        scroll1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll1.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);  



        // Kategori 2
        Label label2 = new Label("Indonesian HITS");
        label2.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 20px; -fx-font-weight: Bold");
        GridPane kategori2 = new GridPane();
        kategori2.add(label2,0,1);
        kategori2.setAlignment(Pos.TOP_LEFT);
        kategori2.setPadding(new Insets(10, 20, 1, 20));

    //SET ON ACTION KATEGORI 2
        // Poster 1
        Label labelAadc = new Label("Ada Apa Dengan Cinta");
        labelAadc.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelAadc.setPadding(new Insets(0, 0, 0, 5));

        Image img1 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Ada_Apa_Dengan_Cinta.jpg"));
        ImageView imgView1 = new ImageView(img1);
        imgView1.setFitHeight(150);
        imgView1.setFitWidth(225);
        imgView1.setOnMouseClicked(V -> {
            Aadc aadc = new Aadc(stage);
            aadc.show();
        });
        imgView1.setOnMouseEntered(enter -> {
            imgView1.setFitHeight(175);
            imgView1.setFitWidth(300);
            Rectangle rect1 = new Rectangle(300, 175);
            rect1.setArcWidth(20);
            rect1.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView1.setClip(rect1);
        });
        imgView1.setOnMouseExited(enter -> {
            imgView1.setFitHeight(150);
            imgView1.setFitWidth(225);
                // Membuat rectangle dengan efek melengkung
            Rectangle rect1 = new Rectangle(225, 150);
            rect1.setArcWidth(20);
            rect1.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView1.setClip(rect1);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rect1 = new Rectangle(225, 150);
        rect1.setArcWidth(20);
        rect1.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imgView1.setClip(rect1);

        VBox vBox8 = new VBox(10);
        vBox8.getChildren().addAll(imgView1,labelAadc);

        // Poster 2
        Label labelHabibie = new Label("Habibie & Ainun 3");
        labelHabibie.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelHabibie.setPadding(new Insets(0, 0, 0, 5));

        Image img2 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Habibie_Ainun_3.jpg"));
        ImageView imgView2 = new ImageView(img2);
        imgView2.setFitHeight(150);
        imgView2.setFitWidth(225);
        imgView2.setOnMouseClicked(V -> {
            HabibiAinun habibiAinun = new HabibiAinun(stage);
            habibiAinun.show();
        });
        imgView2.setOnMouseEntered(enter -> {
            imgView2.setFitHeight(175);
            imgView2.setFitWidth(300);
            Rectangle rect2 = new Rectangle(300, 175);
            rect2.setArcWidth(20);
            rect2.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView2.setClip(rect2);
        });
        imgView2.setOnMouseExited(enter -> {
            imgView2.setFitHeight(150);
            imgView2.setFitWidth(225);
                // Membuat rectangle dengan efek melengkung
            Rectangle rect2 = new Rectangle(225, 150);
            rect2.setArcWidth(20);
            rect2.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView2.setClip(rect2);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rect2 = new Rectangle(225, 150);
        rect2.setArcWidth(20);
        rect2.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imgView2.setClip(rect2);

        VBox vBox9 = new VBox(10);
        vBox9.getChildren().addAll(imgView2,labelHabibie);

        // Poster 3
        Label labelKkr = new Label("Kukira Kau Rumah");
        labelKkr.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelKkr.setPadding(new Insets(0, 0, 0, 5));

        Image img3 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Kukira_kau_Rumah.jpg"));
        ImageView imgView3 = new ImageView(img3);
        imgView3.setFitHeight(150);
        imgView3.setFitWidth(225);
        imgView3.setOnMouseClicked(V -> {
            KukiraKauRumah kukiraKauRumah = new KukiraKauRumah(stage);
            kukiraKauRumah.show();
        });
        imgView3.setOnMouseEntered(enter -> {
            imgView3.setFitHeight(175);
            imgView3.setFitWidth(300);
            Rectangle rect3 = new Rectangle(300, 175);
            rect3.setArcWidth(20);
            rect3.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView3.setClip(rect3);
        });
        imgView3.setOnMouseExited(enter -> {
            imgView3.setFitHeight(150);
            imgView3.setFitWidth(225);
                // Membuat rectangle dengan efek melengkung
            Rectangle rect3 = new Rectangle(225, 150);
            rect3.setArcWidth(20);
            rect3.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView3.setClip(rect3);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rect3 = new Rectangle(225, 150);
        rect3.setArcWidth(20);
        rect3.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imgView3.setClip(rect3);

        VBox vBox10 = new VBox(10);
        vBox10.getChildren().addAll(imgView3,labelKkr);

        // Poster 4
        Label label5cm = new Label("5 Cm");
        label5cm.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        label5cm.setPadding(new Insets(0, 0, 0, 5));

        Image img4 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_5Cm.jpg"));
        ImageView imgView4 = new ImageView(img4);
        imgView4.setFitHeight(150);
        imgView4.setFitWidth(225);
        imgView4.setOnMouseClicked(V -> {
            LimaCm limaCm = new LimaCm(stage);
            limaCm.show();
        });
        imgView4.setOnMouseEntered(enter -> {
            imgView4.setFitHeight(175);
            imgView4.setFitWidth(300);
            Rectangle rect4 = new Rectangle(300, 175);
            rect4.setArcWidth(20);
            rect4.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView4.setClip(rect4);
        });
        imgView4.setOnMouseExited(enter -> {
            imgView4.setFitHeight(150);
            imgView4.setFitWidth(225);
                // Membuat rectangle dengan efek melengkung
            Rectangle rect4 = new Rectangle(225, 150);
            rect4.setArcWidth(20);
            rect4.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView4.setClip(rect4);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rect4 = new Rectangle(225, 150);
        rect4.setArcWidth(20);
        rect4.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imgView4.setClip(rect4);

        VBox vBox11 = new VBox(10);
        vBox11.getChildren().addAll(imgView4,label5cm);

        // Poster 5
        Label labelPengabdi = new Label("Pengabdi Setan");
        labelPengabdi.setStyle("-fx-text-fill: #D4D4D4; -fx-font-weight: Bold; -fx-font-size: 13px");
        labelPengabdi.setPadding(new Insets(0, 0, 0, 5));

        Image img5 = new Image(getClass().getClassLoader().getResourceAsStream("images/Poster_Pengabdi_Setan.jpg"));
        ImageView imgView5 = new ImageView(img5);
        imgView5.setFitHeight(150);
        imgView5.setFitWidth(225);
        imgView5.setOnMouseClicked(V -> {
            PengabdiSetan pengabdiSetan = new PengabdiSetan(stage);
            pengabdiSetan.show();
        });
        imgView5.setOnMouseEntered(enter -> {
            imgView5.setFitHeight(175);
            imgView5.setFitWidth(300);
            Rectangle rect5 = new Rectangle(300, 175);
            rect5.setArcWidth(20);
            rect5.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView5.setClip(rect5);
        });
        imgView5.setOnMouseExited(enter -> {
            imgView5.setFitHeight(150);
            imgView5.setFitWidth(225);
                // Membuat rectangle dengan efek melengkung
            Rectangle rect5 = new Rectangle(225, 150);
            rect5.setArcWidth(20);
            rect5.setArcHeight(20);
                // Mengatur efek melengkung pada ImageView
            imgView5.setClip(rect5);
        });
            // Membuat rectangle dengan efek melengkung
        Rectangle rect5 = new Rectangle(225, 150);
        rect5.setArcWidth(20);
        rect5.setArcHeight(20);
            // Mengatur efek melengkung pada ImageView
        imgView5.setClip(rect5);

        VBox vBox12 = new VBox(10);
        vBox12.getChildren().addAll(imgView5,labelPengabdi);


        // TAMPILAN LAYOUT KATEGORI 2
        HBox hBox3 = new HBox();
        hBox3.setSpacing(10);
        hBox3.setStyle("-fx-background-color: #101010");
        hBox3.setPadding(new Insets(20));
        hBox3.getChildren().addAll(vBox8, vBox9, vBox10, vBox11, vBox12);

        ScrollPane scroll2 = new ScrollPane(hBox3);
        scroll2.setStyle("-fx-background-color: #101010");
        scroll2.setBackground(null);
        scroll2.setMinHeight(220);
        scroll2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll2.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 

        // TAMPILAN SEMUA LAYOUT
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #101010");
        layout.getChildren().addAll(navbar, kategori1, scroll1, kategori2, scroll2);

        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true); 
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);  

        Scene scene = new Scene(scrollPane , 960, 540);
        stage.setScene(scene);
        stage.show();

    }
}