import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order extends JFrame implements ActionListener {
    private String concertTitle;
    private String imagePath;

    public Order(String concertTitle, String imagePath) {
        this.concertTitle = concertTitle;
        this.imagePath = imagePath;

        // Create the header panel
        JPanel head = Header.headerPanel("BPSU Konex");
        this.add(head, BorderLayout.NORTH);

        // Create the main content panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 20, 20));
        mainPanel.setBackground(Color.BLACK);

        // Add tiers
        mainPanel.add(createTierPanel("Tier A", "PHP 10,350.00"));
        mainPanel.add(createTierPanel("Tier B", "PHP 7,650.00"));
        mainPanel.add(createTierPanel("Tier C", "PHP 4,550.00"));
        mainPanel.add(createTierPanel("Tier D", "PHP 1,750.00"));

        // Configure the frame
        this.add(head, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel createTierPanel(String tierName, String price) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        JLabel tierLabel = new JLabel(tierName);
        tierLabel.setForeground(Color.WHITE);
        tierLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tierLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel priceLabel = new JLabel(price);
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton selectSeatsButton = new JButton("SELECT SEATS");
        selectSeatsButton.setFont(new Font("Arial", Font.BOLD, 16));
        selectSeatsButton.setBackground(Color.PINK);
        selectSeatsButton.setForeground(Color.BLACK);
        selectSeatsButton.addActionListener(e -> new Seat(tierName, concertTitle, imagePath));

        panel.add(tierLabel, BorderLayout.NORTH);
        panel.add(priceLabel, BorderLayout.CENTER);
        panel.add(selectSeatsButton, BorderLayout.SOUTH);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This is now handled directly within the createTierPanel method
    }
}