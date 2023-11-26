package RoomConfig;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomConfigApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RoomConfigApplication.class.getResource("RoomConfigForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600 , 900);
        primaryStage.setTitle("Cài Đặt Phòng");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
