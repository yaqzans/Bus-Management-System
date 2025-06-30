import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  Main extends JFrame implements ActionListener {

    private JPanel panel1, panel2;
    private ImageIcon bg1;
    private Color color1;
    private JLabel label1, label2, label3, label4, label5, label6;
    private JButton btn1, btn2, btn3, btn4, btn5;

    public  Main() {
        super("Main");
        super.setBounds(320, 180, 1280, 720);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        color1 = new Color(135, 206, 235);

        JLayeredPane layeredPane = new JLayeredPane();
        super.add(layeredPane);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(color1);
        panel1.setSize(1280, 60);
        panel1.setOpaque(true);
        label1 = new JLabel("       Welcome Back Admin!");  
        label1.setFont(new Font("Arial", Font.BOLD, 12)); 
        label1.setBounds(10, 10, 180, 40); 
        label1.setOpaque(true);
        panel1.add(label1);
        btn1 = new JButton("Back");
        btn1.setBounds(1145, 10, 105, 40); 
        btn1.addActionListener(this);
        panel1.add(btn1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        panel2.setSize(1280, 760);

        bg1 = new ImageIcon("t3.png"); 
        label2 = new JLabel(bg1);
        label2.setBounds(30, 80, 1200, 300);
        panel2.add(label2);
        
        bg1 = new ImageIcon("1a.png"); 
        label3 = new JLabel(bg1);
        label3.setBounds(30, 385, 200, 201);
        panel2.add(label3);
        bg1 = new ImageIcon("2a.png"); 
        label4 = new JLabel(bg1);
        label4.setBounds(360, 385, 200, 201);
        panel2.add(label4);
        bg1 = new ImageIcon("3a.png"); 
        label5 = new JLabel(bg1);
        label5.setBounds(700, 385, 200, 201);
        panel2.add(label5);
        bg1 = new ImageIcon("4a.png"); 
        label6 = new JLabel(bg1);
        label6.setBounds(1030, 385, 200, 201);
        panel2.add(label6);

        btn2 = new JButton("Kustia");
        btn2.setBounds(75, 590, 105, 40); 
        btn2.addActionListener(this);
        panel2.add(btn2);
        btn3 = new JButton("Cumilla");
        btn3.setBounds(405, 590, 105, 40); 
        btn3.addActionListener(this);
        panel2.add(btn3);
        btn4 = new JButton("Chandpur");
        btn4.setBounds(745, 590, 105, 40);
        btn4.addActionListener(this); 
        panel2.add(btn4);
        btn5 = new JButton("Tangail");
        btn5.setBounds(1075, 590, 105, 40); 
        btn5.addActionListener(this);
        panel2.add(btn5);
        
        super.add(panel1);
        super.add(panel2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent me) 
        { 
            if(me.getSource() == btn1)
            {
                Login obj1 = new Login();
                obj1.setVisible(true);
                this.setVisible(false);
		    }
            else if(me.getSource() == btn2)
            {
                Passenger1 obj1 = new Passenger1();
                obj1.setVisible(true);
                this.setVisible(false);
            }
            else if(me.getSource() == btn3)
            {
                Passenger2 obj1 = new Passenger2();
                obj1.setVisible(true);
                this.setVisible(false);
            }
            else if(me.getSource() == btn4)
            {
                Passenger3 obj1 = new Passenger3();
                obj1.setVisible(true);
                this.setVisible(false);
            }
            else if(me.getSource() == btn5)
            {
                Passenger4 obj1 = new Passenger4();
                obj1.setVisible(true);
                this.setVisible(false);
            }
        }
}