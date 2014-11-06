package algorithm;

import java.awt.image.BufferedImage;

import util.RGB;

/**
 * ¸ºÆ¬
 * */
public class Inverse
{
	public static BufferedImage getImage(BufferedImage image)
	{
		int height = image.getHeight();
		int width = image.getWidth();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgb = new RGB(image.getRGB(x, y));
				RGB reverseRgb = new RGB(255 - rgb.r, 255 - rgb.g, 255 - rgb.b);
				outputImage.setRGB(x, y, reverseRgb.getRGB());
			}
		}
		return outputImage;

	}
}
