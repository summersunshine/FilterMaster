package util;

import java.awt.image.BufferedImage;

public class ImgUtil
{
	public static int[] getSplitRGB(int pixel)
	{
		int[] rgbs = new int[3];
		rgbs[0] = (pixel & 0xff0000) >> 16;
		rgbs[1] = (pixel & 0xff00) >> 8;
		rgbs[2] = (pixel & 0xff);
		return rgbs;
	}

	public static int getRGB(int r, int g, int b)
	{
		r = r << 16;
		g = g << 8;

		return (r | g | b);
	}
	
	public static BufferedImage rgb2gray(BufferedImage rgbImage)
	{
		int width = rgbImage.getWidth();
		int height = rgbImage.getHeight();
		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				int []rgb = getSplitRGB(rgbImage.getRGB(j, i));
				int averageRgb = (rgb[0] + rgb[1] + rgb[2])/3;
				grayImage.setRGB(j, i, getRGB(averageRgb,averageRgb,averageRgb));
			}
		}
		
		return grayImage;
	}
}
