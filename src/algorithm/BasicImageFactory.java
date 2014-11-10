package algorithm;

import java.awt.image.BufferedImage;

import algorithm.basic.Gray;
import algorithm.basic.IntensityAndContrast;
import algorithm.basic.Inverse;
import algorithm.basic.Scale;
import algorithm.basic.Sharpen;

public class BasicImageFactory
{

	/**
	 * 依据类型，图像，参数获取新的基础图像
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

		case (Constants.TYPE_GRAY):
			return Gray.getImage(image);
		case (Constants.TYPE_INTENSITY_CONTRAST):
			return IntensityAndContrast.getImage(image, (int) (parameter[0]), (int) (parameter[1]), (int) (parameter[2]));
		case (Constants.TYPE_INVERSE):
			return Inverse.getImage(image);
		case (Constants.TYPE_SCALE):
			return Scale.getImage(image, (int) (parameter[0]), (int) (parameter[1]));
		case (Constants.TYPE_SHARPEN):
			return Sharpen.getImage(image);
		default:
			return null;
		}

	}

}
