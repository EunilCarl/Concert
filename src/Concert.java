import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Concert extends JFrame implements ActionListener {
    JButton b;
    JPanel p;
    JPanel p1;
    JPanel head;
    java.util.List<JButton> buttons;

    Concert() {
        head = new JPanel();
        p = new JPanel();
        p1 = new JPanel();

        
        p.setBackground(new Color(204,102,0));
        p.setPreferredSize(new Dimension(500,800));
        p.setLayout(new FlowLayout());
        p.add(p1);


        buttons = new java.util.ArrayList<>();
        this.setLayout(new BorderLayout());
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(p, BorderLayout.SOUTH);

    }

    public void setComp(String title, String loc) {


        b = new JButton();
        b.setText("Buy Tickets");
        b.addActionListener(this);
        b.setFocusable(false);

        buttons.add(b);


        ImageIcon img = new ImageIcon(loc);
        Image resized = img.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        //JLabel imgLabel = new JLabel();
        JLabel label = new JLabel();
        label.setFont(new Font(null,Font.PLAIN,25));
        label.setText(title);
        label.setIcon(image);
        label.setSize(200, 300);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        //Add to Panel
        p1.add(label);
        p1.add(b);

        // Add to Frame

        //to update the UI
        this.revalidate();
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton button : buttons){
            if(e.getSource()== button){
                this.dispose();
                new Buy();
                break;
            }
        }

    }
}
