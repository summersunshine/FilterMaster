package algorithm.fun;

import java.awt.image.BufferedImage;

import util.Geometry;
import util.ImgUtil;
import util.RGB;

/**
 * 马赛克
 * */
public class Mosaic
{
	
	/**
	 * 马赛克滤镜
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		return getImage(image, 12);
	}
	
	
	/**
	 * 马赛克滤镜
	 * 
	 * @param image
	 * @param size
	 * */
	public static BufferedImage getImage(BufferedImage image,int size)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		int r = 0, g = 0, b = 0;
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int targetX = (x / size) * size;
				int targetY = (y / size) * size;
				image.setRGB(x, y, image.getRGB(targetX, targetY));

			}
		}

		return outputImage;
	}

	
	/**
	 * 局部马赛克
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image,int centerX, int centerY, int radius)
	{
		return getImage(image, 12,centerX,centerY,radius);
	}
	
	
	
	/**
	 * 局部马赛克
	 * 
	 * @param image
	 * @param centerX
	 * @param centerY
	 * @param radius
	 * */
	public static BufferedImage getImage(BufferedImage image,int size, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{

				if (Geometry.getDistance(x, y, centerX, centerY) < radius && ImgUtil.isInsideImage(image, x, y))
				{
					int targetX = (x / size) * size;
					int targetY = (y / size) * size;
					image.setRGB(x, y, image.getRGB(targetX, targetY));
				}
			}
		}

		return image;
	}

}
