package util;

public class Point
{
	// x����
	public float x;

	// y����
	public float y;

	/**
	 * ���캯��
	 * 
	 * @param x
	 * @param y
	 * */
	public Point(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * ���캯��
	 * 
	 * @param x
	 * @param y
	 * */
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Point()
	{
		this.x = 0;
		this.y = 0;
	}

	public float length()
	{
		return (float) Math.sqrt(x * x + y * y);
	}

	/**
	 * ��ֱ
	 */
	public Point perpendicularPoint()
	{
		return new Point(-y, x);
	}

	/**
	 * ��ȡ��λ����
	 * */
	public Point normalizePoint()
	{
		if (length() == 0)
		{
			return new Point();
		}
		else
		{
			return div(length());
		}
	}

	/**
	 * ����һ����
	 * 
	 * @param point
	 * */
	Point add(Point point)
	{
		return new Point(this.x + point.x, this.y + point.y);
	}

	/**
	 * ��ȥһ����
	 * 
	 * @param point
	 * */
	public Point sub(Point point)
	{
		return new Point(this.x - point.x, this.y - point.y);
	}

	/**
	 * ����һ��ֵ
	 * 
	 * @param m
	 * */
	Point mul(float m)
	{
		return new Point(m * this.x, m * this.y);
	}

	/**
	 * ����һ��ֵ
	 * 
	 * @param m
	 * */
	Point div(float m)
	{
		return new Point(this.x / m, this.y / m);
	}

	/**
	 * ��ȡ������֮��ľ���
	 * 
	 * @param point1
	 * @param point2
	 * */
	public static float getDistance(Point point1, Point point2)
	{
		return point1.sub(point2).length();
	}

	/**
	 * ��ȡ������֮����յ�
	 * 
	 * @param point1
	 * @param point2
	 * */
	public static Point getMidPoint(Point point1, Point point2)
	{
		return new Point((point1.x + point2.x) / 2.0f, (point1.y + point2.y) / 2.0f);
	}

	/**
	 * ��ȡ������֮���ĳһ��
	 * 
	 * @param point1
	 * @param point2
	 * @param percetage1
	 *            point1ռ�ݵı���
	 * */
	public static Point getPointBetweenTweenPoint(Point point1, Point point2, float percentage1)
	{
		float percentage2 = 1 - percentage1;
		float x = point1.x * percentage1 + point2.x * percentage2;
		float y = point1.y * percentage1 + point2.y * percentage2;
		return new Point(x, y);
	}

	/**
	 * ��ȡ������е�ĶԳƵ�
	 * 
	 * @param midPoint
	 * @param point
	 * */
	public static Point getSymmetryPoint(Point midPoint, Point point)
	{
		return midPoint.mul(2).sub(point);
	}
}
