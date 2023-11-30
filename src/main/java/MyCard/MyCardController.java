package MyCard;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyCardController {
    private VBox layout;

    @FXML
    protected void clickbtn () {
        layout = new VBox();
        Label hienthi = new Label("heello beo ngốc ");
        layout.getChildren().add(hienthi);
        String name = hienthi.getText();
        hienthi.setText(name + " ngốc");
    }

}
