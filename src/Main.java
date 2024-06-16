import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
public class Main {
    public static void main(String[] args){

                JButton button = new JButton();
                button.setBounds(640, 600,100,30);
                button.setFocusable(false);
                button.setText("Click me");


                ImageIcon image = new ImageIcon("BPSU.png");
                ImageIcon pic = new ImageIcon("2024 - Copy.png");

                JLabel label = new JLabel();
                label.setText(" Wala pong pasok sa mga papubliko at prebadong paaralan");
                label.setIcon(pic);

                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.BOTTOM);

                label.setFont(new Font("Berlin Sans FB Demi",Font.BOLD,20));
                label.setIconTextGap(30);

                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);


                JFrame frame = new JFrame();
                frame.setVisible(true);
                frame.setSize(500, 500);
                frame.setTitle("Practice 101");
                frame.add(button);
                frame.add(label);




                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setIconImage(image.getImage());
                frame.getContentPane().setBackground(Color.gray);


            }
        }
