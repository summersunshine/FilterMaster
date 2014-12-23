package algorithm.basic;

import java.awt.image.BufferedImage;

/**
 * 更改图像的alpha值
 * */
public class Alpha
{
	/**
	 * 整个图像拷贝
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image, int alpha)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				image.setRGB(x, y, image.getRGB(x, y) | ((alpha) << 24));
			}
		}

		return image;

	}
}
