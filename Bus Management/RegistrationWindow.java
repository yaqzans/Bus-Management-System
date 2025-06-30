import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Account.*;

public class RegistrationWindow extends JFrame implements MouseListener, ActionListener {

    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private Color color1;
    private Font f1;
    private JTextField txt1, txt2;
    private ButtonGroup bg;
    private JRadioButton rb1, rb2;
    private JPasswordField pf;
    private JButton bt1, bt2, bt3;
    private ImageIcon bg1, img;

    public RegistrationWindow() {
        super("Registration");
        super.setBounds(640, 160, 640, 760);
        color1 = new Color(135, 206, 235);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color1);

        label1 = new JLabel("   Create a new account!");
        label1.setBounds(160, 330, 320, 50);
        label1.addMouseListener(this);
        panel.add(label1);
        f1 = new Font("Times New Roman", Font.BOLD, 30);
        label1.setFont(f1);
        label1.setOpaque(true);

        label2 = new JLabel("Name:");
        label2.setBounds(190, 400, 80, 60); 
        panel.add(label2);
        txt1 = new JTextField();
        txt1.setBounds(290, 420, 150, 20); 
        panel.add(txt1);

        label3 = new JLabel("Email:");
        label3.setBounds(190, 445, 80, 60); 
        panel.add(label3);
        txt2 = new JTextField();
        txt2.setBounds(290, 465, 150, 20); 
        panel.add(txt2);

        label4 = new JLabel("Gender:");
        label4.setBounds(190, 490, 80, 60); 
        panel.add(label4);
        rb1 = new JRadioButton("Male");
        rb1.setBounds(290, 510, 60, 30); 
        panel.add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(360, 510, 80, 30); 
        panel.add(rb2);
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        label5 = new JLabel("Password:");
        label5.setBounds(190, 535, 80, 60); 
        panel.add(label5);
        pf = new JPasswordField();
        pf.setBounds(290, 555, 150, 20); 
        panel.add(pf);

        bt1 = new JButton("Submit");
        bt1.setBounds(360, 595, 80, 20); 
        bt1.addActionListener(this);
        panel.add(bt1);

        bt2 = new JButton("Exit");
        bt2.setBounds(290, 595, 65, 20); 
        bt2.addActionListener(this);
        panel.add(bt2);

        bt3 = new JButton("Log In");
        bt3.setBounds(290, 625, 150, 20); 
        bt3.addActionListener(this);
        panel.add(bt3);

        bg1 = new ImageIcon("b8c434.png"); 
        label6 = new JLabel(bg1);
        label6.setBounds(170, 260, 300, 550);
        panel.add(label6);

        img = new ImageIcon("logo1.png");
        label7 = new JLabel(img);
        label7.setBounds(120, -40, 400, 400);
        panel.add(label7);

        super.add(panel);
    }

    public void mouseClicked(MouseEvent me) { }
    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) {
        if(me.getSource() == label1)
		{
			label1.setText("         Register Now!");
		}
     }
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == label1)
		{
			label1.setText("   Create a new account!");
		}
     }

    public void actionPerformed(ActionEvent me) 
    { 
        if(me.getSource() == bt2)
        {
            System.exit(0);
        }
        else if(me.getSource() == bt3)
        {
            Login obj1 = new Login();
            obj1.setVisible(true);
            this.setVisible(false);
        }
        else if(me.getSource() == bt1 && txt1.getText().isEmpty() || me.getSource() == bt1 && txt2.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter your credentials!");
        }
        else if(me.getSource() == bt1 && !rb1.isSelected() && !rb2.isSelected()) 
        {
            JOptionPane.showMessageDialog(this, "Please select your gender!");
        }
        else if(me.getSource() == bt1 && pf.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please choose a password!");
        }
        else if(me.getSource() == bt1) 
        {
            String s1, s2, s3, s4;
            s1 = txt1.getText(); 
            s2 = txt2.getText(); 
            s3 = pf.getText(); 
            s4 = "";
            if(rb1.isSelected())
            {
                s4 = rb1.getText(); 
            }
            else if(rb2.isSelected())
            {
                s4 = rb2.getText(); 
            }
            Account acc = new Account(s1, s3);
            if(acc.checkAccount(s1) == true)
				{
					JOptionPane.showMessageDialog(this, "This username already exists");
				}
			else
				{
					acc.addAccount();
					JOptionPane.showMessageDialog(this, "Registration Successful");
					txt1.setText("");
                    txt2.setText("");
                    pf.setText("");
		
					Login obj1 = new Login();
					obj1.setVisible(true);
					this.setVisible(false);
				}
        }
    }
}