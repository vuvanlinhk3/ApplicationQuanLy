import javax.swing.*;
import java.awt.*;

public class AnnouncementForm extends JFrame {
    public AnnouncementForm(){
        setTitle("Thông Báo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
//        setLocation(300,300);
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
    }
    public static void main(String[] args) {
        new AnnouncementForm();

    }
}
