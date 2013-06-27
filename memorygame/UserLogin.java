package memorygame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


//greeting window
class UserLogin extends JFrame implements  ActionListener
{
	JButton bttnSubmit;
 	JLabel lblName;
 	JTextField txtName;
 
 	UserLogin()
 	{
  		setTitle("Login");
		initComponents();
  		setSize(430, 300);
  		setVisible(true);
		setResizable(false);
  		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 	}

 	void initComponents()
 	{
	//make components
  		txtName  = new JTextField();
  		lblName = new JLabel("Enter Your Name");
  		Font f = new Font("Comic Sans MS", Font.BOLD, 28);
  		bttnSubmit = new JButton("Submit");
  	
	//put components in window
  		add(txtName);
  		add(lblName);
  		add(bttnSubmit);
  	
	//arrange components  
  		setLayout(null); //manual arrangement of components
  		
  		lblName.setBounds(50,30, 150, 30);
  		txtName.setBounds(230,30, 150, 30);
  		bttnSubmit.setBounds(150,90, 100, 30);
    		
	//associate bttns with event procedure
  		bttnSubmit.addActionListener(this);
		
   	}
 		
 	
	public void actionPerformed(ActionEvent e)
 	{
  		Wait.manySec(3);
	//calling main of MemoryGame
		MemoryGame.main(null);
		dispose();
  	}


		


 	public static void main(String args[])
 	{
  		UserLogin g = new UserLogin();
	}
}


//playing window
class MemoryGame extends JFrame implements ActionListener, Runnable,KeyListener
{	
	JButton but,butn,butI[] = new JButton[16];
	ImageIcon iconOrg,icon[] = new ImageIcon[8];
	JLabel lblTotPress, lblTotPressVal, lblTime, lblCongrt ;
	static JLabel  lblTimeVal;
	Random r = new Random();
	int i[] = new int[17];
	int randomNo[] = new int[8];
	int butPress=0, totPress=0, time=0, score=0;
		
	MemoryGame()
	{
		initComponents();
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Memory Game");
	}
	
	void initComponents()
	{
		iconOrg = new ImageIcon("C:\\swap\\MemoryGame\\gray.bmp");
		
		icon[0] = new ImageIcon("C:\\swap\\MemoryGame\\car1.jpg");
		icon[1] = new ImageIcon("C:\\swap\\MemoryGame\\car2.jpg");
		icon[2] = new ImageIcon("C:\\swap\\MemoryGame\\car3.jpg");
		icon[3] = new ImageIcon("C:\\swap\\MemoryGame\\car4.jpg");
		icon[4] = new ImageIcon("C:\\swap\\MemoryGame\\car5.jpg");
		icon[5] = new ImageIcon("C:\\swap\\MemoryGame\\car6.jpeg");
		icon[6] = new ImageIcon("C:\\swap\\MemoryGame\\car7.jpeg");
		icon[7] = new ImageIcon("C:\\swap\\MemoryGame\\car8.jpg");
				
		//generating random number for random image generation
		for(int k=0 ; k<16 ; k++)
		{
			int rno = r.nextInt(8);
			randomNo[rno] += 1;
			if(randomNo[rno] <= 2)
				i[k] = rno;
			else
				k -= 1;
		}
				
		//make components
		but = new JButton();
		butn = new JButton();
		
		for(int j=0;j<16;j++)
			butI[j] = new JButton(iconOrg);
		
		lblTotPress = new JLabel("Number of Clicks:");
		
		Font f = new Font("Comic Sans MS", Font.BOLD, 20);
		lblTotPressVal = new JLabel("");
		lblTotPressVal.setFont(f);
  		lblTotPressVal.setForeground(Color.BLUE);
  		
		
		lblTime = new JLabel("Time:");
		lblTimeVal = new JLabel("");
		lblTimeVal.setFont(f);
  		lblTimeVal.setForeground(Color.BLUE);
  				
		lblCongrt = new JLabel("");
		lblCongrt.setFont(f);
  		lblCongrt.setForeground(Color.BLUE);
  		
		
		//put components in window
		for(int j=0;j<16;j++)
			add(butI[j]);
		add(lblTotPress);
		add(lblTotPressVal);
		add(lblTime);
		add(lblTimeVal);
		add(lblCongrt);
	
		//arrange components
		setLayout(null);
		int x=60,y=40;
		for(int j=0;j<16;j++)
		{
			if(j%4 == 0)
			{
				y += 80;
				x = 60;
			}	
			x += 80;
			butI[j].setBounds(x,y,60,60);
		}
		
		lblTotPress.setBounds(50,500,100,30);
		lblTotPressVal.setBounds(155,500,30,30);
		lblTime.setBounds(400,500,40,30);
		lblTimeVal.setBounds(445,500,60,30);
		lblCongrt.setBounds(100,250,350,50);
		lblCongrt.setVisible(false);
		
		//associate the event procedure
		for(int j=0;j<16;j++)
			butI[j].addActionListener(this);
			lblTime.setFocusable(true);
			lblTime.requestFocusInWindow(); 
			lblTime.addKeyListener(this);
							
	}
	
	public void keyTyped(KeyEvent e){System.out.println("ll");}
		
		public void keyReleased(KeyEvent e) {if(e.getKeyCode() == KeyEvent.VK_S)
             		{
             			System.out.println("ll");
             		
         		}}
		public void keyPressed(KeyEvent e) {System.out.println("ll");}

	
	public void actionPerformed(ActionEvent ae)
	{
		butPress++;
		String s;
					
		if(totPress == 0)
			DigitalClock.main(null);
		
		if(butPress == 1)
		{
			but = (JButton)ae.getSource();
			 
			if(ae.getSource() == butI[0])
				butI[0].setIcon(icon[i[0]]);
			
			else if(ae.getSource() == butI[1])
				butI[1].setIcon(icon[i[1]]);
			
			else if(ae.getSource() == butI[2])
				butI[2].setIcon(icon[i[2]]);
			
			else if(ae.getSource() == butI[3])
				butI[3].setIcon(icon[i[3]]);
			
			else if(ae.getSource() == butI[4])
				butI[4].setIcon(icon[i[4]]);
			
			else if(ae.getSource() == butI[5])
				butI[5].setIcon(icon[i[5]]);
			
			else if(ae.getSource() == butI[6])
				butI[6].setIcon(icon[i[6]]);
			
			else if(ae.getSource() == butI[7])
				butI[7].setIcon(icon[i[7]]);
			
			else if(ae.getSource() == butI[8]) 
				butI[8].setIcon(icon[i[8]]);
			
			else if(ae.getSource() == butI[9]) 
				butI[9].setIcon(icon[i[9]]);
			
			else if(ae.getSource() == butI[10]) 
				butI[10].setIcon(icon[i[10]]);
			
			else if(ae.getSource() == butI[11]) 
				butI[11].setIcon(icon[i[11]]);
			
			else if(ae.getSource() == butI[12]) 
				butI[12].setIcon(icon[i[12]]);
			
			else if(ae.getSource() == butI[13]) 
				butI[13].setIcon(icon[i[13]]);
			
			else if(ae.getSource() == butI[14])
				butI[14].setIcon(icon[i[14]]);
			
			else 
				butI[15].setIcon(icon[i[15]]);
			
			totPress++;
			s = totPress + " ";
			s = s.trim();
			lblTotPressVal.setText(s);
				
		}
		else if(butPress == 2)
		{
			butn = (JButton)ae.getSource();
			
			if(but != butn)
			{
				if(ae.getSource() == butI[0])
					butI[0].setIcon(icon[i[0]]);
				
				else if(ae.getSource() == butI[1])
					butI[1].setIcon(icon[i[1]]);
				
				else if(ae.getSource() == butI[2])
					butI[2].setIcon(icon[i[2]]);
				
				else if(ae.getSource() == butI[3])
					butI[3].setIcon(icon[i[3]]);
				
				else if(ae.getSource() == butI[4])
					butI[4].setIcon(icon[i[4]]);
				
				else if(ae.getSource() == butI[5])
					butI[5].setIcon(icon[i[5]]);
				
				else if(ae.getSource() == butI[6])
					butI[6].setIcon(icon[i[6]]);
				
				else if(ae.getSource() == butI[7])
					butI[7].setIcon(icon[i[7]]);
				
				else if(ae.getSource() == butI[8]) 
					butI[8].setIcon(icon[i[8]]);
				
				else if(ae.getSource() == butI[9]) 
					butI[9].setIcon(icon[i[9]]);
				
				else if(ae.getSource() == butI[10]) 
					butI[10].setIcon(icon[i[10]]);
				
				else if(ae.getSource() == butI[11]) 
					butI[11].setIcon(icon[i[11]]);
				
				else if(ae.getSource() == butI[12]) 
					butI[12].setIcon(icon[i[12]]);
				
				else if(ae.getSource() == butI[13]) 
					butI[13].setIcon(icon[i[13]]);
				
				else if(ae.getSource() == butI[14]) 
					butI[14].setIcon(icon[i[14]]);
				
				else 
					butI[15].setIcon(icon[i[15]]);
				
				butPress=0;
				totPress++;
				s = totPress + " ";
				s = s.trim();
				lblTotPressVal.setText(s);
				
								
				Thread thrd = new Thread(this);
				thrd.start();
			}
			else
				butPress-=1;
		}
	
	}

	public void run()
	{
		for(int j=0;j<16;j++)
			butI[j].removeActionListener(this);
		
		Wait.manySec(10);
		if(but.getIcon() == butn.getIcon())
		{
			but.setVisible(false);
			butn.setVisible(false);
		}
		else 
		{
			but.setIcon(iconOrg);
			butn.setIcon(iconOrg);
		}
		
		isVisibl();
		for(int j=0;j<16;j++)
			butI[j].addActionListener(this);
	}	
	
	void isVisibl()
	{
		int cnt=0;
		boolean vis;
		
		for(int j=0;j<16;j++)
		{
			vis = butI[j].isVisible();
			if(!vis)
				cnt++;
		}
		
		if(cnt == 16)
		{
			score();
			DigitalClock.flag = false;
			lblCongrt.setVisible(true);
			lblCongrt.setText("Congratulations you Scored :" + score);
		}
	}

	void score()
	{
		score = totPress;
		int rem = score % 16;
		score = score / 16;
		score = 100 / score - rem;
	}
	
	public static void main(String args[])
	{
		MemoryGame mg = new MemoryGame();	
	}
}					


