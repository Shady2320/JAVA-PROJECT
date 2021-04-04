import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;
class Ref extends JFrame
{
    JPanel heading;
    JPanel regform = new JPanel();
    JTextField username = new JTextField("Enter Your Username");
    JTextField password = new JTextField("Enter your Password");
    JTextField name = new JTextField("Enter your name");
    JButton submit = new JButton("SUBMIT");
    JButton reset = new JButton("RESET");



	Ref()
	{
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
				name.setText("");
			}
        });




        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try{

            conn c1 = new conn();
            String u = username.getText();
            String v = password.getText();
            String w = name.getText();
            System.out.println(u);
            System.out.println(v);
            System.out.println(w);

            
            //String q = "select * from login where username='"+u+"' and password='"+v+"'";
            String q = "insert into registration(username,password,name) values ('"+u+"','"+v+"','"+w+"');";

            
            int rs = c1.s.executeUpdate(q);
            System.out.println(rs);
            /* 
            if(rs.next()){
                new details().f.setVisible(true);
                f.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
            */
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                 
            }
        });


        Font f = new Font("Serif", Font.BOLD, 60); 
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,900,100);
        JLabel high = new JLabel("REGISTRATION FORM");
        high.setForeground(Color.WHITE);
        high.setFont(f);
        heading.add(high);


        
        regform.setLayout(null);
        regform.setSize(400,350);
        regform.setBackground(new Color(0,0,0,60));
        regform.setBounds(250,175,400,350);

        
        username.setBounds(50,50,300,50);
        username.setForeground(Color.WHITE);
        username.setBackground(new Color(210,180,140));
        regform.add(username);


        //JPasswordField password = new JPasswordField();
        password.setBounds(50,120,300,50);
        password.setForeground(Color.WHITE);
        password.setBackground(new Color(210,180,140));
        regform.add(password);


        
        name.setBounds(50,190,300,50);
        name.setForeground(Color.WHITE);
        name.setBackground(new Color(210,180,140));
        regform.add(name);


        
        submit.setBounds(50,250,100,50);
        submit.setBackground(new Color(160,182,45));
        regform.add(submit);

        reset.setBounds(250,250,100,50);
        reset.setBackground(new Color(160,182,45));
        regform.add(reset);


        


	setSize(900,600);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	ImageIcon background_image = new ImageIcon("tt7.jpg");

	Image img = background_image.getImage();
	Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
	background_image = new ImageIcon(temp_img);
	JLabel background = new JLabel("", background_image, JLabel.CENTER);

 

        background.add(regform);
	background.add(heading);
	background.setBounds(0,0,900,600);
	add(background);
	setVisible(true);
	}
    
	public static void main(String args[])
	{
		new Ref();
    }
}
class conn{
    
    public Connection c;
    public Statement s;
 
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
