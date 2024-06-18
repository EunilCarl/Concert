import javax.swing.*;
import java.awt.*;

public class Header {
    public static JLabel headerLabel(String text) {
        JLabel headLab = new JLabel();
        headLab.setText(text);

        ImageIcon icon = new ImageIcon("BPSU.png");
        Image resized = icon.getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resized);
        headLab.setIcon(resizedIcon);
        headLab.setFont(new Font(null, Font.BOLD, 50));
        headLab.setForeground(Color.WHITE);

        return headLab;
    }

    public static JPanel headerPanel(String text) {
        JPanel head = new JPanel();
        JLabel headLab = headerLabel(text);

        head.setLayout(new FlowLayout(FlowLayout.CENTER));
        head.setPreferredSize(new Dimension(1000, 80));
        head.setBackground(new Color(240, 133, 133));
        head.add(headLab);

        return head;
    }
}
