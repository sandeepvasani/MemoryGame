

class Wait
{
	public static void manySec(long s)
	{
		try
		{
			Thread.currentThread().sleep(s * 100);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
}