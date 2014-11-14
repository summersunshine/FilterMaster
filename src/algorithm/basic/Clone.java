package algorithm.basic;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Geometry;

/**
 * 获取一个图片的整体或者部分拷贝
 * */
public class Clone
{
	/**
	 * 整个图像拷贝
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				outputImage.setRGB(x, y, image.getRGB(x, y));
			}
		}

		return outputImage;

	}

	/**
	 * 部分图像拷贝
	 * 
	 * @param image
	 * @param rectangle
	 * */
	public static BufferedImage getImage(BufferedImage image, Rectangle rectangle)
	{
		return getImage(image, rectangle.x, rectangle.y, rectangle.width, rectangle.height);

	}

	/**
	 * 部分图像拷贝
	 * 
	 * @param image
	 * @param startX
	 * @param startY
	 * @param width
	 * @param height
	 * */
	public static BufferedImage getImage(BufferedImage image, int startX, int startY, int width, int height)
	{
		int endX = startX + width;
		int endY = startY + height;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > image.getWidth() ? image.getWidth() : endX;
		endY = endY > image.getHeight() ? image.getHeight() : endY;

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				outputImage.setRGB(x - startX, y - startY, image.getRGB(x, y));
			}
		}

		return outputImage;

	}
}
