import javax.swing.*;
import java.awt.*;

public class Order extends JFrame {

    Order(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(1900, 1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE_ON_CLOSE
        this.setVisible(true);
        this.setResizable(false);
    }
}
