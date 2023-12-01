package Document;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DocumentApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DocumentApplication.class.getResource("DocumentForm.fxml"));
        Parent root = fxmlLoader.load();
        //code trong này



        // --------------------------------------
        Scene scene = new Scene(root, 1300, 600);
        //scene.getStylesheets().add(getClass().getResource("Announcementcss.css").toExternalForm());
        stage.setTitle("Thông Báo !");
        stage.setScene(scene);
        stage.show();
    }
}
