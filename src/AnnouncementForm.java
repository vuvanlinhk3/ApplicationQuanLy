import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AnnouncementForm extends JFrame {

    public AnnouncementForm() {
        setTitle("Thông Báo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // Create JPanel for header (occupies 10%)
        JPanel headerAnnouncement = new JPanel();
        headerAnnouncement.setLayout(new BorderLayout());
        headerAnnouncement.setBackground(Color.BLACK);

        // Create exit button
        ImageIcon exitimgbtn = new ImageIcon("img/daux.jpg");
        Image scaledExitImage = exitimgbtn.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedExitIcon = new ImageIcon(scaledExitImage);

        JButton exitButton = new JButton(resizedExitIcon);
        exitButton.setBackground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(70, 70));
        //exitButton.setBorder(new EmptyBorder(0, 0, 0, 0)); // Add padding (1px on all sides)
        headerAnnouncement.add(exitButton, BorderLayout.WEST);

        // Create notification label
        JLabel notificationLabel = new JLabel("Thông Báo");
        notificationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        notificationLabel.setForeground(Color.WHITE);
        notificationLabel.setBorder(new EmptyBorder(0, 15, 0, 0)); // Add padding (5px on all sides)
        headerAnnouncement.add(notificationLabel, BorderLayout.CENTER);


        // Create three remaining buttons
        ImageIcon markimg = new ImageIcon("img/tichv.jpg");
        Image scaledMarkImage = markimg.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedMarkIcon = new ImageIcon(scaledMarkImage);
        JButton markButton = new JButton(resizedMarkIcon);
        markButton.setBackground(Color.BLACK);
        markButton.setPreferredSize(new Dimension(70, 70));


        ImageIcon configimg = new ImageIcon("img/bacham.jpg");
        Image scaledConfigImage = configimg.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedConfigIcon = new ImageIcon(scaledConfigImage);
        JButton configButton = new JButton(resizedConfigIcon);
        configButton.setBackground(Color.BLACK);
        configButton.setPreferredSize(new Dimension(70, 70));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(markButton);
        buttonPanel.add(configButton);

        // Add button panel to header
        headerAnnouncement.add(buttonPanel, BorderLayout.EAST);

        // Create JPanel for the second panel (occupies 10%)
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());

        // Create two buttons for the second panel
        JButton sortButton = new JButton("Xắp Xếp Theo");
        JButton unreadButton = new JButton("Thông Báo Chưa Đọc");

        // Create panel for the buttons in the second panel
        JPanel secondButtonPanel = new JPanel();
        secondButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        secondButtonPanel.add(sortButton);
        secondButtonPanel.add(unreadButton);

        // Add button panel to the second panel
        secondPanel.add(secondButtonPanel, BorderLayout.WEST);

        // Create JPanel for the main part (occupies 80%)
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Use BorderLayout for AnnouncementForm
        setLayout(new BorderLayout());
        add(headerAnnouncement, BorderLayout.NORTH);
        add(secondPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.SOUTH);

                setVisible(true);

    }

    public static void main(String[] args) {
        new AnnouncementForm();
    }
}
