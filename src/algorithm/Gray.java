package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

/**
 * ª“∂»Õº
 * */
public class Gray
{
	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
				int averageRgb = (rgb[0] + rgb[1] + rgb[2]) / 3;

				outputImage.setRGB(x, y, ImgUtil.getRGB(averageRgb, averageRgb, averageRgb));
			}
		}

		return outputImage;
	}
}
