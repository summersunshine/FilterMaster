package algorithm.blur;

import java.awt.image.BufferedImage;

/**
 * 加倍高斯模糊
 * */
public class DoubleGuassBlur
{

	public static BufferedImage getImage(BufferedImage image)
	{
		return GuassBlur.getImage(GuassBlur.getImage(image));
	}

	public static BufferedImage getImage(BufferedImage image, int x, int y, int radius)
	{
		return GuassBlur.getImage(GuassBlur.getImage(image, x, y, radius), x, y, radius);
	}

}
