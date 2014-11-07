package util;

public class Geometry
{

	public static int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		return (int) Math.sqrt(x * x + y * y);
	}
	
	
	public static int[] getXPoints(int x,int radius)
	{
		int num = 100;
		
		int [] xPoints = new int[num];
		
		for (int i = 0; i < num; i++)
		{
			xPoints[i] = (int) (x + radius*(Math.sin(i*Math.PI*2/num)));
		}
		
		return xPoints;
	}
	
	
	public static int[] getYPoints(int y,int radius)
	{
		int num = 100;
		
		int [] xPoints = new int[num];
		
		for (int i = 0; i < num; i++)
		{
			xPoints[i] = (int) (y + radius*(Math.cos(i*Math.PI*2/num)));
		}
		
		return xPoints;
	}
}
