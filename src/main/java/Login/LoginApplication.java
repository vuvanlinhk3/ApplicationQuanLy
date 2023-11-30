package Login;

import MyCard.MyCardApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("LoginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1300,600 );
        primaryStage.setTitle("Đăng nhập");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
