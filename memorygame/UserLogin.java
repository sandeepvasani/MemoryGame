

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//greeting window
class UserLogin extends JFrame implements ActionListener
{
	JButton buttnSubmit;
 	JLabel lblName, lblLevel,lblName1,lblName2,lblName3,lblName4,lblDev;
	JRadioButton rbuttn1, rbuttn2, rbuttn3;
 	static JTextField txtName;
	static int rpress=0;
 
 	UserLogin()
 	{
  		setTitle("Login");
		initComponents();
  		setSize(430, 400);
  		setVisible(true);
		setResizable(false);
  		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 	}

 	void initComponents()
 	{
	//make components
  		txtName  = new JTextField();
  		lblName = new JLabel("Enter Your Name");
  		lblLevel = new JLabel("Levels");
		lblDev=new JLabel("Developed by-");
		lblName1=new JLabel("Swapnil Jadhav");
		lblName2=new JLabel("Sandeep Vasani");
		lblName3=new JLabel("Ashish Tajane");
		lblName4=new JLabel("Ishwar Sultania");
		Font f = new Font("Comic Sans MS", Font.BOLD, 28);
  		buttnSubmit = new JButton("Submit");
		rbuttn1 = new JRadioButton("Easy");
		rbuttn2 = new JRadioButton("Hard");
		rbuttn3 = new JRadioButton("Expert");
  	
	//put components in window
  		add(txtName);
  		add(lblName);
		add(lblName1);
		add(lblName2);
		add(lblName3);
		add(lblName4);
		add(lblDev);
  		add(lblLevel);
		add(buttnSubmit);
		add(rbuttn1);
		add(rbuttn2);
		add(rbuttn3);

  	
	//arrange components  
  		setLayout(null); //manual arrangement of components
  		
  		lblName.setBounds(70,50, 150, 30);
  		txtName.setBounds(210,50, 150, 30);
  		lblLevel.setBounds(150,130, 100, 30);
		lblDev.setBounds(310,200, 420, 30);

		lblName1.setBounds(310,230,420,30);
		lblName2.setBounds(310,260,420,30);
		lblName3.setBounds(310,290,420,30);

		lblName4.setBounds(310,320,420,30);



		rbuttn1.setBounds(150,170,100,30);
		rbuttn2.setBounds(150,210,100,30);
		rbuttn3.setBounds(150,250,100,30);
		buttnSubmit.setBounds(150,330, 100, 30);

	//forming groups
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbuttn1);
		bg.add(rbuttn2);
		bg.add(rbuttn3);
    		
	//associate bttns with event procedure
  		buttnSubmit.addActionListener(this);
		rbuttn1.addActionListener(this);
		rbuttn2.addActionListener(this);
		rbuttn3.addActionListener(this);
   	}
 
 	public void actionPerformed(ActionEvent ae)
 	{
  		Object src;
		src = ae.getSource();
		
		if(src.equals(rbuttn1))
			rpress = 1;
		else if(src.equals(rbuttn2))
			rpress = 2;
		else if(src.equals(rbuttn3))
			rpress = 3;
		
		if(src.equals(buttnSubmit))
		{
			int ret = uNValidation();
			if(ret == 0)
				return;
			
			int ret1 = rBValidation();
			if(ret1 == 0)
				return;
			
			switch(rpress)
			{
				case 1: 
					MemoryGameA.main(null);
					break;
				case 2:
					MemoryGameB.main(null);
					break;
				case 3:
					MemoryGameC.main(null);
			}
			dispose();
		}
  	}

	int uNValidation()
	{
		String name = txtName.getText();
		if(name.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Username Missing");
			return 0;
		}
		
		return 1;	
	}

	int rBValidation()
	{
		if(rpress == 0)
		{
			JOptionPane.showMessageDialog(this, "Select one of the Level");
			return 0;
		}
		return 1;
	}	

	public static void main(String args[])
 	{
  		UserLogin g = new UserLogin();
	}
}



