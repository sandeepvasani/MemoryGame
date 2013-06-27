package memorygame;

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
			MemoryGame.lblTimeVal.setText(time);	
		}
	}
	
	public static void main(String args[])
	{
		DigitalClock dc = new DigitalClock();
		dc.start();
	}

    
}