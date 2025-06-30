import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Pass.*;

public class Passenger1 extends JFrame implements ActionListener {

    private JPanel panel1, panel2;
    private ImageIcon bg1;
    private Color color1, color2;
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JButton btn1, btn2, btn3;
    private JTextField txt1, txt2;

    public Passenger1() {
        super("Kustia");
        super.setBounds(640, 160, 640, 760);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        color1 = new Color(135, 206, 235);
        color2 = new Color(34, 82, 154);

        JLayeredPane layeredPane = new JLayeredPane();
        super.add(layeredPane);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(color2);
        panel1.setSize(640, 60);
        panel1.setOpaque(true);
        label1 = new JLabel("       Kustia");  
        label1.setFont(new Font("Arial", Font.BOLD, 12)); 
        label1.setBounds(10, 10, 105, 40); 
        label1.setOpaque(true);
        panel1.add(label1);
        btn1 = new JButton("Back");
        btn1.setBounds(505, 10, 105, 40); 
        btn1.addActionListener(this);
        panel1.add(btn1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(color1);
        panel2.setSize(640, 760);
        bg1 = new ImageIcon("bus3.png"); 
        label2 = new JLabel(bg1);
        label2.setBounds(35, 80, 550, 200);
        panel2.add(label2);

        label3 = new JLabel(" Add Passenger:");
        label3.setFont(new Font("Arial", Font.BOLD, 20)); 
        label3.setBounds(40, 340, 160, 30);
        label3.setForeground(color1);
		label3.setBackground(color2);
		label3.setOpaque(true);
        panel2.add(label3);

        label5 = new JLabel("Please enter the seat number:");
        label5.setFont(new Font("Arial", Font.BOLD, 20)); 
        label5.setBounds(40, 380, 300, 30);
        panel2.add(label5);
        label6 = new JLabel("Please enter the seat number:");
        label6.setFont(new Font("Arial", Font.BOLD, 20)); 
        label6.setBounds(40, 470, 300, 30);
        panel2.add(label6);

        txt1 = new JTextField();
        txt1.setBounds(330, 380, 50, 30); 
        panel2.add(txt1);
        txt2 = new JTextField();
        txt2.setBounds(330, 470, 50, 30); 
        panel2.add(txt2);


        label4 = new JLabel(" Remove Passenger:");
        label4.setFont(new Font("Arial", Font.BOLD, 20)); 
        label4.setBounds(40, 430, 200, 30);
        label4.setForeground(color1);
		label4.setBackground(color2);
		label4.setOpaque(true);
        panel2.add(label4);

        label7 = new JLabel(" Select an option:");
        label7.setFont(new Font("Arial", Font.BOLD, 20)); 
        label7.setBounds(40, 520, 175, 30);
        label7.setForeground(color1);
		label7.setBackground(color2);
		label7.setOpaque(true);
        panel2.add(label7);
        btn2 = new JButton("Add");
        btn2.setBounds(140, 570, 85, 50); 
        btn2.addActionListener(this);
        panel2.add(btn2);
        btn3 = new JButton("Remove");
        btn3.setBounds(40, 570, 85, 50); 
        btn3.addActionListener(this);
        panel2.add(btn3);

        super.add(panel1);
        super.add(panel2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent me) 
    { 
        if(me.getSource() == btn1)
        {
            Main obj1 = new Main();
            obj1.setVisible(true);
            this.setVisible(false);
        }
        else if(me.getSource() == btn2)
        {
            if (txt1.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "No seat to add!");
            } 
            else 
            {
                int seatNumber = Integer.parseInt(txt1.getText());
                if (seatNumber < 1 || seatNumber > 20)
                {
                    JOptionPane.showMessageDialog(this, "Please enter a valid seat number (1-20)!");
                } 
                else
                {
                    String s1 = txt1.getText();
                    Pass1 acc1 = new Pass1(s1);
                    if(acc1.checkSeat(s1)) 
                    {
                        JOptionPane.showMessageDialog(this, "This seat is taken!");
                    } 
                    else 
                    {
                        acc1.addSeat();
                        JOptionPane.showMessageDialog(this, "Your seat is now confirmed!");
                        txt1.setText("");
                    }
                }
            }
        }
        else if(me.getSource() == btn3)
        {
            if (txt2.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "No seat to remove!");
            } 
            else 
            {
                int seatNumber = Integer.parseInt(txt2.getText());
                if (seatNumber < 1 || seatNumber > 20)
                {
                    JOptionPane.showMessageDialog(this, "Please enter a valid seat number (1-20)!");
                } 
                else
                {
                    String s1 = txt2.getText();
                    Pass1 acc1 = new Pass1(s1);
                    if(acc1.checkSeat(s1)) 
                    {
                        acc1.removeSeat(s1);
                        JOptionPane.showMessageDialog(this, "The seat has been removed!");
                        txt2.setText("");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(this, "No passenger booked this seat!");
                    }
                }
            }
        }
    }
}