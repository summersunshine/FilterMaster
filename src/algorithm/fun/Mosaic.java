package algorithm.fun;

import java.awt.image.BufferedImage;

import util.ImgUtil;

/**
 * ÂíÈü¿Ë
 * */
public class Mosaic
{
	public static BufferedImage getImage(BufferedImage image, int size)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		int r = 0, g = 0, b = 0;
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				if (y % size == 0)
				{
					if (x % size == 0)
					{
						int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
						r = rgb[0];
						g = rgb[1];
						b = rgb[2];
					} else
					{
						outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));
					}
				} else
				{
					outputImage.setRGB(x, y, outputImage.getRGB(x, y - 1));
				}

			}
		}

		return outputImage;
	}
}
