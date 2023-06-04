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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Regist {
    private Stage stage;
    private ObservableList<DataRegist>listUser;
    private Registdb registdb;

    public Regist(Stage stage) {
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

        Label labelsignin = new Label("Sign Up");
        labelsignin.setStyle("-fx-font-size: 29px; -fx-font-weight: bold; -fx-text-fill: #EDEDED; -fx-font-family: Arial");
        VBox lblsignin = new VBox(labelsignin);
        lblsignin.setAlignment(Pos. CENTER);
        lblsignin.setPadding(new Insets(0, 160, 0, 0));

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

        Button saveButton = new Button("Sign Up");
        saveButton.setMaxWidth(250);
        saveButton.setMaxHeight(45);
        saveButton.setPrefHeight(45);
        saveButton.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 15px");
        saveButton.setOnMouseEntered(event -> {
            saveButton.setStyle("-fx-background-color: #8F0B1F; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 15px");
        });
        saveButton.setOnMouseExited(event -> {
            saveButton.setStyle("-fx-background-color: #BD2424; -fx-text-fill: #D4D4D4; -fx-font-weight: bold; -fx-font-size: 15px");
        });
        saveButton.setOnAction(V -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });
        saveButton.setOnAction(V -> {
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            // kondisi apabila ada textfield belum terisi
            if (username.isEmpty()||password.isEmpty()) {
                errorLabel.setText("Username or Password is empty !");
                errorLabel.setVisible(true);

                // Membuat PauseTransition untuk mengubah visibilitas Label setelah 3 detik
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(event -> errorLabel.setVisible(false));
                pause.play();
            } else {
                // Mendapatkan list semua pengguna dari database
                registdb = new Registdb();
                try {
                    listUser.addAll(registdb.getAll());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                // Mengecek apakah username sudah ada dalam listUser
                boolean confirm = false;
                for (DataRegist userLoop : listUser) {
                    if (userLoop.getUsername().equals(username)) {
                        confirm = true;
                        break;
                    }
                }

                if (confirm) {
                    // Jika username sudah ada, tampilkan pesan kesalahan
                    errorLabel.setText("Username already used!");
                    errorLabel.setVisible(true);

                    // Membuat PauseTransition untuk mengubah visibilitas Label setelah 3 detik
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(event -> errorLabel.setVisible(false));
                    pause.play();

                    tfUsername.clear();
                    tfPassword.clear();
                } else {
                    // Membuat objek RegistPage untuk menyimpan data pengguna yang terdaftar
                    DataRegist user = new DataRegist(username, password);

                    // Jika username belum ada, tambahkan pengguna ke dalam daftar pengguna
                    listUser.add(user);

                    // Menyimpan data ke dalam database
                    Registdb.saveData(username, password);

                    errorLabel.setText("Success!");
                    errorLabel.setVisible(true);

                    // Membuat PauseTransition untuk mengubah visibilitas Label setelah 3 detik
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(event -> errorLabel.setVisible(false));
                    pause.play();

                    tfUsername.clear();
                    tfPassword.clear();
                }
            }
        });

        VBox saveBox = new VBox(saveButton);
        saveBox.setAlignment(Pos. CENTER);
        saveBox.setPadding(new Insets(10, 0, 0, 0));

        VBox errorvBox = new VBox(errorLabel);
        errorvBox.setAlignment(Pos. CENTER);
        errorvBox.setPadding(new Insets(10, 0, 0, 0));

        // Ini Adalah Background Image
        Image backImage = new Image(getClass().getClassLoader().getResourceAsStream("images/Background_Mainscene.jpg"));
        ImageView iView = new ImageView(backImage);
        iView.setFitWidth(960);
        iView.setFitHeight(600);

        // Ini Adalah Background BOX Login
        Image backBox = new Image(getClass().getClassLoader().getResourceAsStream("images/Black_Screen.jpg"));
        ImageView iView2 = new ImageView(backBox);
        iView2.setFitHeight(450);
        iView2.setFitWidth(350);
        iView2.setOpacity(0.95);
        // Membuat rectangle dengan efek melengkung
        Rectangle rectangle = new Rectangle(350, 450);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        // Mengatur efek melengkung pada ImageView
        iView2.setClip(rectangle);

        VBox img2 = new VBox();
        img2.getChildren().add(iView2);
        img2.setAlignment(Pos. CENTER);
        img2.setPadding(new Insets(15, 0, 0 , 0));

        VBox layout = new VBox();
        layout.getChildren().addAll(labelapp, signinBox, boxField, errorvBox, saveBox);
        img.getChildren().addAll(iView, img2, layout);
        
        ScrollPane scrollPane = new ScrollPane(img);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        
        Scene scene = new Scene(scrollPane, 960, 540);
        stage.setScene(scene);
        stage.show();
    }
}
