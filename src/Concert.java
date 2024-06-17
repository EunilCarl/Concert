import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Concert extends JFrame implements ActionListener {
    JButton b;

    Concert() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void setComp(String title, String loc) {
        b = new JButton();
        b.setText("Buy Tickets");
        b.addActionListener(this);

        JPanel p = new JPanel();
        p.setBackground(Color.red);
        p.setBounds(0,0,250,250);
        ImageIcon img = new ImageIcon(loc);
        Image resized = img.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        //JLabel imgLabel = new JLabel();
        JLabel label = new JLabel();
        label.setText(title);
        label.setIcon(image);
        label.setSize(200, 300);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        // Add to Label


        // Add to Frame
        this.add(label);
        this.add(b);




        // Revalidate and repaint the frame to update the UI
        this.revalidate();
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
            new Buy();
        }
    }
}
