import javax.swing.*;
import java.awt.*;

public class Concert extends JFrame {
    public String title;
    public String loc;

    Concert(){
        this.title = title;
    }

    Concert(String title, String loc){

        ImageIcon img = new ImageIcon(loc);
        Image resized = img.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        JLabel imgLabel = new JLabel();
        JLabel label = new JLabel();
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        label.setText(title);
        label.setSize(100,100);


       imgLabel.setSize(100,100);
        imgLabel.setIcon(image);


        //add to Frame
        this.add(label);
        this.add(imgLabel);



        this.setSize(1800,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);







    }

}
