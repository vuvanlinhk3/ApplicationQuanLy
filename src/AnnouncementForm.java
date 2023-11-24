import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.border.Border;

public class AnnouncementForm extends JFrame {

    public AnnouncementForm() {
        setTitle("Thông Báo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        initNotifi();

        setVisible(true);
    }

    public void initNotifi() {
        // tạo jpanel khung cho jframe
        // header
        JPanel headerAnnouncement = new JPanel();
        headerAnnouncement.setLayout(new BorderLayout());
        headerAnnouncement.setBackground(Color.BLACK);
        // body
        JPanel bodyNotifi_JPanel = new JPanel();
        bodyNotifi_JPanel.setLayout(new BoxLayout(bodyNotifi_JPanel, BoxLayout.Y_AXIS));

        // Use JScrollPane to support scrolling
        JScrollPane bodyScrollPane = new JScrollPane(bodyNotifi_JPanel);
        // Set up the scrollbar to always be visible
        bodyScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // footer
        JPanel footer_JPanel = new JPanel();
        footer_JPanel.setBackground(Color.LIGHT_GRAY);

        Border headerBorder = BorderFactory.createLineBorder(Color.WHITE);
        headerAnnouncement.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), headerBorder));

        Border seconBorder = BorderFactory.createLineBorder(Color.RED);
        bodyNotifi_JPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), seconBorder));

        Border mainBorder = BorderFactory.createLineBorder(Color.GREEN);
        footer_JPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), mainBorder));

        // set layout for jframe -----------------------------
        setLayout(new BorderLayout());
        add(headerAnnouncement, BorderLayout.NORTH);
        add(bodyScrollPane, BorderLayout.CENTER); // Use bodyScrollPane instead of bodyNotifi_JPanel directly
        add(footer_JPanel, BorderLayout.SOUTH);
        // ---------------------------------------------------
        // HEADER --------------------------------------------------------------------------------------------------
        // Create exit button
        ImageIcon exitimgbtn = new ImageIcon("img/daux.jpg");
        Image scaledExitImage = exitimgbtn.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedExitIcon = new ImageIcon(scaledExitImage);
        JButton exitButton = new JButton(resizedExitIcon);
        exitButton.setBackground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(70, 70));
        headerAnnouncement.add(exitButton, BorderLayout.WEST);

        // Create notification label
        JLabel notificationLabel = new JLabel("Thông Báo");
        notificationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        notificationLabel.setForeground(Color.WHITE);
        notificationLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
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

        // Add button panel to header
        JPanel markAndCofig_JPanel = new JPanel();
        markAndCofig_JPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        markAndCofig_JPanel.add(markButton);
        markAndCofig_JPanel.add(configButton);
        Border panelbtnboder = BorderFactory.createLineBorder(Color.BLACK);
        markAndCofig_JPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), panelbtnboder));
        headerAnnouncement.add(markAndCofig_JPanel, BorderLayout.EAST);

        // END HEADER -------------------------------------------------------------------------------------------------
        // BODY -------------------------------------------------------------------------------------------------------
        // Create two buttons for the second panel
        JButton sortButton = new JButton("Xắp Xếp Theo");
        JButton unreadButton = new JButton("Thông Báo Chưa Đọc");

        // Create panel for the buttons in the second panel
        JPanel OrganizeNotificationsJPanel = new JPanel();
        OrganizeNotificationsJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        OrganizeNotificationsJPanel.add(sortButton);
        OrganizeNotificationsJPanel.add(unreadButton);
        Border secondbtnBorder = BorderFactory.createLineBorder(Color.GRAY);
        OrganizeNotificationsJPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), secondbtnBorder));

        // Add button panel to the second panel
        JPanel notificationsPanel = new JPanel();
        notificationsPanel.setLayout(new BoxLayout(notificationsPanel, BoxLayout.Y_AXIS));
        notificationsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add notifications to notificationsPanel
        for (int i = 0; i < 13; i++) {
            JPanel notificationPanel = createNotificationPanel("Thông báo số " + (i + 1));
            // Set preferred size for each notificationPanel
            notificationPanel.setPreferredSize(new Dimension(200, 40));
            notificationsPanel.add(notificationPanel);
        }

        // Set up scrollbar for notificationsPanel
        JScrollPane notificationsScrollPane = new JScrollPane(notificationsPanel);
        notificationsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        notificationsScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add notificationsPanel to body panel
        bodyNotifi_JPanel.add(notificationsScrollPane);
    }

    // Phương thức để tạo một JPanel chứa thông báo
    private JPanel createNotificationPanel(String message) {
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BorderLayout());
        notificationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JTextArea messageArea = new JTextArea(message);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setEditable(false);

        notificationPanel.add(messageArea, BorderLayout.CENTER);

        return notificationPanel;
    }

    public static void main(String[] args) {
        new AnnouncementForm();
    }
}
