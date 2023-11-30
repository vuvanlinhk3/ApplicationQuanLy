package Announcement;

import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AnnouncementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AnnouncementApplication.class.getResource("AnnouncementForm.fxml"));
        Parent root = fxmlLoader.load();
        //code trong này



        // --------------------------------------
        Scene scene = new Scene(root, 1300, 600);
        scene.getStylesheets().add(getClass().getResource("Announcementcss.css").toExternalForm());
        stage.setTitle("Thông Báo !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}