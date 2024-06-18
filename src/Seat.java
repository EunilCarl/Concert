import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Seat extends JFrame {
    private static final int ROWS = 10;
    private static final int COLS = 20;
    private static final int MAX_SELECTION = 3;
    private Set<String> selectedSeats = new HashSet<>();
    private JLabel selectedSeatsLabel;
    private String tier;

    public Seat(String tier) {
        JPanel head = Header.headerPanel("BPSU Konex");
        this.add(head, BorderLayout.NORTH);

        this.tier = tier;
        JPanel headTier = headerPanel("BPSU Konex - " + tier);
        JPanel footer = footerPanel();

        JPanel seatsPanel = new JPanel(new GridLayout(ROWS, COLS));
        seatsPanel.setBackground(Color.BLACK);
        for (int i = 1; i <= ROWS; i++) {
            for (int j = 1; j <= COLS; j++) {
                JButton seatButton = new JButton();
                seatButton.setBackground(Color.PINK);
                seatButton.setPreferredSize(new Dimension(20, 20)); // Smaller seat size
                seatButton.addActionListener(new SeatButtonActionListener(i, j, seatButton));
                seatsPanel.add(seatButton);
            }
        }

        JPanel container = new JPanel(new BorderLayout());
        container.add(headTier, BorderLayout.NORTH);
        container.add(seatsPanel, BorderLayout.CENTER);
        container.add(footer, BorderLayout.SOUTH);

        this.add(container);
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel headerPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        return panel;
    }

    private JPanel footerPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        selectedSeatsLabel = new JLabel("Selected Seats: 0");
        selectedSeatsLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton confirmButton = new JButton("Confirm Selection");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmButton.setBackground(Color.PINK);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.addActionListener(e -> new Receipt(selectedSeats, tier));

        panel.add(selectedSeatsLabel);
        panel.add(confirmButton);
        return panel;
    }

    private void updateSelectedSeatsLabel() {
        selectedSeatsLabel.setText("Selected Seats: " + selectedSeats.size() + " - " + selectedSeats);
    }

    private class SeatButtonActionListener implements ActionListener {
        private final int row;
        private final int col;
        private final JButton seatButton;

        public SeatButtonActionListener(int row, int col, JButton seatButton) {
            this.row = row;
            this.col = col;
            this.seatButton = seatButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String seat = "Row " + row + " Seat " + col;
            if (selectedSeats.contains(seat)) {
                selectedSeats.remove(seat);
                seatButton.setBackground(Color.PINK);
            } else if (selectedSeats.size() < MAX_SELECTION) {
                selectedSeats.add(seat);
                seatButton.setBackground(Color.GRAY);
            }
            updateSelectedSeatsLabel();
        }
    }

}
