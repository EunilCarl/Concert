import javax.swing.*;
import java.awt.*;

public class Thank extends JFrame {
    public Thank(String accountName) {
        JPanel head = Header.headerPanel("BPSU Konex");
        this.add(head, BorderLayout.NORTH);

        //thank you message with the account name
        JLabel thankYouLabel = new JLabel("Thank you for purchasing, " + accountName + ". Enjoy!!", SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Large font size

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(thankYouLabel);

        this.add(centerPanel, BorderLayout.CENTER);

        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
