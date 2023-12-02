package Announcement;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import java.util.HashSet;
import java.util.Set;


public class AnnouncementController {
    @FXML
    public Button cancelx;
    @FXML
    private VBox yourVBoxId;
    private List<Label> labelList = new ArrayList<>();

    // tạo biến xác định đọc hay chưa , mặc định chưa đọc


    @FXML
    private void xexit() {
        Label itemNotification_Label = new Label("HoangAnhPeas has just changed the location of 1 file");
        itemNotification_Label.setPadding(new Insets(20));
        VBox.setMargin(itemNotification_Label, new Insets(5, 0, 5, 0));

        // Set default background color based on read status
        BackgroundFill backgrounddefault= new BackgroundFill(
                 Color.rgb(0,0,0,0.5),
                CornerRadii.EMPTY,
                Insets.EMPTY
        );
        Background background = new Background(backgrounddefault);
        itemNotification_Label.setBackground(background);

        itemNotification_Label.setMaxWidth(Double.MAX_VALUE);

        // Add click event to handle read/unread status
        itemNotification_Label.setOnMouseClicked(event -> handleClick(itemNotification_Label));

        // Add label to VBox and list
        yourVBoxId.getChildren().add(itemNotification_Label);
        labelList.add(itemNotification_Label);
    }
    private boolean isRead = false;
    private void setReadStatus(Label label, boolean isRead) {
        // Đặt trạng thái của label
        label.getProperties().put("isRead", isRead);
    }
    // Handle click on an announcement label
    private Set<Label> clickedLabels = new HashSet<>();

    private void handleClick(Label clickedLabel) {
        // Nếu clickedLabel chưa tồn tại trong danh sách clickedLabels, thì mới thêm vào
        if (!clickedLabels.contains(clickedLabel)) {
            isRead = !isRead;
            if (isRead) {
                setBackground(clickedLabel);
                clickedLabels.add(clickedLabel);
                setReadStatus(clickedLabel, true);
            }
        }
        for (Label label : clickedLabels) {
            System.out.println(label);
        }
    }

    private void setBackground(Label label) {
        BackgroundFill backgroundFill = new BackgroundFill(
                isRead ? Color.rgb(0,0,0,0.3) : Color.rgb(0,0,0,0.5),
                CornerRadii.EMPTY,
                Insets.EMPTY
        );
        Background background = new Background(backgroundFill);
        label.setBackground(background);
    }

    private void showAllLabels() {
        ObservableList<Node> children = yourVBoxId.getChildren();
        children.clear();

        // Add all labels to the VBox
        for (Label label : labelList) {
            setBackground(label);
            children.add(label);
        }
    }

    @FXML
    private Button notifidontseen;

    private boolean allandnot = false;
    @FXML
    private void clicknotifidontseen() {
        allandnot = !allandnot;
        try {
            if (allandnot) {
                ObservableList<Node> children = yourVBoxId.getChildren();
                notifidontseen.setText("Tất cả");
                // Remove seen labels
                children.removeIf(node -> node instanceof Label && clickedLabels.contains(node));
            } else {
                notifidontseen.setText("Thông Báo Chưa Đọc");
                showAllLabels();

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Handle click on "Mark All as Seen" button
    @FXML
    private void clickallseeened() {
        isRead = true; // Mark all as seen
        for (Label label : labelList) {
            setBackground(label);
            clickedLabels.add(label);
        }
    }


    @FXML
    private ScrollPane scrollnotification;
    @FXML
    public void initialize() {
        // Set the width of VBox to be the same as the width of ScrollPane
        yourVBoxId.prefWidthProperty().bind(scrollnotification.widthProperty());

        // Adjust VBox width when ScrollPane changes
        scrollnotification.hbarPolicyProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(ScrollPane.ScrollBarPolicy.ALWAYS)) {
                yourVBoxId.prefWidthProperty().unbind();
            } else {
                yourVBoxId.prefWidthProperty().bind(scrollnotification.widthProperty());
            }
        });
    }
}
