package algorithm.basic;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import util.RGB;

/**
 * Èñ»¯
 */
public class Sharpen
{
	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		RGB[][] imageMatrix = new RGB[width][height];
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				RGB rgb = new RGB(image.getRGB(j, i));
				imageMatrix[j][i] = rgb;
			}
		}

		int[] templates =
		{ -1, -4, -7, -4, -1, -4, -16, -26, -16, -4, -7, -26, 505, -26, -7, -4, -16, -26, -16, -4, -1, -4, -7, -4, -1 };

		for (int y = 2; y < height - 2; y++)
		{
			for (int x = 2; x < width - 2; x++)
			{
				int sumR = 0;
				int sumG = 0;
				int sumB = 0;
				int index = 0;
				for (int m = x - 2; m < x + 3; m++)
				{
					for (int n = y - 2; n < y + 3; n++)
					{
						sumR += imageMatrix[m][n].r * templates[index];
						sumG += imageMatrix[m][n].g * templates[index];
						sumB += imageMatrix[m][n].b * templates[index++];
					}
				}
				sumR /= 273;
				sumG /= 273;
				sumB /= 273;

				sumR = ImgUtil.clamp(sumR);
				sumG = ImgUtil.clamp(sumG);
				sumB = ImgUtil.clamp(sumB);

				outputImage.setRGB(x, y, ImgUtil.getRGB(sumR, sumG, sumB));
			}
		}
		return outputImage;
	}
}
