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

	/**
	 * 判断一个点是否在多边形之内
	 * 
	 * @param polygon
	 * @param pt
	 * */
	boolean isInsidePolygon(Point[] polygon, Point pt)
	{
		int i, j;
		boolean inside = false, redo = true;

		for (i = 0; i < polygon.length; ++i)
		{
			if (polygon[i].x == pt.x && // 是否在顶点上
					polygon[i].y == pt.y)
			{
				redo = false;
				inside = true;
				break;
			}
		}

		while (redo)
		{
			redo = false;
			inside = false;
			for (i = 0, j = polygon.length - 1; i < polygon.length; j = i++)
			{
				if ((polygon[i].y < pt.y && pt.y < polygon[j].y) || (polygon[j].y < pt.y && pt.y < polygon[i].y))
				{
					if (pt.x <= polygon[i].x || pt.x <= polygon[j].x)
					{
						double _x = (pt.y - polygon[i].y) * (polygon[j].x - polygon[i].x) / (polygon[j].y - polygon[i].y) + polygon[i].x;

						if (pt.x < _x) // 在线的左侧
							inside = !inside;
						else if (pt.x == _x) // 在线上
						{
							inside = true;
							break;
						}
					}
				}
				else if (pt.y == polygon[i].y)
				{
					if (pt.x < polygon[i].x) // 交点在顶点上
					{
						if (polygon[i].y > polygon[j].y)
						{
							--pt.y;
						}
						else
						{
							++pt.y;
						}
						redo = true;
						break;
					}
				}
				else if (polygon[i].y == polygon[j].y && // 在水平的边界线上
						pt.y == polygon[i].y && ((polygon[i].x < pt.x && pt.x < polygon[j].x) || (polygon[j].x < pt.x && pt.x < polygon[i].x)))
				{
					inside = true;
					break;
				}
			}
		}

		return inside;
	}

}
