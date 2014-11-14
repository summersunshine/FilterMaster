package algorithm;

import java.awt.image.BufferedImage;

import algorithm.lomo.ClassicalLomo;
import algorithm.lomo.MemoryLomo;

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
			return ClassicalLomo.getImage(image);
		case(Constants.TYPE_LOMO_MEMORY):
			return MemoryLomo.getImage(image);
		default:
			return null;
		}
	}
}
