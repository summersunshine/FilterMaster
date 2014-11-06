package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

/**
 * π‚’’
 * */
public class Laser
{
	private static float threshold = 0.5f;
	private static float strength = 0.8f;

	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		int[] pixels = new int[width];
		int[] srcPixels = new int[width];

		BufferedImage laserImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		int threshold3 = (int) (threshold * 3 * 255);
		for (int y = 0; y < height; y++)
		{
			ImgUtil.getRGB(image, pixels, 0, y, width, 1);
			for (int x = 0; x < width; x++)
			{
				int rgb = pixels[x];
				int a = rgb & 0xff000000;
				int r = (rgb >> 16) & 0xff;
				int g = (rgb >> 8) & 0xff;
				int b = rgb & 0xff;
				int l = r + g + b;
				if (l < threshold3)
					pixels[x] = 0xff000000;
				else
				{
					l /= 3;
					pixels[x] = a | (l << 16) | (l << 8) | l;
				}
			}
			ImgUtil.setRGB(laserImg, pixels, 0, y, width, 1);
		}

		laserImg = MotionBlur.getImage(laserImg);

		for (int y = 0; y < height; y++)
		{
			ImgUtil.getRGB(laserImg, pixels, 0, y, width, 1);
			ImgUtil.getRGB(image, srcPixels, 0, y, width, 1);
			for (int x = 0; x < width; x++)
			{
				int rgb = pixels[x];
				int a = rgb & 0xff000000;
				int r = (rgb >> 16) & 0xff;
				int g = (rgb >> 8) & 0xff;
				int b = rgb & 0xff;

				int rgb2 = srcPixels[x];
				// int a2 = rgb2 & 0xff000000;
				int r2 = (rgb2 >> 16) & 0xff;
				int g2 = (rgb2 >> 8) & 0xff;
				int b2 = rgb2 & 0xff;

				if (r > 0)
				{
					r = ImgUtil.clamp((int) (r * strength) + r2);
					g = ImgUtil.clamp((int) (g * strength) + g2);
					b = ImgUtil.clamp((int) (b * strength) + b2);
				} else
				{
					r = r2;
					g = g2;
					b = b2;
				}

				rgb = a | (r << 16) | (g << 8) | b;
				pixels[x] = rgb;
			}
			ImgUtil.setRGB(laserImg, pixels, 0, y, width, 1);
		}

		return laserImg;
	}
}
