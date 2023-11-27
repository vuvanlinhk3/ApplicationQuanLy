package Announcement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AnnouncementController {
    @FXML
    public Button cancelx;
    @FXML
    private VBox yourVBoxId;
    @FXML
    private void xexit() {
        Label itemNotification_Label = new Label("HoangAnhPeas has just changed the location of 1 file");

        // Thêm label mới vào VBox
        yourVBoxId.getChildren().add(itemNotification_Label);


    }
}