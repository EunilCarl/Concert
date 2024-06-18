import javax.swing.*;
import java.awt.*;

public class Buy extends JFrame {
    JPanel head;
    JLabel headLab;
    JButton cancel;
    JButton buy;

    Buy(String title, String loc){
        //header
        JPanel head = new JPanel();
        JLabel headLab = new JLabel();

        head.setLayout(new FlowLayout(FlowLayout.LEFT));
        headLab.setText(title);
        headLab.setFont(new Font(null, Font.PLAIN, 50));

        head.add(headLab);
        head.setPreferredSize(new Dimension(1000, 80));
        head.setBackground(Color.PINK);

        ImageIcon img = new ImageIcon(loc);
       // Image resized = img.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
       // ImageIcon image = new ImageIcon(resized);

        JLabel l = new JLabel();
        Image resized = img.getImage().getScaledInstance(650, 750, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        l.setIcon(image);
        this.add(l);
        // Add to Frame
        this.add(head, BorderLayout.NORTH);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        //JLabel l = new JLabel();
        //l.setText("panget mo ralph");
        //this.add(l);



    }



}