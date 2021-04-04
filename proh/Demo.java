import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.sql.*; 
class Demo extends JFrame 
{
	JPanel heading;
	JPanel login = new JPanel();
	JTextField username = new JTextField("Enter Your Username");  
	JTextField password = new JTextField("Enter Password");
	JButton signup = new JButton("Sign Up");
    JButton reset = new JButton("RESET");


	Demo()
	{
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
        });



		signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				new Ref().setVisible(true);
	 
			}
		});
		Font f = new Font("Serif", Font.BOLD, 60); 
        
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,900,100);
		
        JLabel name = new JLabel("LOGIN");
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);


        
        login.setLayout(null);
        login.setSize(500,400);
        login.setBackground(new Color(0,0,0,60));
        login.setBounds(250,175,400,350);

           
        username.setBounds(50,50,300,50);
        username.setForeground(Color.WHITE);
        username.setBackground(new Color(210,180,140));
        login.add(username);


       // JPasswordField password = new JPasswordField();
        password.setBounds(50,150,300,50);
        password.setForeground(Color.WHITE);
        password.setBackground(new Color(210,180,140));
        login.add(password);


        signup.setBounds(50,250,100,50);
        signup.setBackground(new Color(160,182,45));
        login.add(signup);

        reset.setBounds(175,250,100,50);
        reset.setBackground(new Color(160,182,45));
        login.add(reset);
 


        JButton login_button = new JButton("Login");
        login_button.setBounds(300,250,100,50);
        login_button.setBackground(new Color(160,182,45));
        login.add(login_button);
        login_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{

                    conn c1 = new conn();
                    String u = username.getText();
                    String v = password.getText();
                    //System.out.println(u);
                    //System.out.println(v);

                    String q = "select * from registration where username='"+u+"' and password='"+v+"'";
                    //INSERT INTO userdata(username,password) values (u,v)
                    ResultSet rs = c1.s.executeQuery(q);
                    if (rs.next()) {  
                        String s = rs.getString(1);  
                        String s1 = rs.getString(2); 
                        //String q1 = "insert into userdata(username,password) values ('"+u+"','"+v+"');";     
                        //username.setText(s);  
                        //password.setText(s1);
                        
                         //System.out.println(s);
                         //System.out.println(s1);    
                     } else {  
                        //String q1 = "insert into userdata(username,password) values ('"+u+"','"+v+"');";
                        
                        new Ref().setVisible(true);
                              
                     }  
                    
                    
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });


		setSize(900,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon background_image = new ImageIcon("bg1.jpg");

		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

 

        background.add(login);
		background.add(heading);
		background.setBounds(0,0,900,600);
		add(background);
		setVisible(true);
	}
    

	public static void main(String args[])
	{
		new Demo();
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