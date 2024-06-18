import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Concert extends JFrame implements ActionListener {
    JButton b;
    JPanel mainP;
    JPanel p1;

    //Header
    JPanel head;
    JLabel headLab;

    //Buttons
    java.util.List<JButton> buttons;

    Concert() {
        head = new JPanel();
        mainP = new JPanel();
        headLab = new JLabel();

        head.setLayout(new FlowLayout(FlowLayout.LEFT));

        headLab.setText("BPSU Concert");
        headLab.setFont(new Font(null,Font.PLAIN,50));

        mainP.setBackground(new Color(204,102,0));
        mainP.setLayout(new FlowLayout());
        mainP.setPreferredSize(new Dimension(0,2500));

        buttons = new java.util.ArrayList<>();
        this.setLayout(new BorderLayout());
        this.setSize(1900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JScrollPane scroller = new JScrollPane(mainP);

        head.add(headLab);
        head.setPreferredSize(new Dimension(1000,80));
        head.setBackground(Color.PINK);

        //add to Frame
        this.add(head,BorderLayout.NORTH);
        this.add(scroller, BorderLayout.CENTER);




    }

    public void setComp(String title, String loc) {

        p1 = new JPanel();

        b = new JButton();
        b.setText("Buy Tickets");
        b.addActionListener(this);
        b.setPreferredSize(new Dimension(250,40));

        b.setFocusable(false);

        buttons.add(b);


        ImageIcon img = new ImageIcon(loc);
        Image resized = img.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resized);

        JLabel label = new JLabel();
        label.setFont(new Font(null,Font.PLAIN,20));
        label.setText(title);
        label.setIcon(image);
        label.setSize(200, 300);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);


        p1.setPreferredSize(new Dimension(400,500));
        //Add to Panel
        p1.add(label);

        p1.add(b);
        mainP.add(p1);


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