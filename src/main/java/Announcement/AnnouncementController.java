package Announcement;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementController {
    @FXML
    public Button cancelx;
    @FXML
    private VBox yourVBoxId;
    private List<Label> labelList = new ArrayList<>();
    private boolean seen = false;
    private Button notifidontseen;
    private boolean changeseened = false;
    private ObservableList<Label> originalOrder = FXCollections.observableArrayList();
    @FXML
    private void xexit() {
        Label itemNotification_Label = new Label("HoangAnhPeas has just changed the location of 1 file"); // tạo label trong code
        itemNotification_Label.setPadding(new Insets(20)); // tạo khoảng cách của chữ với lề
        VBox.setMargin(itemNotification_Label, new Insets(5, 0, 5, 0)); // tạo khảng cách giữa các label
        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY); //sét màu nền
        // Tạo Background từ BackgroundFill
        Background background = new Background(backgroundFill); // tạo background
        itemNotification_Label.setBackground(background);
        itemNotification_Label.setMaxWidth(Double.MAX_VALUE);

        // Thêm sự kiện click cho label
        itemNotification_Label.setOnMouseClicked(event -> handleClick(itemNotification_Label));

        // Thêm label mới vào VBox và danh sách
        yourVBoxId.getChildren().add(itemNotification_Label);
        labelList.add(itemNotification_Label);
        originalOrder.add(itemNotification_Label);
    }
    @FXML
    private void handleClick(Label clickedLabel) {
        // Đặt màu nền của label được click
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        clickedLabel.setBackground(background);

        // Đặt trạng thái seen của label được click
        setSeen(clickedLabel, true);
    }

    @FXML
    private void clicknotifidontseen() {
        changeseened = !changeseened;
        if (changeseened) {
            // Ẩn các label có seen == true
            for (Label label : labelList) {
                if (isSeen(label)) {
                    label.setVisible(false);
                }
            }
            // Tạo một danh sách mới chứa các label không bị ẩn
            List<Label> visibleLabels = new ArrayList<>();
            for (Label label : labelList) {
                if (label.isVisible()) {
                    visibleLabels.add(label);
                }
            }
            // Sắp xếp lại VBox với danh sách mới
            yourVBoxId.getChildren().setAll(visibleLabels);
        } else {
            // Hiện lại tất cả các label
            for (Label label : labelList) {
                label.setVisible(true);
            }
            // Sắp xếp lại VBox với danh sách gốc
            yourVBoxId.getChildren().setAll(originalOrder);
        }
    }


    private void setSeen(Label label, boolean value) {
        // Đặt trạng thái seen của label
        BackgroundFill backgroundFill = new BackgroundFill(value ? Color.LIGHTGRAY : Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        label.setBackground(background);
    }

    private boolean isSeen(Label label) {
        // Kiểm tra trạng thái seen của label
        Background background = label.getBackground();
        return background.getFills().get(0).getFill() == Color.LIGHTGRAY;
    }

}
