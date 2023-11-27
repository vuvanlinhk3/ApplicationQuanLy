module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens Announcement to javafx.fxml;
    opens RoomConfig to javafx.fxml;
    opens  WorkDetails to javafx.fxml;
    opens MyCard to javafx.fxml;


    exports WorkDetails;
    exports MyCard;
    exports Announcement;
    exports  RoomConfig;
}