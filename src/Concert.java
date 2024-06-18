import javax.imageio.ImageIO;
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
        mainP = new JPanel();

        JPanel head = Header.headerPanel("BPSU Konex");

        mainP.setLayout(new FlowLayout());
        mainP.setPreferredSize(new Dimension(0, 2000));

        buttons = new java.util.ArrayList<>();
        buttonTitleMap = new HashMap<>();
        buttonLocMap = new HashMap<>();

        this.setLayout(new BorderLayout());
        //import header component
        this.add(head, BorderLayout.NORTH);
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scroller = new JScrollPane(mainP);
        this.add(scroller, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setComp(String title, String loc) {
        JPanel p1 = new JPanel();
        JButton b = new JButton();
        b.setText("Buy Tickets");
        b.addActionListener(this);
        b.setPreferredSize(new Dimension(250, 45));
        b.setFocusable(false);
        b.setBackground(new Color(240,133,133));
        b.setForeground(Color.WHITE);
       b.setBorder(BorderFactory.createEmptyBorder());

        buttons.add(b);
        buttonTitleMap.put(b, title);
        buttonLocMap.put(b, loc);

        ImageIcon img = new ImageIcon(loc);
        Image resized = img.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        JLabel label = new JLabel();
        label.setFont(new Font(null, Font.PLAIN, 13));
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

        // to update the UI
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String title = buttonTitleMap.get(sourceButton);
        String loc = buttonLocMap.get(sourceButton);
        new Buy(this, title, loc);

    }
}
