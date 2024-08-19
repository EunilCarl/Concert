import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Receipt extends JFrame {
    private Set<String> selectedSeats;
    private String tier;
    private String concertTitle;
    private String imagePath;
    private JLabel balanceStatusLabel;
    private JTextField accountNumberField; // Make this a member variable

    public Receipt(Set<String> selectedSeats, String tier, String concertTitle, String imagePath) {
        this.selectedSeats = selectedSeats;
        this.tier = tier;
        this.concertTitle = concertTitle;
        this.imagePath = imagePath;
        JPanel head = Header.headerPanel("BPSU Konex");
        this.add(head, BorderLayout.NORTH);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        JPanel content = contentPanel();

        JLabel label = new JLabel("Order Summary");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.setBackground(Color.ORANGE);
        panel.add(label);

        this.setLayout(new BorderLayout());

        this.add(panel, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);

        this.setSize(1900, 1200); // Increase window height
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        Font font = new Font("Arial", Font.PLAIN, 20);

        JLabel eventLabel = new JLabel("<html><b>" + concertTitle + "</b><br>08/11/2023, 7:00 PM<br>Mall of Asia Arena<br>");
        eventLabel.setFont(font);
        leftPanel.add(eventLabel);

        JLabel tierLabel = new JLabel("<html><b>Tier:</b> " + tier);
        tierLabel.setFont(font);
        leftPanel.add(tierLabel);

        JLabel seatsLabel = new JLabel("<html><b>Selected Seats:</b> " + selectedSeats);
        seatsLabel.setFont(font);
        leftPanel.add(seatsLabel);

        double pricePerTicket = getPricePerTicket(tier);
        double subtotal = pricePerTicket * selectedSeats.size();
        double total = subtotal + 100; // Including online fee

        JLabel priceLabel = new JLabel("<html><b>Price per Ticket:</b> PHP " + pricePerTicket);
        priceLabel.setFont(font);
        leftPanel.add(priceLabel);

        JLabel subtotalLabel = new JLabel("<html><b>Subtotal:</b> PHP " + subtotal);
        subtotalLabel.setFont(font);
        leftPanel.add(subtotalLabel);

        JLabel feeLabel = new JLabel("<html><b>Online Fee:</b> PHP 100");
        feeLabel.setFont(font);
        leftPanel.add(feeLabel);

        JLabel totalLabel = new JLabel("<html><b>Total:</b> PHP " + total);
        totalLabel.setFont(font);
        leftPanel.add(totalLabel);

        // Add white panel to simulate a receipt look
        JPanel receiptPanel = new JPanel();
        receiptPanel.setBackground(Color.WHITE);
        receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
        receiptPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Font receiptFont = new Font("Arial", Font.PLAIN, 24); // Larger font for receipt

        JLabel receiptTitle = new JLabel("Receipt");
        receiptTitle.setFont(new Font("Arial", Font.BOLD, 50)); // Increase font size
        receiptPanel.add(receiptTitle);

        receiptPanel.add(createReceiptLabel("---------------------------------------------------", receiptFont));
        receiptPanel.add(createReceiptLabel("Item: " + concertTitle, receiptFont));
        receiptPanel.add(createReceiptLabel("Date: 08/11/2023, 7:00 PM", receiptFont));
        receiptPanel.add(createReceiptLabel("Venue: Mall of Asia Arena", receiptFont));
        receiptPanel.add(createReceiptLabel("Tier: " + tier, receiptFont));
        receiptPanel.add(createReceiptLabel("Seats: " + selectedSeats, receiptFont));
        receiptPanel.add(createReceiptLabel("Price per Ticket: PHP " + pricePerTicket, receiptFont));
        receiptPanel.add(createReceiptLabel("Subtotal: PHP " + subtotal, receiptFont));
        receiptPanel.add(createReceiptLabel("Online Fee: PHP 100", receiptFont));
        receiptPanel.add(createReceiptLabel("Total: PHP " + total, receiptFont));
        receiptPanel.add(createReceiptLabel("---------------------------------------------------", receiptFont));

        panel.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Payment Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(new JLabel("Account Name:"), gbc);

        accountNumberField = new JTextField(30);
        accountNumberField.setPreferredSize(new Dimension(300, 30));
        accountNumberField.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 1;
        rightPanel.add(accountNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPanel.add(new JLabel("Cash:"), gbc);

        JTextField cashField = new JTextField(25);
        cashField.setPreferredSize(new Dimension(300, 30));
        cashField.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 1;
        rightPanel.add(cashField, gbc);

        balanceStatusLabel = new JLabel("");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        rightPanel.add(balanceStatusLabel, gbc);

        JButton payButton = new JButton("Pay");
        payButton.setBackground(Color.PINK);
        payButton.setPreferredSize(new Dimension(100, 30));
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double cash = Double.parseDouble(cashField.getText());
                    if (cash >= total) {
                        if (e.getSource() == payButton) {
                            String accountName = accountNumberField.getText();
                            new Thank(accountName);
                        }
                        balanceStatusLabel.setText("<html><font color='green'>Transaction Successful!</font>");
                    } else {
                        balanceStatusLabel.setText("<html><font color='red'>Insufficient Balance.</font>");
                    }
                } catch (NumberFormatException ex) {
                    balanceStatusLabel.setText("<html><font color='red'>Invalid cash amount.</font>");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        rightPanel.add(payButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        rightPanel.add(receiptPanel, gbc);

        panel.add(rightPanel);

        // Add concert image
        ImageIcon img = new ImageIcon(imagePath);
        Image resized = img.getImage().getScaledInstance(450, 550, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(image);
        leftPanel.add(imageLabel);

        return panel;
    }

    private JLabel createReceiptLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private double getPricePerTicket(String tier) {
        switch (tier) {
            case "Tier A":
                return 10350.00;
            case "Tier B":
                return 7650.00;
            case "Tier C":
                return 4550.00;
            case "Tier D":
                return 1750.00;
            default:
                return 0.00;
        }
    }
}
