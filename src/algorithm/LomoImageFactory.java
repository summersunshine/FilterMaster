package algorithm;

import java.awt.image.BufferedImage;

import algorithm.lomo.ClassicalLomo;
import algorithm.lomo.MemoryLomo;

public class LomoImageFactory
{

	/**
	 * 依据类型，图像，参数获取新的lomo图像
	 * 
	 * @param type
	 *            类型
	 * @param image
	 *            图像
	 * @param paramter
	 *            不定参数
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
