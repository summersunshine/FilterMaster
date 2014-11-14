package algorithm.lomo;

import java.awt.image.BufferedImage;

import util.Geometry;
import util.ImgUtil;

/**
 * 经典LOMO特效
 * */
public class ClassicalLomo
{

	/**
	 * 获取lomo特效
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		float radius = width < height ? height : width;

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(y, x, height / 2, width / 2);
				if (distance > radius)
				{
					outputImage.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
				}
				else
				{
					int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
					float ratio = (float) (1 - distance * 1.0 / radius);
					int r = (int) (rgb[0] * ratio);
					int g = (int) (rgb[1] * ratio);
					int b = (int) (rgb[2] * ratio);
					outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));
				}
			}
		}

		return outputImage;
	}

	
	/**
	 * 获取lomo特效，在一定的范围内
	 * @param image
	 * @param radius
	 * */
	public static BufferedImage getImage(BufferedImage image, int radius)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(y, x, height / 2, width / 2);
				if (distance > radius)
				{
					outputImage.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
				}
				else
				{
					int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
					float ratio = (float) (1 - distance * 1.0 / radius);
					int r = (int) (rgb[0] * ratio);
					int g = (int) (rgb[1] * ratio);
					int b = (int) (rgb[2] * ratio);
					outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));
				}
			}
		}

		return outputImage;
	}

}
