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


public class AnnouncementController {
    @FXML
    public Button cancelx;
    @FXML
    private VBox yourVBoxId;
    private List<Label> labelList = new ArrayList<>();

    // Variable to track whether an announcement has been read or not
    private boolean isRead = false;

    @FXML
    private void xexit() {
        Label itemNotification_Label = new Label("HoangAnhPeas has just changed the location of 1 file");
        itemNotification_Label.setPadding(new Insets(20));
        VBox.setMargin(itemNotification_Label, new Insets(5, 0, 5, 0));

        // Set default background color based on read status
        setBackground(itemNotification_Label);

        itemNotification_Label.setMaxWidth(Double.MAX_VALUE);

        // Add click event to handle read/unread status
        itemNotification_Label.setOnMouseClicked(event -> handleClick(itemNotification_Label));

        // Add label to VBox and list
        yourVBoxId.getChildren().add(itemNotification_Label);
        labelList.add(itemNotification_Label);
    }

    // Handle click on an announcement label
    private void handleClick(Label label) {
        isRead = !isRead; // Toggle read status
        setBackground(label);
    }

    // Set background color based on read status
    private void setBackground(Label label) {
        BackgroundFill backgroundFill = new BackgroundFill(
                isRead ? Color.LIGHTGRAY : Color.DARKGRAY,
                CornerRadii.EMPTY,
                Insets.EMPTY
        );
        Background background = new Background(backgroundFill);
        label.setBackground(background);
    }

    // Handle click on "Mark as Unseen" button
    @FXML
    private void clicknotifidontseen() {
        ObservableList<Node> children = yourVBoxId.getChildren();

        // Remove seen labels
        children.removeIf(node -> {
            if (node instanceof Label) {
                return isRead;
            }
            return false;
        });

        // Add unseen labels to the beginning
        for (Label label : labelList) {
            if (!isRead) {
                children.add(0, label);
            }
        }
    }

    // Handle click on "Mark All as Seen" button
    @FXML
    private void clickallseeened() {
        isRead = true; // Mark all as seen
        for (Label label : labelList) {
            setBackground(label);
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
