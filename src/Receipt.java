import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Receipt extends JFrame {
    private Set<String> selectedSeats;
    private String tier;
    private JLabel balanceStatusLabel;

    public Receipt(Set<String> selectedSeats, String tier) {
        this.selectedSeats = selectedSeats;
        this.tier = tier;
        initUI();
    }

    private void initUI() {
        JPanel header = headerPanel();
        JPanel content = contentPanel();
        JPanel footer = footerPanel();

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel headerPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        JLabel label = new JLabel("Order Summary");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        return panel;
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new JLabel("<html><b>The Super Stage by KPop</b><br>08/11/2023, 7:00 PM<br>Mall of Asia Arena<br>"));
        leftPanel.add(new JLabel("<html><b>Tier:</b> " + tier));
        leftPanel.add(new JLabel("<html><b>Selected Seats:</b> " + selectedSeats));

        double pricePerTicket = getPricePerTicket(tier);
        double subtotal = pricePerTicket * selectedSeats.size();
        double total = subtotal + 100; // Including online fee

        leftPanel.add(new JLabel("<html><b>Price per Ticket:</b> PHP " + pricePerTicket));
        leftPanel.add(new JLabel("<html><b>Subtotal:</b> PHP " + subtotal));
        leftPanel.add(new JLabel("<html><b>Online Fee:</b> PHP 100"));
        leftPanel.add(new JLabel("<html><b>Total:</b> PHP " + total));

        panel.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rightPanel.add(new JLabel("Account Number:"));
        JTextField accountNumberField = new JTextField(20);
        rightPanel.add(accountNumberField);

        rightPanel.add(new JLabel("Cash:"));
        JTextField cashField = new JTextField(20);
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
        panel.add(rightPanel);

        return panel;
    }

    private JPanel footerPanel() {
        JPanel head = Header.headerPanel("BPSU Konex");
        this.add(head);
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
