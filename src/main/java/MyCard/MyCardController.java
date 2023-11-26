package MyCard;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyCardController {

    @FXML
    private Label hienthi;

    @FXML
    protected void clickbtn (){
        hienthi.setText("HELLO BEO !");
    }

}
