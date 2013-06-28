

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//playing window
class MemoryGameC extends JFrame implements ActionListener, Runnable
{
	JButton but,butn,butnQuit,butI[] = new JButton[24];
	static JButton butnPlayAgn;
	ImageIcon iconOrg,icon[] = new ImageIcon[12];
	JLabel lblTotPress, lblTotPressVal, lblTime, lblCongrt, lblContestant ;
	static JLabel  lblTimeVal;
	Random r = new Random();
	int i[] = new int[24];
	int randomNo[] = new int[12];
	int butPress=0, totPress=0, time=0, score=0;
	String name = UserLogin.txtName.getText();
		
	MemoryGameC()
	{
		initComponents();
		setSize(700,730);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		setTitle("Memory Game");
	}
	
	void initComponents()
	{
		iconOrg = new ImageIcon("images\\but.jpg");
		
		int rnum = r.nextInt(3);
		switch(rnum)
		{
			case 0:
				icon[0] = new ImageIcon("images\\car1.jpg");
				icon[1] = new ImageIcon("images\\car2.jpg");
				icon[2] = new ImageIcon("images\\car3.jpg");
				icon[3] = new ImageIcon("images\\car4.jpg");
				icon[4] = new ImageIcon("images\\car5.jpg");
				icon[5] = new ImageIcon("images\\car6.jpg");
				icon[6] = new ImageIcon("images\\car7.jpg");
				icon[7] = new ImageIcon("images\\car8.jpg");
				icon[8] = new ImageIcon("images\\car9.jpg");
				icon[9] = new ImageIcon("images\\car10.jpg");
				icon[10] = new ImageIcon("images\\car11.jpg");
				icon[11] = new ImageIcon("images\\car12.jpg");
				break;
			case 1:
				icon[0] = new ImageIcon("images\\s1.jpg");
				icon[1] = new ImageIcon("images\\s2.jpg");
				icon[2] = new ImageIcon("images\\s3.jpg");
				icon[3] = new ImageIcon("images\\s4.jpg");
				icon[4] = new ImageIcon("images\\s5.jpg");
				icon[5] = new ImageIcon("images\\s6.jpg");
				icon[6] = new ImageIcon("images\\s7.jpg");
				icon[7] = new ImageIcon("images\\s8.jpg");
				icon[8] = new ImageIcon("images\\s9.jpg");
				icon[9] = new ImageIcon("images\\s10.jpg");
				icon[10] = new ImageIcon("images\\s11.jpg");
				icon[11] = new ImageIcon("images\\s12.jpg");
				break;
			case 2:
				icon[0] = new ImageIcon("images\\p1.jpg");
				icon[1] = new ImageIcon("images\\p2.jpg");
				icon[2] = new ImageIcon("images\\p3.jpg");
				icon[3] = new ImageIcon("images\\p4.jpg");
				icon[4] = new ImageIcon("images\\p5.jpg");
				icon[5] = new ImageIcon("images\\p6.jpg");
				icon[6] = new ImageIcon("images\\p7.jpg");
				icon[7] = new ImageIcon("images\\p8.jpg");
				icon[8] = new ImageIcon("images\\p9.jpg");
				icon[9] = new ImageIcon("images\\p10.jpg");
				icon[10] = new ImageIcon("images\\p11.jpg");
				icon[11] = new ImageIcon("images\\p12.jpg");
		}		
		//generating random number for random image generation
		for(int k=0 ; k<24 ; k++)
		{
			int rno = r.nextInt(12);
			randomNo[rno] += 1;
			if(randomNo[rno] <= 2)
				i[k] = rno;
			else
				k -= 1;
		}
				
		//make components
		but = new JButton();
		butn = new JButton();
		butnPlayAgn = new JButton("PlayAgain!!!");
		butnQuit = new JButton("Quit");
		
		for(int j=0;j<24;j++)
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
  		
		lblContestant = new JLabel("");
		lblContestant.setFont(f);
		lblContestant.setForeground(Color.BLUE);
		
		//put components in window
		for(int j=0;j<24;j++)
			add(butI[j]);
		add(butnPlayAgn);
		add(butnQuit);
		add(lblTotPress);
		add(lblTotPressVal);
		add(lblTime);
		add(lblTimeVal);
		add(lblCongrt);
		add(lblContestant);
		
	
		//arrange components
		setLayout(null);
		int x=120,y=40;
		for(int j=0;j<24;j++)
		{
			if(j%4 == 0)
			{
				y += 80;
				x = 120;
			}	
			x += 80;
			butI[j].setBounds(x,y,60,60);
		}
		
		butnPlayAgn.setBounds(190,360,100,30);
		butnPlayAgn.setVisible(false);
		butnQuit.setBounds(310,360,100,30);
		butnQuit.setVisible(false);
		lblTotPress.setBounds(100,630,100,30);
		lblTotPressVal.setBounds(205,630,30,30);
		lblTime.setBounds(450,630,40,30);
		lblTimeVal.setBounds(495,630,60,30);
		lblContestant.setBounds(100,200,300,50);
		lblContestant.setVisible(false);
		lblCongrt.setBounds(100,250,400,50);
		lblCongrt.setVisible(false);
		
		//associate the event procedure
		for(int j=0;j<24;j++)
			butI[j].addActionListener(this);
		
		butnPlayAgn.addActionListener(this);
		butnQuit.addActionListener(this);				
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		butPress++;
		String s;
					
		if(totPress == 0)
			DigitalClock.main(null);
		
		if(butPress == 1)
		{
			but = (JButton)ae.getSource();
			 
			if(ae.getSource() == butnPlayAgn)
			{
				dispose();
				DigitalClock.flag = true;
				UserLogin.main(null);
				UserLogin.txtName.setText(name);
			}
			
			else if(ae.getSource() == butnQuit)
				dispose();
				
			else if(ae.getSource() == butI[0])
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
			
			else if(ae.getSource() == butI[15])
				butI[15].setIcon(icon[i[15]]);
		
			else if(ae.getSource() == butI[16])
				butI[16].setIcon(icon[i[16]]);

			else if(ae.getSource() == butI[17])
				butI[17].setIcon(icon[i[17]]);
		
			else if(ae.getSource() == butI[18])
				butI[18].setIcon(icon[i[18]]);

			else if(ae.getSource() == butI[19])
				butI[19].setIcon(icon[i[19]]);

			else if(ae.getSource() == butI[20])
				butI[20].setIcon(icon[i[20]]);

			else if(ae.getSource() == butI[21])
				butI[21].setIcon(icon[i[21]]);

			else if(ae.getSource() == butI[22])
				butI[22].setIcon(icon[i[22]]);
			
			else 
				butI[23].setIcon(icon[i[23]]);
			
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
				
				else if(ae.getSource() == butI[15])
					butI[15].setIcon(icon[i[15]]);
		
				else if(ae.getSource() == butI[16])
					butI[16].setIcon(icon[i[16]]);

				else if(ae.getSource() == butI[17])
					butI[17].setIcon(icon[i[17]]);
		
				else if(ae.getSource() == butI[18])
					butI[18].setIcon(icon[i[18]]);

				else if(ae.getSource() == butI[19])
					butI[19].setIcon(icon[i[19]]);
	
				else if(ae.getSource() == butI[20])
					butI[20].setIcon(icon[i[20]]);
	
				else if(ae.getSource() == butI[21])
					butI[21].setIcon(icon[i[21]]);

				else if(ae.getSource() == butI[22])
					butI[22].setIcon(icon[i[22]]);
			
				else 
					butI[23].setIcon(icon[i[23]]);

				
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
		for(int j=0;j<24;j++)
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
		for(int j=0;j<24;j++)
			butI[j].addActionListener(this);
	}	
	
	void isVisibl()
	{
		int cnt=0;
		boolean vis;
		
		for(int j=0;j<24;j++)
		{
			vis = butI[j].isVisible();
			if(!vis)
				cnt++;
		}
		
		if(cnt == 24)
		{
			score();
			DigitalClock.flag = false;
			lblCongrt.setVisible(true);
			lblCongrt.setText("Congratulations you Scored : " + score + " marks");
			lblContestant.setVisible(true);
			lblContestant.setText("Contestant Name : " + name); 
			butnPlayAgn.setVisible(true);
			butnQuit.setVisible(true);
		}
	}

	void score()
	{
		score = totPress;
		int rem = score % 24;
		score = score / 24;
		score = 100 / score - rem;
	}
	
	public static void main(String args[])
	{
		MemoryGameC mg = new MemoryGameC();	
	}
}					

