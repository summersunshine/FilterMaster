package util;

public class Geometry
{

	/**
	 * ��ȡ����֮��ľ���
	 * 
	 * @param x1
	 *            ��һ�����X����
	 * @param y1
	 *            ��һ�����y����
	 * @param x2
	 *            �ڶ������X����
	 * @param y2
	 *            �ڶ������y����
	 * */
	public static int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		return (int) Math.sqrt(x * x + y * y);
	}

	/**
	 * ��ȡһ��Բ���ϵ�x���꼯��
	 * 
	 * @param x
	 *            ���ĵ��x����
	 * @param radius
	 *            Բ�ܵİ뾶
	 * @param num
	 *            �зֵ���Ŀ
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
	 * ��ȡһ��Բ���ϵ�y���꼯��
	 * 
	 * @param y
	 *            ���ĵ��y����
	 * @param radius
	 *            Բ�ܵİ뾶
	 * @param num
	 *            �зֵ���Ŀ
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
	 * ��ȡһ��Բ���ϵ�x���꼯��
	 * 
	 * @param x
	 *            ���ĵ��x����
	 * @param radius
	 *            Բ�ܵİ뾶 �зֵ���ĿĬ��Ϊ100
	 * */
	public static int[] getXPointsForCircle(int x, int radius)
	{
		return getXPointsForCircle(x, radius, 100);
	}

	/**
	 * ��ȡһ��Բ���ϵ�y���꼯��
	 * 
	 * @param y
	 *            ���ĵ��y����
	 * @param radius
	 *            Բ�ܵİ뾶 �зֵ���ĿĬ��Ϊ100
	 * */
	public static int[] getYPointsForCircle(int y, int radius)
	{
		return getYPointsForCircle(y, radius, 100);
	}

	/**
	 * �ж�һ�����Ƿ��ڶ����֮��
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
			if (polygon[i].x == pt.x && // �Ƿ��ڶ�����
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

						if (pt.x < _x) // ���ߵ����
							inside = !inside;
						else if (pt.x == _x) // ������
						{
							inside = true;
							break;
						}
					}
				}
				else if (pt.y == polygon[i].y)
				{
					if (pt.x < polygon[i].x) // �����ڶ�����
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
				else if (polygon[i].y == polygon[j].y && // ��ˮƽ�ı߽�����
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
