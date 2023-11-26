package WorkDetails;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkDetailsApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WorkDetailsApplication.class.getResource("WorkDetailsForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1300,600 );
        primaryStage.setTitle("Chi Tiết Công Việc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
