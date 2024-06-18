import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

class Concert extends JFrame implements ActionListener {
    private JPanel mainP;
    private java.util.List<JButton> buttons;
    private Map<JButton, String> buttonTitleMap;
    private Map<JButton, String> buttonLocMap;

    Concert() {
        JPanel head = new JPanel();
        mainP = new JPanel();
        JLabel headLab = new JLabel();

        head.setLayout(new FlowLayout(FlowLayout.LEFT));
        headLab.setText("BPSU Concert");
        headLab.setFont(new Font(null, Font.BOLD, 50));

        mainP.setBackground(new Color(204, 102, 0));
        mainP.setLayout(new FlowLayout());
        mainP.setPreferredSize(new Dimension(0, 2500));

        buttons = new java.util.ArrayList<>();
        buttonTitleMap = new HashMap<>();
        buttonLocMap = new HashMap<>();

        this.setLayout(new BorderLayout());
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JScrollPane scroller = new JScrollPane(mainP);

        head.add(headLab);
        head.setPreferredSize(new Dimension(1000, 80));
        head.setBackground(Color.PINK);

        // Add to Frame
        this.add(head, BorderLayout.NORTH);
        this.add(scroller, BorderLayout.CENTER);
    }

    public void setComp(String title, String loc) {
        JPanel p1 = new JPanel();
        JButton b = new JButton();
        b.setText("Buy Tickets");
        b.addActionListener(this);
        b.setPreferredSize(new Dimension(250, 40));
        b.setFocusable(false);

        buttons.add(b);
        buttonTitleMap.put(b, title);
        buttonLocMap.put(b, loc);

        ImageIcon img = new ImageIcon(loc);
        Image resized = img.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        JLabel label = new JLabel();
        label.setFont(new Font(null, Font.PLAIN, 15));
        label.setText(title);
        label.setIcon(image);
        label.setSize(100, 300);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        p1.setPreferredSize(new Dimension(300, 500));
        p1.setBackground(null);

        // Add to Panel
        p1.add(label);
        p1.add(b);
        mainP.add(p1);

        // Add to Frame

        // to update the UI
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String title = buttonTitleMap.get(sourceButton);
        String loc = buttonLocMap.get(sourceButton);
        new Buy(title, loc);
    }
}
