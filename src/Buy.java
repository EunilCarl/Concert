import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Second after the Main or Homepage
public class Buy extends JFrame implements ActionListener {
    JButton order;
    JButton cancel;
    JFrame main;

    Buy(JFrame main, String title, String loc, String desc, String date, String place) {
        this.setLayout(new BorderLayout());
        this.setSize(1900, 1000);

        JPanel head = Header.headerPanel("BPSU Konex");
        JPanel footer = new JPanel();
        JPanel container = new JPanel(new BorderLayout());

        this.main = main;
        this.add(head, BorderLayout.NORTH);
        main.setVisible(false);

        // header
        cancel = new JButton();
        order = new JButton();

        JLabel t = new JLabel();
        t.setText(title);
        t.setFont(new Font(null, Font.PLAIN, 60));

        ImageIcon img = new ImageIcon(loc);
        JLabel l = new JLabel();
        Image resized = img.getImage().getScaledInstance(650, 750, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);
        l.setIcon(image);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JLabel descLabel = new JLabel("<html>" + desc + "</html>"); // Use HTML to preserve line breaks
        descLabel.setMaximumSize(new Dimension(500, 400)); // Set maximum size for description label
        JLabel dateLabel = new JLabel("Date: " + date);
        JLabel placeLabel = new JLabel("Venue: " + place);

        descLabel.setFont(new Font(null, Font.PLAIN, 25));
        dateLabel.setFont(new Font(null, Font.PLAIN, 25));
        placeLabel.setFont(new Font(null, Font.PLAIN, 25));

        rightPanel.add(t);
        rightPanel.add(descLabel);
        rightPanel.add(dateLabel);
        rightPanel.add(placeLabel);

        cancel.setText("Cancel");
        cancel.addActionListener(this);
        order.setText("Buy Tickets");
        order.addActionListener(this);

        // to make the buttons prettier
        cancel.setPreferredSize(new Dimension(150, 45));
        cancel.setFocusable(false);
        cancel.setBackground(new Color(240, 133, 133));
        cancel.setForeground(Color.WHITE);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setFocusable(false);

        order.setPreferredSize(new Dimension(150, 45));
        order.setFocusable(false);
        order.setBackground(new Color(240, 133, 133));
        order.setForeground(Color.WHITE);
        order.setBorder(BorderFactory.createEmptyBorder());
        order.setFocusable(false);

        // Add to panel
        footer.setLayout(new FlowLayout(FlowLayout.TRAILING));
        footer.add(cancel);
        footer.add(order);
        container.add(l, BorderLayout.WEST);
        container.add(rightPanel, BorderLayout.CENTER);

        // Add to Frame
        this.add(head, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(container);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose(); // Close the Buy window
            main.setVisible(true); // Show the main frame
        } else if (e.getSource() == order) {
            new Order();
        }
    }
}