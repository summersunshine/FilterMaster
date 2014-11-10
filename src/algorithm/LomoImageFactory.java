package algorithm;

import java.awt.image.BufferedImage;

import algorithm.lomo.Lomo;

public class LomoImageFactory
{

	/**
	 * �������ͣ�ͼ�񣬲�����ȡ�µ�lomoͼ��
	 * 
	 * @param type
	 *            ����
	 * @param image
	 *            ͼ��
	 * @param paramter
	 *            ��������
	 * */
	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_LOMO_CLASSIC):
			return Lomo.getImage(image);
		default:
			return null;
		}
	}
}
