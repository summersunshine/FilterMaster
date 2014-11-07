package algorithm.basic;

import java.awt.image.BufferedImage;

import util.Geometry;

/**
 * ²Á³öÐ§¹û
 * */
public class Erase
{
	public static BufferedImage getImage(BufferedImage displayImage, BufferedImage sourceImage, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > displayImage.getWidth() ? displayImage.getWidth() : endX;
		endY = endY > displayImage.getHeight() ? displayImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				if (Geometry.getDistance(x, y, centerX, centerY) < radius)
				{
					displayImage.setRGB(x, y, sourceImage.getRGB(x, y));
				}
			}
		}
		return displayImage;

	}

}
