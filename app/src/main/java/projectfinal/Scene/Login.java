package projectfinal.Scene;

import javafx.util.Duration;
import projectfinal.models.DataRegist;
import projectfinal.utils.Registdb;

import java.sql.SQLException;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Login {
    private Stage stage;
    private ObservableList<DataRegist>listUser;
    private Registdb registdb;

    public Login(Stage stage) {
        this.stage = stage;
        this.listUser = FXCollections.observableArrayList();
    }
    public void show(){
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

        Label labelsignin = new Label("Sign In");
        labelsignin.setStyle("-fx-font-size: 29px; -fx-font-weight: bold; -fx-text-fill: #EDEDED; -fx-font-family: Arial");
        VBox lblsignin = new VBox(labelsignin);
        lblsignin.setAlignment(Pos. CENTER);
        lblsignin.setPadding(new Insets(0, 160, 0, 0));

        
        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Username");
        tfUsername.setStyle("-fx-font-size: 15px; -fx-text-fill: #D4D4D4; -fx-background-color: #404040; -fx-font-family: Arial");
        tfUsername.setPrefSize(250, 45);
        tfUsername.setMaxHeight(45);
        tfUsername.setMaxWidth(250);
        tfUsername.setAlignment(Pos.CENTER_LEFT);
        tfUsername.setPadding(new Insets(0, 0, 0, 20));
        
        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");
        tfPassword.setStyle("-fx-font-size: 15px; -fx-text-fill: #D4D4D4; -fx-background-color: #404040; -fx-font-family: Arial");
        tfPassword.setPrefSize(250, 45);
        tfPassword.setMaxHeight(45);
        tfPassword.setMaxWidth(250);
        tfPassword.setAlignment(Pos.CENTER_LEFT);
        tfPassword.setPadding(new Insets(0, 0, 0, 20));
        
        VBox boxField = new VBox();
        boxField.getChildren().addAll(lblsignin, tfUsername,tfPassword);
        boxField.setAlignment(Pos.TOP_CENTER);
        boxField.setSpacing(20);
        boxField.setPadding(new Insets(75, 0, 0, 0));


        Label errorLabel = new Label();
        errorLabel.setVisible(false);
        errorLabel.setStyle("-fx-text-fill: #F4701F; -fx-font-size: 13px");


        Button loginButton = new Button("Sign In");
        loginButton.setMaxWidth(250);
        loginButton.setMaxHeight(45);
        loginButton.setPrefHeight(45);
        tfPassword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                navigateToOtherScene(); // Fungsi untuk melakukan navigasi ke scene lain
            }
        });
        // Penanganan peristiwa saat tombol Enter ditekan pada Button
        loginButton.setOnAction(event -> {
            navigateToOtherScene(); // Fungsi untuk melakukan navigasi ke scene lain
        });
        loginButton.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 15px");
        loginButton.setOnMouseEntered(event -> {
            loginButton.setStyle("-fx-background-color: #8F0B1F; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 15px");
        });
        loginButton.setOnMouseExited(event -> {
            loginButton.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 15px");
        });
        // Menambahkan event handler untuk tombol login
        loginButton.setOnAction(v -> {
            // mengambil teks dari teks dan password field
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            // kondisi kesalahan Apabila textfield kosong
            if (username.isEmpty() || password.isEmpty()) {
                errorLabel.setText("Username and Password is empty!");
                errorLabel.setVisible(true);

                // Membuat PauseTransition untuk mengubah visibilitas Label setelah 2 detik
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(event -> errorLabel.setVisible(false));
                pause.play();
            } else {
                //Mendapatkan list semua pengguna dari database
                registdb = new Registdb();
                try {
                    listUser.addAll(registdb.getAll());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // mengecek apakah dalam list sama dengan username dan password dalam listUser
                boolean confirm = false;
                for (DataRegist user : listUser) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        // Jika username dan password cocok, login berhasil
                        confirm = true;
                        break;
                    }
                }

                if (confirm) {
                    // Jika login berhasil, lanjut ke homePage
                    HomeScene hp = new HomeScene(stage);
                    hp.show();
                } else {
                    // Jika login gagal, tampilkan pesan kesalahan
                    errorLabel.setText("Please enter a valid Username or Password");
                    errorLabel.setVisible(true);

                    // Membuat PauseTransition untuk mengubah visibilitas Label setelah 2 detik
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(event -> errorLabel.setVisible(false));
                    pause.play();
                    tfUsername.clear();
                    tfPassword.clear();
                }
            }
        });
        VBox signinBox = new VBox(loginButton);
        signinBox.setAlignment(Pos. CENTER);
        signinBox.setPadding(new Insets(10, 0, 0, 0));

        VBox errorvBox = new VBox(errorLabel);
        errorvBox.setAlignment(Pos. CENTER);
        errorvBox.setPadding(new Insets(10, 0, 0, 0));
        
        Label newUser = new Label("New To Cinematch?");
        newUser.setStyle("-fx-text-fill: #696969 ; -fx-font-size: 14px; -fx-font-family: Arial");

        Label signup = new Label("Sign up now.");
        signup.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 14px; -fx-font-family: Arial");
        signup.setOnMouseEntered(event -> {
            signup.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 14px; -fx-underline: true");
        });
        signup.setOnMouseExited(event -> {
            signup.setStyle("-fx-text-fill: #D4D4D4; -fx-font-size: 14px; -fx-underline: false");
        });
        signup.setOnMouseClicked(v -> {
            Regist regist = new Regist(stage);
            regist.show();
        });

        HBox signupBox = new HBox();
        signupBox.getChildren().addAll(newUser, signup);
        signupBox.setAlignment(Pos. CENTER);
        signupBox.setPadding(new Insets(50, 40, 0, 0));

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #D4D4D4; -fx-text-fill: black; -fx-font-size: 12px; -fx-font-weight: bold; -fx-font-family: Arial");
        backButton.setPrefSize(80, 20);;
        backButton.setMaxHeight(20);
        backButton.setMaxWidth(80);
        backButton.setOnMouseEntered(event -> {
            backButton.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-size: 12px; -fx-font-weight: bold; -fx-font-family: Arial");
        });
        backButton.setOnMouseExited(event -> {
            backButton.setStyle("-fx-background-color: #D4D4D4; -fx-text-fill: black; -fx-font-size: 12px; -fx-font-weight: bold; -fx-font-family: Arial");
        });
        backButton.setOnAction(V -> {
            MainScene mainScene = new MainScene(stage);
            mainScene.show();
        });

        VBox backVBox = new VBox(backButton);
        backVBox.setAlignment(Pos.BOTTOM_LEFT);
        backVBox.setPadding(new Insets(105, 0, 0,30));
 
        // Ini Adalah Background Image
        Image backImage = new Image(getClass().getClassLoader().getResourceAsStream("images/Background_Mainscene.jpg"));
        ImageView iView = new ImageView(backImage);
        iView.setFitWidth(960);
        iView.setFitHeight(600);

        // Ini Adalah Background BOX Login
        Image backBox = new Image(getClass().getClassLoader().getResourceAsStream("images/Black_Screen.jpg"));
        ImageView iView2 = new ImageView(backBox);
        iView2.setFitHeight(500);
        iView2.setFitWidth(350);
        iView2.setOpacity(0.95);
        // Membuat rectangle dengan efek melengkung
        Rectangle rectangle = new Rectangle(350, 500);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        // Mengatur efek melengkung pada ImageView
        iView2.setClip(rectangle);

        VBox img2 = new VBox();
        img2.getChildren().add(iView2);
        img2.setAlignment(Pos. CENTER);
        img2.setPadding(new Insets(65, 0, 0 , 0));

        VBox layout = new VBox();
        layout.getChildren().addAll(labelapp, boxField, errorvBox, signinBox, signupBox, backVBox);
        img.getChildren().addAll(iView, img2, layout);
        
        ScrollPane scrollPane = new ScrollPane(img);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);  


        Scene scene = new Scene(scrollPane, 960, 540);
        stage.setScene(scene);
        stage.show();
    }
    private void navigateToOtherScene() {
        HomeScene homeScene = new HomeScene(stage);
        homeScene.show();
    }
}
