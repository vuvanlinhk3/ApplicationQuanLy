package UserProfiles;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

public class UserProfilesController {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private BorderPane layoutmain;

    @FXML
    private VBox vBoxAll;

    @FXML
    public void initialize() {
        // Use a try-catch block to handle potential exceptions when loading the image
        try {
            // Use getClass().getResource() to load the image from the resources directory
            Image backgroundImage = new Image(getClass().getResource("/img/background.png").toExternalForm());

            // Create a background image and set it to the center of the BorderPane
            BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
            layoutmain.setBackground(new Background(background));

            // Set the width of VBox to be the same as the width of ScrollPane
            vBoxAll.prefWidthProperty().bind(scrollPane.widthProperty());

            // Adjust VBox width when ScrollPane changes
            scrollPane.hbarPolicyProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals(ScrollPane.ScrollBarPolicy.ALWAYS)) {
                    vBoxAll.prefWidthProperty().unbind();
                } else {
                    vBoxAll.prefWidthProperty().bind(scrollPane.widthProperty());
                }
            });
        } catch (Exception e) {
            // Log or handle the exception appropriately
            e.printStackTrace();
        }
    }
}
