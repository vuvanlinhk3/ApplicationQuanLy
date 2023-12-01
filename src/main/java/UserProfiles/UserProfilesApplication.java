package UserProfiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserProfilesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserProfilesApplication.class.getResource("UserProfilesForm.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root,1300,600);
        //scene.getStylesheets().add(getClass().getResource("UserProfilescss.css").toExternalForm());
        primaryStage.setTitle("Hồ Sơ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
