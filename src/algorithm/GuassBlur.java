package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import util.RGB;

/**
 * ¸ßË¹Ä£ºý
 * */
public class GuassBlur
{
	public static BufferedImage getImage(BufferedImage image)
	{

		int height = image.getHeight();
		int width = image.getWidth();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		RGB[][] imageMatrix = new RGB[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgb = new RGB(image.getRGB(x, y));
				imageMatrix[x][y] = rgb;
			}
		}

		for (int y = 1; y < height - 1; y++)
		{
			for (int x = 1; x < width - 1; x++)
			{

				int r = imageMatrix[x - 1][y - 1].r + 2 * imageMatrix[x - 1][y].r + imageMatrix[x - 1][y + 1].r + 2 * imageMatrix[x][y - 1].r + 4
						* imageMatrix[x][y].r + 2 * imageMatrix[x][y + 1].r + imageMatrix[x + 1][y - 1].r + 2 * imageMatrix[x + 1][y].r
						+ imageMatrix[x + 1][y + 1].r;

				int g = imageMatrix[x - 1][y - 1].g + 2 * imageMatrix[x - 1][y].g + imageMatrix[x - 1][y + 1].g + 2 * imageMatrix[x][y - 1].g + 4
						* imageMatrix[x][y].g + 2 * imageMatrix[x][y + 1].g + imageMatrix[x + 1][y - 1].g + 2 * imageMatrix[x + 1][y].g
						+ imageMatrix[x + 1][y + 1].g;

				int b = imageMatrix[x - 1][y - 1].b + 2 * imageMatrix[x - 1][y].b + imageMatrix[x - 1][y + 1].b + 2 * imageMatrix[x][y - 1].b + 4
						* imageMatrix[x][y].b + 2 * imageMatrix[x][y + 1].b + imageMatrix[x + 1][y - 1].b + 2 * imageMatrix[x + 1][y].b
						+ imageMatrix[x + 1][y + 1].b;

				r = r / 16;
				g = g / 16;
				b = b / 16;

				r = ImgUtil.clamp(r);
				g = ImgUtil.clamp(g);
				b = ImgUtil.clamp(b);

				outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));

			}
		}

		return outputImage;

	}
}
