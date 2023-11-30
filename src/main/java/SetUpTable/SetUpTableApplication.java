package SetUpTable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SetUpTableApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SetUpTableApplication.class.getResource("SetUpTableForm.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root , 1300,600);
        primaryStage.setTitle("Thiết Lập Bảng");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
