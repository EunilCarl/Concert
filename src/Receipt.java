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
        JPanel footer = footerPanel();

        JLabel label = new JLabel("Order Summary");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.setBackground(Color.ORANGE);
        panel.add(label);

        this.setLayout(new BorderLayout());

        this.add(panel, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel contentPanel() {

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());

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

        JLabel receiptTitle = new JLabel("Receipt");
        receiptTitle.setFont(new Font("Arial", Font.BOLD, 20));
        receiptPanel.add(receiptTitle);

        receiptPanel.add(new JLabel("---------------------------------------------------"));
        receiptPanel.add(new JLabel("Item: " + concertTitle));
        receiptPanel.add(new JLabel("Date: 08/11/2023, 7:00 PM"));
        receiptPanel.add(new JLabel("Venue: Mall of Asia Arena"));
        receiptPanel.add(new JLabel("Tier: " + tier));
        receiptPanel.add(new JLabel("Seats: " + selectedSeats));
        receiptPanel.add(new JLabel("Price per Ticket: PHP " + pricePerTicket));
        receiptPanel.add(new JLabel("Subtotal: PHP " + subtotal));
        receiptPanel.add(new JLabel("Online Fee: PHP 100"));
        receiptPanel.add(new JLabel("Total: PHP " + total));
        receiptPanel.add(new JLabel("---------------------------------------------------"));

        leftPanel.add(receiptPanel);

        panel.add(leftPanel);



        rightPanel.add(new JLabel("Account Name:"));
        JTextField accountNumberField = new JTextField(15);
        accountNumberField.setPreferredSize(new Dimension(500, 50));
        accountNumberField.setFont(new Font("Arial", Font.PLAIN, 20));
        rightPanel.add(accountNumberField);

        rightPanel.add(new JLabel("Cash:"));
        JTextField cashField = new JTextField(25);
        cashField.setPreferredSize(new Dimension(600, 50));
        cashField.setFont(new Font("Arial", Font.PLAIN, 20));
        rightPanel.add(cashField);

        balanceStatusLabel = new JLabel("");
        rightPanel.add(balanceStatusLabel);

        JButton payButton = new JButton("Pay");
        payButton.setBackground(Color.PINK);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double cash = Double.parseDouble(cashField.getText());
                    if (cash >= total) {
                        balanceStatusLabel.setText("<html><font color='green'>Transaction Successful!</font>");
                    } else {
                        balanceStatusLabel.setText("<html><font color='red'>Insufficient Balance.</font>");
                    }
                } catch (NumberFormatException ex) {
                    balanceStatusLabel.setText("<html><font color='red'>Invalid cash amount.</font>");
                }
            }
        });

        rightPanel.add(payButton);

        // Add concert image
        ImageIcon img = new ImageIcon(imagePath);
        Image resized = img.getImage().getScaledInstance(450, 550, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(image);
        leftPanel.add(imageLabel);

        panel.add(rightPanel);

        return panel;
    }

    private JPanel footerPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel("Carose Tickets");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label);
        return panel;
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