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

}
