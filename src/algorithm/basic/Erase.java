package algorithm.basic;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Geometry;

/**
 * 擦除效果
 * */
public class Erase
{

	/**
	 * 擦除应用在源图片上的效果（圆形区域）
	 * 
	 * @param currImage
	 *            当前图片
	 * @param sourceImage
	 *            原图片
	 * @param centerX
	 *            擦除的中心点X坐标
	 * @param centerY
	 *            擦除的中心店Y坐标
	 * @param radius
	 *            擦除的半径
	 * */
	public static BufferedImage getImage(BufferedImage currImage, BufferedImage sourceImage, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > currImage.getWidth() ? currImage.getWidth() : endX;
		endY = endY > currImage.getHeight() ? currImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				if (Geometry.getDistance(x, y, centerX, centerY) < radius)
				{
					currImage.setRGB(x, y, sourceImage.getRGB(x, y));
				}
			}
		}
		return currImage;

	}
	
	
	/**
	 * 擦除应用在源图片上的效果（仅有原图片的情况下，擦除区域为圆形区域）
	 * 
	 * @param sourceImage
	 *            原图片
	 * @param centerX
	 *            擦除的中心点X坐标
	 * @param centerY
	 *            擦除的中心店Y坐标
	 * @param radius
	 *            擦除的半径
	 * */
	public static BufferedImage getImage(BufferedImage sourceImage, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > sourceImage.getWidth() ? sourceImage.getWidth() : endX;
		endY = endY > sourceImage.getHeight() ? sourceImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				if (Geometry.getDistance(x, y, centerX, centerY) < radius)
				{
					sourceImage.setRGB(x, y, 0x00ffffff);
				}
			}
		}
		return sourceImage;

	}
	

	/**
	 * 擦除应用在源图片上的效果（矩形区域）
	 * 
	 * @param currImage
	 *            当前图片
	 * @param sourceImage
	 *            原图片
	 * @param startX
	 *            擦除区域的起始X坐标
	 * @param startY
	 *            擦除区域的起始Y坐标
	 * @param width
	 *            擦除区域的宽度
	 * @param height
	 *            擦除区域的高度
	 * */
	public static BufferedImage getImage(BufferedImage currImage, BufferedImage sourceImage, int startX, int startY, int width, int height)
	{
		int endX = startX + width;
		int endY = startY + height;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > currImage.getWidth() ? currImage.getWidth() : endX;
		endY = endY > currImage.getHeight() ? currImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				currImage.setRGB(x, y, sourceImage.getRGB(x, y));
			}
		}
		return currImage;

	}

	/**
	 * 擦除应用在源图片上的效果（矩形区域）
	 * 
	 * @param currImage
	 *            当前图片
	 * @param sourceImage
	 *            原图片
	 * @param rectangle
	 *            擦除区域矩形
	 * */
	public static BufferedImage getImage(BufferedImage currImage, BufferedImage sourceImage, Rectangle rectangle)
	{
		return getImage(currImage, sourceImage, rectangle.x, rectangle.y, rectangle.width, rectangle.height);

	}

}
