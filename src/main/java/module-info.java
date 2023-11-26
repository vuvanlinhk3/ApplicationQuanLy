module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens Announcement to javafx.fxml;
    opens RoomConfig to javafx.fxml;
    exports Announcement;
    exports  RoomConfig;
}