package algorithm.art;

import java.awt.image.BufferedImage;

import util.ImgUtil;

/**
 * 铅笔
 * */
public class Pencil
{
	public static BufferedImage getImage(BufferedImage image, int sensitivity)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int m, n;
		for (int y = 0; y < height - 1; y++)
		{
			n = y + 1;
			for (int x = 0; x < width - 1; x++)
			{
				m = x + 1;
				// 当前灰度
				int color = getColor(image.getRGB(x, y));

				// 下一个点的灰度
				int nextColor = getColor(image.getRGB(m, n));

				if (color - nextColor > sensitivity)
				{
					outputImage.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
				} else
				{
					outputImage.setRGB(x, y, ImgUtil.getRGB(255, 255, 255));
				}
			}
		}

		return outputImage;
	}

	public static int getColor(int rgb)
	{
		int[] rgbColor = ImgUtil.getSplitRGB(rgb);
		int color = (int) ((rgbColor[0] * 3 + rgbColor[1] * 6 + rgbColor[2]) / 10.0);
		return color;
	}
}
