import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Main {
    public static void main(String[] args){

        JFrame f = new JFrame();
        JLabel l = new JLabel();
        JButton b = new JButton();

        l.setText("Lhance tuazon");
        b.setText("Okay");

        f.add(l);
        f.add(b);

        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
