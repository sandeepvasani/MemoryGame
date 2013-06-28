

public class DigitalClock extends Thread
{
    	long timeS, timeM;
	String time;
	static boolean flag = true;

	public void run()
    	{
        	while(flag)
		{
			try{
	    			Thread.sleep(999);
			}
			catch(Exception ex)
			{}
			timeS++;
			if(timeS == 60)
			{
				timeM++;
				timeS = 0;
			}
			String time = (timeM + ":" + timeS);
			
			switch(UserLogin.rpress)
			{
				case 1: 
					MemoryGameA.lblTimeVal.setText(time);
					break;
				case 2:
					MemoryGameB.lblTimeVal.setText(time);
					break;
				case 3:
					MemoryGameC.lblTimeVal.setText(time);
			}	
		}
	}
	
	public static void main(String args[])
	{
		DigitalClock dc = new DigitalClock();
		dc.start();
	}

    
}