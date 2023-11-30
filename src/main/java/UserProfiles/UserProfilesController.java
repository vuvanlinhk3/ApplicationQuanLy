package UserProfiles;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class UserProfilesController {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBoxAll;
    @FXML
    public void initialize() {
        // Đặt chiều ngang của VBox bằng với chiều ngang của ScrollPane
        vBoxAll.prefWidthProperty().bind(scrollPane.widthProperty());

        // Bật tính năng điều chỉnh chiều ngang của VBox khi ScrollPane thay đổi
        scrollPane.hbarPolicyProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(ScrollPane.ScrollBarPolicy.ALWAYS)) {
                vBoxAll.prefWidthProperty().unbind();
            } else {
                vBoxAll.prefWidthProperty().bind(scrollPane.widthProperty());
            }
        });
    }
}
