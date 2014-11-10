package algorithm.lomo;

import java.awt.image.BufferedImage;

import util.Geometry;
import util.ImgUtil;

/**
 * LOMOÌØÐ§
 * */
public class Lomo
{

	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		float radius = width > height ? height : width;

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(y, x, height / 2, width / 2);
				if (distance > radius)
				{
					image.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
				} else
				{
					int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
					float ratio = (float) (1 - distance * 1.0 / radius);
					int r = (int) (rgb[0] * ratio);
					int g = (int) (rgb[1] * ratio);
					int b = (int) (rgb[2] * ratio);
					image.setRGB(x, y, ImgUtil.getRGB(r, g, b));
				}
			}
		}

		return image;
	}

	public static BufferedImage getImage(BufferedImage image, int radius)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(y, x, height / 2, width / 2);
				if (distance > radius)
				{
					image.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
				} else
				{
					int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
					float ratio = (float) (1 - distance * 1.0 / radius);
					int r = (int) (rgb[0] * ratio);
					int g = (int) (rgb[1] * ratio);
					int b = (int) (rgb[2] * ratio);
					image.setRGB(x, y, ImgUtil.getRGB(r, g, b));
				}
			}
		}

		return image;
	}

}
