import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Account.*;

public class Login extends JFrame implements MouseListener, ActionListener {

  private JPanel panel;
  private ImageIcon img;
  private Color color1;
  private JLabel label1, label2, label3, label7, label6;
  private JTextField txt1;
  private JPasswordField pf;
  private JCheckBox rememberMe;
  private JButton btnLogin, exit, btnSignUp;
  private ImageIcon bg1;

  public Login() {
    super("Login");
    super.setBounds(640, 160, 640, 760);
    color1 = new Color(135, 206, 235);
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(color1);

    label1 = new JLabel("  Login");
    label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
    label1.setBounds(270, 310, 105, 50);
    label1.setOpaque(true);
    panel.add(label1);

    label2 = new JLabel("Username:");
    label2.setBounds(160, 401, 80, 30);
    panel.add(label2);

    txt1 = new JTextField();
    txt1.setBounds(260, 410, 200, 20);
    panel.add(txt1);

    label3 = new JLabel("Password:");
    label3.setBounds(160, 441, 80, 30);
    panel.add(label3);

    pf = new JPasswordField();
    pf.setBounds(260, 450, 200, 20);
    pf.setEchoChar('*');
    panel.add(pf);

    rememberMe = new JCheckBox("Remember Password");
    rememberMe.setBounds(260, 481, 200, 30);
    rememberMe.setBackground(Color.WHITE);
    panel.add(rememberMe);

    exit = new JButton("Exit");
    exit.setBounds(530, 10, 80, 25);
    exit.addActionListener(this);
    exit.addMouseListener(this);
    panel.add(exit);

    btnLogin = new JButton("Login");
    btnLogin.setBounds(365, 525, 90, 20);
    btnLogin.addActionListener(this);
    panel.add(btnLogin);

    btnSignUp = new JButton("Sign Up");
    btnSignUp.setBounds(260, 525, 90, 20);
    btnSignUp.addActionListener(this);
    panel.add(btnSignUp);

    bg1 = new ImageIcon("b8c4.png");
    label6 = new JLabel(bg1);
    label6.setBounds(-80, 180, 800, 600);
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
        if(me.getSource() == exit)
		{
			exit.setText("Confirm");
		}
     }
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == exit)
		{
			exit.setText("Exit");
		}
     }
    public void actionPerformed(ActionEvent me) 
    {
        if (me.getSource() == exit) 
        {
            System.exit(0);
        }
        else if(me.getSource() == btnLogin && txt1.getText().equals("admin") && pf.getText().equals("admin"))
        {
            Main obj1 = new Main();
			obj1.setVisible(true);
			this.setVisible(false);
        }
        else if(me.getSource() == btnLogin && txt1.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please enter a proper username!");
        }
        else if(me.getSource() == btnSignUp)
		{
			RegistrationWindow obj1 = new RegistrationWindow();
			obj1.setVisible(true);
			this.setVisible(false);
		}
        else if(me.getSource() == btnLogin)
        {
            String s1, s2;
			s1 = txt1.getText(); 
			s2 = pf.getText(); 
            Account acc = new Account();
            if (!acc.validAccount(s1, s2)) 
            {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            } 
            else 
            {
                Ticket obj1 = new Ticket(s1, s2);
                obj1.setVisible(true);
                this.setVisible(false);
            }
            
        }
    }   
}