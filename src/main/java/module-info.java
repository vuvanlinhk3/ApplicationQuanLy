module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens Announcement to javafx.fxml;
    opens RoomConfig to javafx.fxml;
    opens  WorkDetails to javafx.fxml;
    opens MyCard to javafx.fxml;
    opens SetUpTable to javafx.fxml;
    opens SettingUser to javafx.fxml;
    opens  UserProfiles to javafx.fxml;
    opens Login to javafx.fxml;
    opens Signup to javafx.fxml;
    opens Home to javafx.fxml;

    exports SetUpTable;
    exports UserProfiles;
    exports SettingUser;
    exports MyCard;
    exports Announcement;
    exports  RoomConfig;
    exports Login;
    exports Signup;
    exports Home;
}