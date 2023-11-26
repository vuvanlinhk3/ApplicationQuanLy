package Announcement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AnnouncementController {
    @FXML
    private Label thongbao;

    @FXML
    protected void xexit() {
        thongbao.setText("Welcome to JavaFX Application!");
    }
}