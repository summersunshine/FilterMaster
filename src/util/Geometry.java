package util;

public class Geometry
{

	/**
	 * 获取两点之间的距离
	 * 
	 * @param x1
	 *            第一个点的X坐标
	 * @param y1
	 *            第一个点的y坐标
	 * @param x2
	 *            第二个点的X坐标
	 * @param y2
	 *            第二个点的y坐标
	 * */
	public static int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		return (int) Math.sqrt(x * x + y * y);
	}

	/**
	 * 获取一个圆周上的x坐标集合
	 * 
	 * @param x
	 *            中心点的x坐标
	 * @param radius
	 *            圆周的半径
	 * @param num
	 *            切分的数目
	 * */
	public static int[] getXPointsForCircle(int x, int radius, int num)
	{
		int[] xPoints = new int[num];

		for (int i = 0; i < num; i++)
		{
			xPoints[i] = (int) (x + radius * (Math.sin(i * Math.PI * 2 / num)));
		}

		return xPoints;
	}

	/**
	 * 获取一个圆周上的y坐标集合
	 * 
	 * @param y
	 *            中心点的y坐标
	 * @param radius
	 *            圆周的半径
	 * @param num
	 *            切分的数目
	 * */
	public static int[] getYPointsForCircle(int y, int radius, int num)
	{

		int[] xPoints = new int[num];

		for (int i = 0; i < num; i++)
		{
			xPoints[i] = (int) (y + radius * (Math.cos(i * Math.PI * 2 / num)));
		}

		return xPoints;
	}

	/**
	 * 获取一个圆周上的x坐标集合
	 * 
	 * @param x
	 *            中心点的x坐标
	 * @param radius
	 *            圆周的半径 切分的数目默认为100
	 * */
	public static int[] getXPointsForCircle(int x, int radius)
	{
		return getXPointsForCircle(x, radius, 100);
	}

	/**
	 * 获取一个圆周上的y坐标集合
	 * 
	 * @param y
	 *            中心点的y坐标
	 * @param radius
	 *            圆周的半径 切分的数目默认为100
	 * */
	public static int[] getYPointsForCircle(int y, int radius)
	{
		return getYPointsForCircle(y, radius, 100);
	}

}
