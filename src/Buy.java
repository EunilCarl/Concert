import javax.swing.*;
import java.awt.*;

public class Buy extends JFrame {

    Buy(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        JLabel l = new JLabel();
        l.setText("panget mo ralph");
        this.add(l);
    }



}